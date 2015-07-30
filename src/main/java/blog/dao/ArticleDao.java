package blog.dao;

import blog.model.Article;
import blog.model.Comment;
import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created with IntelliJ IDEA.
 * User: sidona
 * Date: 7/12/15
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ArticleDao {

    @Autowired
    private MongoOperations mongoOperations;

    private static final Logger log = Logger.getLogger(ArticleDao.class);

    public Article findArticlebyPermalink(String permalink) {
        return mongoOperations.findOne(
                Query.query(Criteria.where("permalink").is(permalink)),
                Article.class);
    }
    public Article findById(String id) {
        Query query = query(where("_id").is(new ObjectId(id)));
        return mongoOperations.findOne(query, Article.class);
    }


    public List<Article> findByDateDescending(int limit) {
        Query query = new Query().with(sortByDateDesc()).limit(limit);
        return mongoOperations.find(query, Article.class);
    }

    public List<Article> findByTagDateDescending(String tag) {
        return mongoOperations.find(Query.query(Criteria.where("tag").is(tag))
                .with(sortByDateDesc()).limit(10), Article.class);
    }


    private Sort sortByDateDesc() {
        return new Sort(Sort.Direction.DESC, "date");
    }

    public String addArticle(String title, String content, List<String> tags
    ) {
        //String permalink = title.replaceAll("\\s", "_"); // whitespace becomes _
        //permalink = permalink.replaceAll("\\W", ""); // get rid of non

        // permalink = permalink.toLowerCase();
        Article article = new Article();
        article.setId((new BasicDBObject()).getString("_id"));
        article.setTitle(title);
        //article.setAuthor(username);
        article.setContent(content);
        // article.setPermalink(permalink);
        article.setTags(tags);
        article.setComments(new ArrayList<Comment>());
        article.setDate(new Date());
        /*try {
            mongoOperations.insert(article);
            log.info("Inserting blogpost with permalink " + permalink);
        } catch (Exception e) {
            log.error("Error inserting post");
        }  */
        mongoOperations.insert(article);
        return title;
    }
    public Article save(Article article) {
        mongoOperations.save(article);
        return article;
    }
    public void addArticleComment(Article article, Comment comment) {
        article.getComments().add(comment);
        mongoOperations.save(article);
    }
    public List<Article> findAll(Class<Article> articleClass) {
        return mongoOperations.findAll(Article.class);
    }
    public List<Article> findByAuthor(String author) {
        Query query = query(where("authorsList").is(author));
        return mongoOperations.find(query, Article.class);
    }




}

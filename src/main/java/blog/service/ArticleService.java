package blog.service;

import blog.dao.ArticleDao;
import blog.model.Article;
import blog.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public Article findArticleByPermalink(String permalink) {
        return articleDao.findArticlebyPermalink(String.valueOf(permalink));
    }

    public List<Article> findByDateDescending(int limit) {
        return articleDao.findByDateDescending(limit);
    }

    public List<Article> findByTagDateDescending(final String tag) {
        return articleDao.findByTagDateDescending(tag);
    }
    public Article findById(String id) {
        return articleDao.findById(id);
    }

    public String addArticle(String title, String content, List<String> tags) {
        return articleDao.addArticle(title, content, tags);
    }

    public void addArticleComment(Article article, Comment comment) {
        articleDao.addArticleComment(article, comment);
    }
    public List<Article> findByAuthor(String author) {
        return articleDao.findByAuthor(author);
    }


    public List<Article> findAll() {
        return articleDao.findAll(Article.class);
    }
    public Article save(Article article) {
        articleDao.save(article);
        return article;
    }


}

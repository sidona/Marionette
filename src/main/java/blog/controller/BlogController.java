package blog.controller;

import blog.model.Article;
import blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
 public class BlogController {


    private static final String ARTICLES_ATTRIBUTE = "myarticles";
    private static final String ARTICLE_ATTRIBUTE = "article";

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Article> blog(Model model) {

        List<Article> articles = articleService.findByDateDescending(10);
        model.addAttribute(ARTICLES_ATTRIBUTE, articles);
        return articleService.findByDateDescending(10);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean addIntoCollection(@RequestBody Article article) {
        this.articleService.save(article);
        return true;
    }





}

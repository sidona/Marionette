package blog.controller;

import blog.model.Article;
import blog.model.Comment;
import blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article/newcomment")
public class CommentController {

    @Autowired
    private ArticleService articleService;





    @RequestMapping(value="/{id}/comments",method = RequestMethod.PUT)
    public @ResponseBody
    boolean addComment(@PathVariable String id , @RequestBody Comment comment){

        Article article = articleService.findById(id);
        article.getComments().add(comment);
        articleService.save(article);
        return true;

    }
}

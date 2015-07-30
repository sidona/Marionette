package blog.controller;

import blog.model.Article;
import blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/newarticle")
public class NewArticleController {



    @Autowired
    private ArticleService articleService;


    /* @ModelAttribute
     @RequestMapping(method = RequestMethod.GET)
     public String newarticle(HttpSession session, Model model) {


             NewArticle newArticle = new NewArticle();
             model.addAttribute(newArticle);
             return "newarticle";
         }


     @RequestMapping(method = RequestMethod.POST)
     public String NewArticle( @ModelAttribute NewArticle newArticle,
                                 BindingResult result, HttpSession session,HttpServletResponse response) {
         response.setHeader("Access-Control-Allow-Origin", "*");

         if (result.hasErrors()) {
             return "newarticle";
         }
          else {
             List<String> tagsAsList = extractTags(newArticle.getTags());
             String title = articleService.addArticle(newArticle.getTitle(),
                     newArticle.getContent(), tagsAsList);
             return "contacts";
         }
     }

     private List<String> extractTags(String tags) {
         tags = tags.replaceAll("\\s", "");
         String tagArray[] = tags.split(",");
         ArrayList<String> cleaned = new ArrayList<String>();
         for (String tag : tagArray) {
             if (!tag.equals("") && !cleaned.contains(tag)) {
                 cleaned.add(tag);
             }
         }
         return cleaned;
     }
        */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean addIntoCollection(@RequestBody Article article) {
        this.articleService.save(article);
        return true;
    }

}


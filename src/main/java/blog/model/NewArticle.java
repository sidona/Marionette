package blog.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sidona
 * Date: 7/12/15
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewArticle implements Serializable {

    private String title;
    private String content;
    private String tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}

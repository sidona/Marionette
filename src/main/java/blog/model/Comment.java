package blog.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sidona
 * Date: 7/12/15
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comment implements Serializable {

    private String author;
    private String content;
    private String email;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

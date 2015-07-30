package blog.cors;

import blog.model.Comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObscenWord  {
    public static Comment replaceMatureWord(Comment comment){
        String commentWords[] = comment.getContent().split(" ");
        StringBuilder sb = new StringBuilder("");
        for(String word : commentWords){
            if(BAD_WORDS.contains(word)){
                sb.append("****");
            }else{
                sb.append(word + " ");
            }
        }
        comment.setContent(sb.toString());
        return comment;
    }

    public static List<String > BAD_WORDS = new ArrayList<String>(Arrays.asList("fuck", "fuck off", "prick", "asshole"));

}

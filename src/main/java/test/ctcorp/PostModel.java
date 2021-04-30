package test.ctcorp;

import java.util.List;

public class PostModel {
    private String id;
    private String title;
    private String content;
    private List<String> tags;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }
    public List<String> getTags(){
        return this.tags;
    }

}

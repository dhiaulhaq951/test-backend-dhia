package test.ctcorp;

import java.util.List;

public class TagModel {

    private String id;
    private String label;
    private List<PostModel> posts;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setLabel(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }

    public void setPosts(List<PostModel> posts){
        this.posts = posts;
    }
    public List<PostModel> getPosts(){
        return this.posts;
    }
    
}

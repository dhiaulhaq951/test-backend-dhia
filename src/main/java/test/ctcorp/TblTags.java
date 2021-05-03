package test.ctcorp;

import java.util.List;
import javax.persistence.*;

@Entity
public class TblTags {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String label;

    @ManyToMany(mappedBy = "tags")
    private List<TblPost> posts;

    public void setId(Long id){
        this.id = id;
    }    

    public Long getId(){
        return this.id;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public void setPosts(List<TblPost> posts){
        this.posts = posts;
    }

    public List<TblPost> getPosts(){
        return this.posts;
    }
    
}

package test.ctcorp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/post")
public class PostResource {

    List<PostModel> listposts = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPosts(){
        return Response.ok(listposts).build();
    }

    @GET
    @Path("/size")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer countPosts(){
        return listposts.size();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPost(PostModel postModel){
        listposts.add(postModel);
        return Response.ok(listposts).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePost(PostModel postModel){
        listposts.forEach(post -> {
            if(post.getId().equals(postModel.getId())){
                post.setContent(postModel.getContent());
                post.setTags(postModel.getTags());
                post.setTitle(postModel.getTitle());
            }
        });
        return Response.ok(listposts).build();
    }

    @DELETE
    @Path("{postId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePost(@PathParam("postId") String postId){
        Optional<PostModel> postToDelete = listposts.stream().filter(e -> {
            if(e.getId().equals(postId)){
                return true;
            }
            return false;
        }).findFirst();
        
        boolean removed = postToDelete.isPresent() ? listposts.remove(postToDelete.get()) : false;
        
        if(removed){
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }    
    
}

package task2;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeserializePost 
{
	@Test
    public void deserializePost() 
	{

        Post post =

            given()

            .when()
            .get("https://dummyjson.com/posts/1")

            .then()
            .statusCode(200)
            .extract()
            .as(Post.class); //deserialization

        
        System.out.println("Post ID: " + post.getId());
        System.out.println("Post Title: " + post.getTitle());
        System.out.println("Post Body: " + post.getBody());
        System.out.println("Tags: " + post.getTags());
        System.out.println("Likes: " + post.getReactions().getLikes());
        System.out.println("Dislikes: " + post.getReactions().getDislikes());
        System.out.println("Views: " + post.getViews());
        System.out.println("User ID: " + post.getUserId());
        //printing the values using get method
    }
}




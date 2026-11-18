package task1;

import org.testng.annotations.Test;

import pojo.CompleteResponse;
import pojo.PostsArray;
import pojo.Reactions;

import java.util.List;

import static io.restassured.RestAssured.*;

public class DeserialiseGetAllPosts {

    @Test
    public void getAllUserDetails() {

        CompleteResponse response =
            given()

            .when()
                .get("https://dummyjson.com/posts")

            .then()
                .statusCode(200)
                .extract()
                .as(CompleteResponse.class);

        // Get total number of posts
        System.out.println("Total Posts: " + response.getTotal());

        // Get all posts
        List<PostsArray> posts = response.getPosts();

        // Print post details
        for (PostsArray post : posts) {

            System.out.println("ID: " + post.getId());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Body: " + post.getBody());
            System.out.println("Tags: " + post.getTags());
            System.out.println("Likes: " + post.getReactions().getLikes());
            System.out.println("Dislikes: " + post.getReactions().getDislikes());
            System.out.println("Views: " + post.getViews());
            System.out.println("User ID: " + post.getUserId());

        }
    }
}

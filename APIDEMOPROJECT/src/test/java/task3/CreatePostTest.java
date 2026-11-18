package task3;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import task3.Post;

import org.testng.Assert;
import static io.restassured.RestAssured.*;

public class CreatePostTest 
{
	 @Test
	    public void createPost() {

	        // Step 1: Create Post POJO object
	        Post post = new Post();

	        // Step 2: Set values using setter methods
	        post.setTitle("API Automation Testing");
	        post.setBody("Learning Rest Assured");
	        post.setUserId(5);

	        // Step 3: Send POST request
	        Response response =
	                given()
	                .contentType("application/json")
	                .body(post)

	                .when()
	                .post("https://dummyjson.com/posts/add");
	                
	        // Step 4: Validate status code
	        Assert.assertEquals(response.getStatusCode(), 201);

	        // Step 5: Validate response title
	        Assert.assertEquals(response.jsonPath().getString("title"),"API Automation Testing");

	        // Step 6: Validate response body
	        Assert.assertEquals(response.jsonPath().getString("body"),"Learning Rest Assured");

	        // Step 7: Deserialize response into POJO
	        Post responsePost = response.as(Post.class);

	        // Step 8: Validate returned values using getters
	        Assert.assertEquals(responsePost.getTitle(),"API Automation Testing");

	        Assert.assertEquals(responsePost.getBody(),"Learning Rest Assured");

	        Assert.assertEquals(responsePost.getUserId(), 5);

	        Assert.assertTrue(responsePost.getId() > 0);

	        // Step 9: Print response values
	        System.out.println("Post ID: " + responsePost.getId());
	        System.out.println("Title: " + responsePost.getTitle());
	        System.out.println("Body: " + responsePost.getBody());
	        System.out.println("User ID: " + responsePost.getUserId());
	    }
	}


package task2;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ValidateGetRequestOfSingleUser 
{
	@Test
	public void validateSingleUser()
	{
		given()
		.when()
	    .get("https://dummyjson.com/posts/1")
	    .then()
	    .statusCode(200) //checks whether statuscode is 200
	    .body("id",equalTo(1))//checks whether id is equal to 1
	    .body("title",not(empty()))//checks whether title is empty
	    .body("title",notNullValue())//checks whether title is null
	    .body("body",not(empty()))//checks whether body is empty
	    .body("body",notNullValue());//checks whether body is null
	    
	}
	
    
}

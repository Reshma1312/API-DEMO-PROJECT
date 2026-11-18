
package task1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ValidateGetRequest {

    @Test
    public void getAllUserDetails() {

        given()

        .when()
            .get("https://dummyjson.com/posts")

        .then()
            .statusCode(200)
            .time(lessThan(3000L))
            .header("Content-Type",containsString("application/json"))
            .body("posts[0].id", equalTo(1))
            .body("posts[0].title",equalTo("His mother had always taught him"))
            .body("posts[0].body",containsString("He'd tried to live by this motto"))
            .body("posts.size()",greaterThan(0))
            .body("posts",instanceOf(List.class))
            .log().body();
        //validate that response contains a posts array
        //deserialize the response into java POJO classes
    }
}


package reports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static io.restassured.RestAssured.*;

public class ExtentReport {

    @Test
    public void getUser() {

        // Step 1: Create Spark Reporter
        ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        // Step 2: Create ExtentReports object
        ExtentReports extent = new ExtentReports();

        // Step 3: Attach reporter
        extent.attachReporter(spark);

        // Step 4: Create individual test entry
        ExtentTest test = extent.createTest("get user api");

        try {

            test.info("Sending GET request");

            // Step 5: Send GET request
            given()
                .when()
                .get("https://dummyjson.com/posts")
                .then()
                .statusCode(200);

            test.pass("GET API executed successfully");

        } catch (AssertionError e) {

            test.fail("API validation failed");
            test.fail(e);
            throw e;

        } catch (Exception e) {

            test.fail("An exception occurred");
            test.fail(e);
            throw e;

        } finally {

            // Step 6: Generate HTML report
            extent.flush();
            //latest tc will not generate if we dont give flush method
        }
    }
}

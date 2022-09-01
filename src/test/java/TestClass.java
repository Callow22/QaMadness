import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestClass {
    
    @Test
    public void testMethod(){
        RestAssured.baseURI = "https://swapi.dev/api/starships/9/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().request(Method.GET, "");
        response.then().assertThat().statusCode(200).body(matchesJsonSchemaInClasspath("starships.json"));
    }
}

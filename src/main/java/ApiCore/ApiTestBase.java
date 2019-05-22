package ApiCore;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    protected static RequestSpecification spec;
    protected ObjectMapper objectMapper = new ObjectMapper();
    protected static String baseURL = "https://a0f6ce18-9c13-4b65-acb0-71583e8d88b9.mock.pstmn.io/testurl.com";

    @BeforeAll
    public static void setUp(){

        spec = new RequestSpecBuilder()
                .setBaseUri(baseURL)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                //.addFilter(new ResponseLoggingFilter())
                .build();
    }

    protected String getResource(String location, int statusCode){
        return RestAssured.given()
                .header("Content-Type","text/html; charset=utf-8")
                .spec(spec)
                .expect()
                .statusCode(statusCode)
                .when()
                .get(location)
                .thenReturn().getBody().asString();
    }

}
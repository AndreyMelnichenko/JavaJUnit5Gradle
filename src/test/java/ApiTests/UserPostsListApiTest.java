package ApiTests;

import ApiCore.ApiTestBase;
import Respons.PostRK;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserPostsListApiTest extends ApiTestBase {

    @Test
    public void amountByUserId() throws IOException {

        String getPosts = getResource(baseURL,200);

        PostRK[] postList = objectMapper.readValue(getPosts,PostRK[].class);
        List<String> userPosts = new ArrayList<>();
        Arrays.stream(postList)
                .filter(element -> element.userId.equals("3"))
                .forEach(element -> userPosts.add(element.body));
        System.out.println("Calculate amount of posts by userId equals 3 => "+userPosts.size());

    }

    @Test
    public void titleFiltering() throws IOException {
        String getPosts = getResource(baseURL,200);

        PostRK[] postList = objectMapper.readValue(getPosts,PostRK[].class);

        List<String> userPosts = new ArrayList<>();
        Arrays.stream(postList)
                .filter(element -> element.title.contains("consequatur"))
                .forEach(element -> userPosts.add(element.body));
        System.out.println("Calculate and print how many posts include in title phrase 'consequatur' => "+userPosts.size());
    }

    @Test
    public void arraySortingCheck() throws IOException {
        //Check that array sorted by userId
        String getPosts = getResource(baseURL,200);

        PostRK[] postList = objectMapper.readValue(getPosts,PostRK[].class);

        List<Integer> userPosts = new ArrayList<>();
        Arrays.stream(postList)
                .forEach(element -> userPosts.add(Integer.parseInt(element.userId)));
        for(int i=0;  i<=userPosts.size()-1; i++){
            if(i>0){
                assertTrue(userPosts.get(i-1)<=userPosts.get(i));
            }
        }
        assertTrue(userPosts.get(0)<=userPosts.get(1));
    }

    @Test
    public void testMapper(){
        List<PostRK> answer = given()
                .header("Content-Type","text/html; charset=utf-8")
                .spec(spec)
                .expect()
                .statusCode(200)
                .when()
                .get(baseURL)
                .thenReturn()
                .getBody()
                .jsonPath().getList("$", PostRK.class);

        System.out.println(answer.size());
        System.out.println(answer.get(1).title);
    }
}

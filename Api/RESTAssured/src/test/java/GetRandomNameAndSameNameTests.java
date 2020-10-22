import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetRandomNameAndSameNameTests extends BaseTest{

    private static final String RESOURCE = "/randomName";
    private static final String RESOURCE2 = "/sameName";

    @Test
    public void Get_Random_Name_And_Same_Name_Test(){
        HashMap<String,String> data = new HashMap<String,String>();

        Response response =
                    request
                            .auth()
                            .preemptive()
                            .basic("testuser", "testpass")
                            .get(String.format("%s", RESOURCE));

        assertThat(response.statusCode(), equalTo(200));

        String name = response.path("name");
        data.put("name", name);

        request
                .contentType("application/json")
                .body(data)
                .post(String.format("%s", RESOURCE2))
                .then()
                .statusCode(200)
                .body("name", equalTo(name));
    }
}


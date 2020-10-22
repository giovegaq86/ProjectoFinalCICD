import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetRandomNameTests extends BaseTest{

    private static final String RESOURCE = "/randomName";

    @Test
    public void Get_Random_Name_Without_Auth_Test(){
        request
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(401)
                .body("message", equalTo("Please login first"));
    }
}


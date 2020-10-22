import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class UpdateNameTests extends BaseTest{

    private static final String RESOURCE = "/updateName";

    @Test
    public void Update_Name_Test(){
        request
                .put(String.format("%s", RESOURCE))
                .then()
                .statusCode(406)
                .body("message", equalTo("Name was not provided"));
    }
}


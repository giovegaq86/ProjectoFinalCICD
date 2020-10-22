import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
public class SameNameTests extends BaseTest{

    private static final String RESOURCE = "/sameName";

    @Test
    public void Same_Name_Test(){
        HashMap<String,String> data = new HashMap<String,String>();
        data.put("name","Triple H");

        request
                .contentType("application/json")
                .body(data)
                .post(String.format("%s", RESOURCE))
                .then()
                .statusCode(200)
                .body("name", equalTo("Triple H"));
    }
}


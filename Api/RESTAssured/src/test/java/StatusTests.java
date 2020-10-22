import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class StatusTests extends BaseTest{

    private static final String RESOURCE = "/status";

    @Test
    public void Status_Test(){
        request
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(200);
    }
}


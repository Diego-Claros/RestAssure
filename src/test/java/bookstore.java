import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class bookstore {
    @Test
    void getUsers(){
        given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .log().all()
        ;

    }
    @Test
    public void createRandomUser() {
        String endpoint = "https://bookstore.toolsqa.com/Account/v1/User";

        // Generate a random username
        String randomUserName = "user_" + java.util.UUID.randomUUID().toString();

        // Request payload
        String requestBody = "{ \"userName\": \"" + randomUserName + "\", \"password\": \"String$#asd1\" }";

        // Perform the POST request and validate the response
        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
        .when()
                .post(endpoint)
        .then()
                .log().all() // Log the entire response for debugging
                .statusCode(201);
                //.body("status", equalTo("Success"))
                //.body("result", equalTo("User authorized successfully"));
    }

    @Test
    public void createUser() {
        String endpoint = "https://bookstore.toolsqa.com/Account/v1/User";

        // Request payload
       // String requestBody = "{ \"userName\":  \"" + randomUserName + "\", \"password\": \"S$tring1234\" }";
        String requestBody = "{ \"userName\": \"soyKheaBro7\", \"password\": \"String$#asd1\" }";

        // Perform the POST request and validate the response
        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .log().all() // Log the entire response for debugging
                .statusCode(201);
                //.body("status", equalTo("Success"))
                //.body("result", equalTo("User authorized successfully"));
    }
}

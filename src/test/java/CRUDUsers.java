import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
public class CRUDUsers {

    int id;
    @Test
    void getUsers(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all()
        ;

    }
    @Test
    void createUser() {
        JSONObject data = new JSONObject();
        data.put("name", "morpheus");
        data.put("job", "Leader");
        id = given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
        // .then()
    }
    //.statusCode (201)
    // .log().all();
    @Test
    void updateUser() {
        JSONObject data = new JSONObject();
        data.put("name", "morpheus");
        data.put("job", "zion resident");

        given()
                .contentType("application/json")
                .body(data)
                .when()//"https://regres.in/api/users/"
                .put( "https://reqres.in/api/users/" + id)
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    void deleteUser(){
        given ()
                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode (204)
                .log().all();
    }

}
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;



public class test extends baseTest  {

    final String body = new String(Files.readAllBytes(Paths.get("src/test/jsons/login.txt")), "UTF-8");


    String newSchema = body.replace("%email%", "eve.holt@reqres.in");
    public test() throws IOException {
    }


    @Test
    public void loginTest()  {


       Response LoginResponse = given()
                .contentType(ContentType.JSON)
                .body(newSchema)
                .log()
                .all()
                .post("Login");
        System.out.println("El response es:" + LoginResponse.asString());
    }




}

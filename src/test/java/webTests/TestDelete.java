package webTests;

import config.GenericsConfig;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestDelete extends GenericsConfig {

    @Test
    public void deletarUsuarioPorId(){

        Long id = Long.valueOf(2);

        given()
        .when()
            .delete(path+"api/users/"+id)
        .then()
            .assertThat()
            .statusCode(HttpStatus.SC_NO_CONTENT)
            .log()
            .all();
    }
}

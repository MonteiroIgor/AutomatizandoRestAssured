package webTests;

import config.GenericsConfig;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TestGet extends GenericsConfig {

    @Test
    public void listarUsuarios(){

        given()
        .when()
                .get(path+"api/users?page=2")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .all();


    }

    @Test
    public void deveBuscarUsuarioPorId(){

        Long id = Long.valueOf(2);

        given()
        .when()
                .get(path+"api/users/"+id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .all();

    }

    @Test
    public void deveBuscarUsuarioPorIdInvalido(){

        Long idInvalido = Long.valueOf(300);

        given()
        .when()
                .get(path+"api/users/"+idInvalido)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log()
                .all();

    }
}

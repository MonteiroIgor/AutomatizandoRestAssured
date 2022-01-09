package webTests;

import config.GenericsConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class TestGet extends GenericsConfig {

    @Test
    public void mustGetAllUser(){

        given()
        .when()
                .get(path+"api/users?page=2")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("Schema/ListarUsuarioSchema.json"))
                .log()
                .all();


    }

    @Test
    public void mustGetUserByID(){

        Long id = Long.valueOf(2);

        given()
        .when()
                .get(path+"api/users/"+id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("Schema/BuscarUsuarioPorIdSchema.json"))
                .log()
                .all();

    }

    @Test
    public void mustGetUsedByInvalidID(){

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

    @Test
    public void mustVerifyDelayOfResponse(){

        given()
                .when()
                .get(path+"api/users?delay=3")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("Schema/DelayRespostaSchema.json"))
                .log()
                .all();

    }
}

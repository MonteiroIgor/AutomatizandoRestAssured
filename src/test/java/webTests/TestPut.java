package webTests;

import config.GenericsConfig;
import entidades.Usuario;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import utils.UsuarioDTO;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;

import static io.restassured.RestAssured.given;

public class TestPut extends GenericsConfig {

    Usuario atualizaUsuario;

    @Before
    public void fillAtualization(){
        atualizaUsuario = new UsuarioDTO().atualizarUsuario();
    }

    @Test
    public void mustUpdateUserInformation(){

        Long idUsuario = Long.valueOf(2);

        given()
                .contentType(ContentType.JSON)
                .body(atualizaUsuario)
        .when()
                .put(path+"api/users/"+idUsuario)
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK)
                .body(containsString("morpheus"),
                        containsString("zion resident"),
                        matchesJsonSchemaInClasspath("Schema/AtualizaInformacaoSchema.json"))
                .log()
                .all();
    }
}

package webTests;

import config.GenericsConfig;
import io.restassured.http.ContentType;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Test;
import utils.UsuarioDTO;

import static io.restassured.RestAssured.given;

public class TestPost extends GenericsConfig {

    @Test
    public void deveCadastrarUsuarioComSucesso(){

        JSONObject usuario = new UsuarioDTO().preencherUsuario();

        given()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post(path+"api/users")
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_CREATED);

    }

    @Test
    public void devePreencherRegistroUsuario(){

        JSONObject registro = new UsuarioDTO().preencherRegistro();

        given()
                //.contentType(ContentType.JSON)
                .body(registro)
        .when()
                .post(path+"/api/register")
        .then()
                .assertThat()
                //.contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK)
                .log()
                .all();

    }
}

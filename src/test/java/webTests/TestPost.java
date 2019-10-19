package webTests;

import config.GenericsConfig;
import entidades.Registro;
import entidades.Usuario;
import io.restassured.http.ContentType;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import utils.UsuarioDTO;
import static org.hamcrest.Matchers.containsString;

import javax.jws.WebService;

import static io.restassured.RestAssured.given;


public class TestPost extends GenericsConfig {

    Usuario usuario;
    Registro registro,registroSemPassword;

    @Before
    public void preenchimento(){
        usuario = new UsuarioDTO().preencherUsuario();
        registro = new UsuarioDTO().preencherRegistro();
        registroSemPassword = new UsuarioDTO().preencherRegistroSemPassword();

    }

    @Test
    public void deveCadastrarUsuarioComSucesso(){



        given()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post(path+"api/users")
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_CREATED)
                .log()
                .all();

    }

    @Test
    public void devePreencherRegistroUsuario(){



        given()
                .contentType(ContentType.JSON)
                .body(registro)
        .when()
                .post(path+"api/register")
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK)
                .log()
                .all();

    }

    @Test
    public void devePreencherRegistroSemPassword(){

        given()
                .contentType(ContentType.JSON)
                .body(registroSemPassword)
        .when()
                .post(path+"api/register")
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("Missing password"))
                .log()
                .all();

    }

}

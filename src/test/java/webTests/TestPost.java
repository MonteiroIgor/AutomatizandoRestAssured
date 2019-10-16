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
<<<<<<< Updated upstream
                .post(path+"api/users")
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_CREATED);
=======
                .post("");
>>>>>>> Stashed changes



    }
}

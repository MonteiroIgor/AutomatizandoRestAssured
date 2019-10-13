package webTests;

import config.GenericsConfig;
import jdk.nashorn.api.scripting.JSObject;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestPost extends GenericsConfig {

    @Test
    public void deveCadastrarUsuarioComSucesso(){

        JSONObject usuario = new JSONObject();

        usuario.put("name","morpheus");
        usuario.put("job","leader");

        given()
        .when()
                .post("")



    }
}

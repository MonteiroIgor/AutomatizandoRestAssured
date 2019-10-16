package utils;

import org.json.JSONObject;

import javax.jws.WebService;
import javax.xml.ws.ServiceMode;

@ServiceMode
public class UsuarioDTO {


    public JSONObject preencherUsuario(){

        JSONObject usuario = new JSONObject();

        usuario.put("name","morpheus");
        usuario.put("job","leader");

        return usuario;
    }
}

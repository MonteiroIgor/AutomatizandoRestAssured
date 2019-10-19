package utils;

import entidades.Registro;
import entidades.Usuario;
import org.json.JSONException;
import org.json.JSONObject;

import javax.jws.WebService;
import javax.xml.ws.ServiceMode;


public class UsuarioDTO {


    public Usuario preencherUsuario(){

        Usuario usuario = new Usuario();

        usuario.setName("morpheus");
        usuario.setJob("leader");

        return usuario;
    }

    public Registro preencherRegistro(){

        Registro registro = new Registro();

        registro.setEmail("eve.holt@reqres.in");
        registro.setPassword("pistol");

        return registro;
    }

}

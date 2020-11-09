package cl.inacap.Covit.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.Covit.dto.Usuario;

public class UsuarioDAO {
    public UsuarioDAO(){
        Usuario u = new Usuario();
        u.setNombre("Usuario");
        u.setRut("12345678-5");
        u.setContraseña(6785);
        usuarios.add(u);
    }
    private  List<Usuario> usuarios= new ArrayList<>();

    public void AgregarUsuario(Usuario u){
        usuarios.add(u);
    }

    public List<Usuario>mostrarUsuario(){
        return usuarios;
    }


}

package com.dxc.controladores;

import com.dxc.modelos.usuarios.Administrador;
import com.dxc.modelos.usuarios.Gestor;
import com.dxc.modelos.usuarios.Usuario;

public class UsuariosController {

    public boolean validarUsuario(String usuario, String clave) throws Exception {

        boolean valido = false;
        if (usuario == "admin") {
            Administrador admin = new Administrador(usuario, clave, 0);
            valido = admin.LoginUsuario();
        } else {
            Gestor gestor = new Gestor(usuario, clave, 0);
            valido = gestor.LoginUsuario();
        }
        return valido;
    }
}

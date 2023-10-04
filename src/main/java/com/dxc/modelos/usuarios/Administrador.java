package com.dxc.modelos.usuarios;

public class Administrador extends Usuario{


        public boolean LoginUsuario() throws Exception {
            System.out.printf("asd");
            return true;
        }

    @Override
    public boolean LoginUsuario(String usuario, String password) throws Exception {
        return false;
    }
}

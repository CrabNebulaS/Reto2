package com.dxc.modelos.usuarios;

public class Administrador extends Usuario{

        private Integer numAdministrador;


    @Override
    public boolean LoginUsuario() throws Exception {
        if(this.getNobreUsuario()=="admin" & this.getPassword() =="admin") {
            return true;
        } else {
            return false;
        }
    }

    public Administrador(String nombre, String clave, Integer numAdministrador) {
        super(nombre, clave);
        this.setNobreUsuario(nombre);
        this.setPassword(clave);
        this.numAdministrador = numAdministrador;
    }
}

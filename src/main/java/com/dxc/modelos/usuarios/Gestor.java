package com.dxc.modelos.usuarios;

public class Gestor extends Usuario{

    private Integer numGestor;

    public boolean LoginUsuario() throws Exception {
        if(this.getNobreUsuario()=="gestor" & this.getPassword() =="gestor") {
            return true;
        } else {
            return false;
        }

    }

    public Gestor(String nombre, String clave, Integer numGestor) {
        super(nombre, clave);
        this.setNobreUsuario(nombre);
        this.setPassword(clave);
        this.numGestor = numGestor;
    }
}

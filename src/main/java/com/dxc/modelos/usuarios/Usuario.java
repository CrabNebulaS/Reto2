package com.dxc.modelos.usuarios;

public abstract class Usuario {

    private String nobreUsuario;

    private String password;

    public String getNobreUsuario() {
        return nobreUsuario;
    }

    public void setNobreUsuario(String nobreUsuario) {
        this.nobreUsuario = nobreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract boolean LoginUsuario(String usuario, String password) throws Exception;
}

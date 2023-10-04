package com.dxc.modelos.usuarios;

import java.time.LocalDate;
import java.util.HashMap;

public class UsuariosFactory {
    public static Usuario create(String type, HashMap params) throws Exception {
        switch (type) {
            case "gestor": {
                String prop1 = (String) params.get("aProperty");
                Integer prop2 = (Integer) params.get("anotherProperty");

                String nombreUsuario = (String) params.get("nombre");
                String claveUsuario = (String) params.get("password");
                Integer numGestor = (Integer) params.get("numGestor");

                return new Gestor(nombreUsuario, claveUsuario, numGestor);
            }
            case "administrador": {

                String nombreUsuario = (String) params.get("nombre");
                String claveUsuario = (String) params.get("password");
                Integer numAdmin = (Integer) params.get("numAdmin");

                return new Administrador(nombreUsuario, claveUsuario, numAdmin);
            }
            default:
                return null;
        }
    }
}

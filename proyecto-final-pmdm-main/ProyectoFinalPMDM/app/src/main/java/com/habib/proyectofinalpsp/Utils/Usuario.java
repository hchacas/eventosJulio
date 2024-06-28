package com.habib.proyectofinalpsp.Utils;

public class Usuario {
    private String nombre;
    private String telefono;
    private String correo;

    private String descripcion;

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    private String preferencias;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

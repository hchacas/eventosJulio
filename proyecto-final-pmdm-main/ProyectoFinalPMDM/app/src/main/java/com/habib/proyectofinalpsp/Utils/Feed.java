package com.habib.proyectofinalpsp.Utils;

import java.io.Serializable;

public class Feed implements Serializable {
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    private String imagen;

    private String fecha;

    private String[] comentarios;

    private int likes;

    public Feed(String fecha, String[] comentarios, int likes, String imagen) {
        this.fecha = fecha;
        this.comentarios = comentarios;
        this.likes = likes;
        this.imagen = imagen;
    }
}

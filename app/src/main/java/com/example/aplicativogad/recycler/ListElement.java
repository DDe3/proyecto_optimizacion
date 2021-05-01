package com.example.aplicativogad.recycler;

public class ListElement {

    private String img;
    private String titulo;
    private String descripcion;

    public ListElement(String img, String titulo, String descripcion) {
        this.img = img;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

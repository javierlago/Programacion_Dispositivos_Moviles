package com.example.ejerciciodeprueba;

public class Usuario {

    int codigo;
    String nombre;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Usuario() {
    }
}

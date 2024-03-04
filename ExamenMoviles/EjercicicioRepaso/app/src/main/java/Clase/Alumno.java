package Clase;

public class Alumno {

    String nombre,curso,clico;
    int foto;

    public Alumno() {

    }

    public Alumno(String nombre, String curso, String clico, int foto) {
        this.nombre = nombre;
        this.curso = curso;
        this.clico = clico;
        this.foto = foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getClico() {
        return clico;
    }

    public void setClico(String clico) {
        this.clico = clico;
    }
}

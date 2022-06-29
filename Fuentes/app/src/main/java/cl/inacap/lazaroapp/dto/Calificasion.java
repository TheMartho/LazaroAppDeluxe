package cl.inacap.lazaroapp.dto;

public class Calificasion {
    private  int id;
    private float cantidadeEstrellas;
    private String descripcion;

    public float getCantidadeEstrellas() {
        return cantidadeEstrellas;
    }

    public void setCantidadeEstrellas(float cantidadeEstrellas) {
        this.cantidadeEstrellas = cantidadeEstrellas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

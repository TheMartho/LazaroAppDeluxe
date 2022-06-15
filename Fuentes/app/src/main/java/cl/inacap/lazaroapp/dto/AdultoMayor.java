package cl.inacap.lazaroapp.dto;

import java.util.List;

public class AdultoMayor extends Usuario{


    public AdultoMayor(String rut, String nombres, String apellidos, int edad, String correo, String celular, Calificasion calificasion) {
        super(rut, nombres, apellidos, edad, correo, celular, calificasion);
    }

    private String direccionInicio;
    private String direccionObjetivo;
    private List<String> discapacidad;

    public String getDireccionInicio() {
        return direccionInicio;
    }

    public void setDireccionInicio(String direccionInicio) {
        this.direccionInicio = direccionInicio;
    }

    public String getDireccionObjetivo() {
        return direccionObjetivo;
    }

    public void setDireccionObjetivo(String direccionObjetivo) {
        this.direccionObjetivo = direccionObjetivo;
    }

    public List<String> getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(List<String> discapacidad) {
        this.discapacidad = discapacidad;
    }
}

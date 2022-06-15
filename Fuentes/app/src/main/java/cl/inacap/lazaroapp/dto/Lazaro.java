package cl.inacap.lazaroapp.dto;

public class Lazaro extends Usuario {
    private Auto auto;
    private Documentacion docu;


    public Lazaro(String rut, String nombres, String apellidos, int edad, String correo, String celular, Calificasion calificasion) {
        super(rut, nombres, apellidos, edad, correo, celular, calificasion);
    }


    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Documentacion getDocu() {
        return docu;
    }

    public void setDocu(Documentacion docu) {
        this.docu = docu;
    }
}

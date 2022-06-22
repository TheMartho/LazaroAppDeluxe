package cl.inacap.lazaroapp.dto;

public abstract class Usuario {

    protected String rut;
    protected String apellidos;
    protected String celular;
    protected String correo;
    protected int edad;
    protected String nombres;
    protected Calificasion calificasion;

public Usuario(String rut, String nombres, String apellidos, int edad, String correo, String celular, Calificasion calificasion){
    this.rut= rut;
    this.nombres=nombres;
    this.apellidos=apellidos;
    this.edad=edad;
    this.correo=correo;
    this.celular=celular;
    this.calificasion=calificasion;
}

}

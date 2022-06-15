package cl.inacap.lazaroapp.dto;

public abstract class Usuario {

    protected String rut;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String correo;
    protected String celular;
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

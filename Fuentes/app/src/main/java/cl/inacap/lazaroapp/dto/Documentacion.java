package cl.inacap.lazaroapp.dto;

public class Documentacion {
    private String tipoDocumento;
    private String documento; //IMG O DOCUMENTO CONVERTIDO A UN STRING BASE 64

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}

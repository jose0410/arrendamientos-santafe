package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;


public class Remove {
    private int codigo;
    private String mensaje;
    private Agency agency;

    public Remove(Agency agency, int code, String message) {
        this.codigo = code;
        this.mensaje = message;
        this.agency = agency;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
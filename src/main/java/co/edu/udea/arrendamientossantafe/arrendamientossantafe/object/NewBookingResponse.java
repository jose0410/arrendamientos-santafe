package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;

import java.util.Date;
import java.util.*;

public class NewBookingResponse {
    private Agency agency;
    private String mensaje;
    private int codigo;

    public NewBookingResponse(Agency agency, String message, int code) {
        this.mensaje = message;
        this.agency = agency;
        this.codigo = code;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

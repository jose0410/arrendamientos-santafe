package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;
import java.util.Date;
import java.util.*;

public class NewBookingResponse {
  private Agency agency;
  private String message;
  private int code;

  public NewBookingResponse(Agency agency, String message,int code){
    this.message = message;
    this.agency = agency;
    this.code = code;
  }

  public String getMessage() {
    return message;
  }
  public void setMessage(String message){
    this.message = message;
  }
  public int getCode() {
    return code;
  }
  public void setCode(int code){
    this.code = code;
  }
  public Agency getAgency() {
    return agency;
  }
  public void setAgency(Agency agency){
    this.agency = agency;
  }
}

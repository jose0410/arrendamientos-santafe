package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;
import java.util.Date;

public class Agency {
  private String nit;
  private String name;
  private String description;

  public Agency(String nit, String name, String description){
    this.nit = nit;
    this.name = name;
    this.description = description;
  }

  public String getNit() {
    return nit;
  }
  public void setNit(String nit){
    this.nit = nit;
  }
  public String getName() {
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description){
    this.description = description;
  }
}

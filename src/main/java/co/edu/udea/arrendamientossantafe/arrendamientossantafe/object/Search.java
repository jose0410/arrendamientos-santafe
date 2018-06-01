package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;
import java.util.Date;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Home2;
import java.util.*;

public class Search {
  private List<Home2> homes;
  private Agency agency;

  public Search(Agency agency, List<Home2> homes){
    this.homes = homes;
    this.agency = agency;
  }

  public List<Home2> getHomes() {
    return homes;
  }
  public void setHomes(List<Home2> homes){
    this.homes = homes;
  }
  public Agency getAgency() {
    return agency;
  }
  public void setAgency(Agency agency){
    this.agency = agency;
  }
}

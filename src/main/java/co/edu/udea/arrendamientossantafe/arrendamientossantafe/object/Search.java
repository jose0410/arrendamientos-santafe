import java.util.Date;

public class Search{
  private String city;
  private Date checkIn;
  private Date checkOut;
  private int type;

  public String getCity() {
      return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getType() {
      return type;
  }
  public void setType(int id) {
      this.type = type;
  }
  public Date getCheckIn() {
      return checkIn;
  }

  public void setCheckIn(Date checkIn) {
      this.checkIn = checkIn;
  }
  public Date getCheckOut() {
      return checkOut;
  }

  public void setCheckOut(Date checkOut) {
      this.checkOut = checkOut;
  }
}

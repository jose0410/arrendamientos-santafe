package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Location;
public class Home2 {
    private int id;

    private String name;
    private String description;
    private Location location;

    private Double raiting;
    private String totalAmount;
    private String city;
    private String type;

    private double price_per_night;

    private String thumbnail;

    public Home2(int id, String name, String description, Location location, Double raiting, String totalAmount, String city, String type, Double price_per_night, String thumbnail){
      this.id = id;
      this.name = name;
      this.description = description;
      this.location = location;
      this.raiting = raiting;
      this.totalAmount = totalAmount;
      this.city = city;
      this.type = type;
      this.price_per_night = price_per_night;
      this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return price_per_night;
    }

    public void setPricePerNight(double price_per_night) {
        this.price_per_night = price_per_night;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getRaiting() {
        return raiting;
    }

    public void setRaiting(Double raiting) {
        this.raiting = raiting;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(double price_per_night) {
        this.price_per_night = price_per_night;
    }
}

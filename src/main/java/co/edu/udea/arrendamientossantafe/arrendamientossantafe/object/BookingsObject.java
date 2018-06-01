package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Booking;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Location;

import java.util.List;

public class BookingsObject {
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
    private List<SimpleBooking> booking;

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

    public List<SimpleBooking> getBooking() {
        return booking;
    }

    public void setBooking(List<SimpleBooking> booking) {
        this.booking = booking;
    }

}

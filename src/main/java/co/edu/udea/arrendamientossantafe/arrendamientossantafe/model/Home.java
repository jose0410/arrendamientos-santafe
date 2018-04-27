package co.edu.udea.arrendamientossantafe.arrendamientossantafe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Hashtable;

@Entity
@Table(name = "home")
@EntityListeners(AuditingEntityListener.class)
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name, description, city, type, rating, totalAmount, pricePerNight, thumbnail;

    //private Hashtable<String,String> location;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date checkOut;

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(String pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /*public Hashtable<String, String> getLocation() {
        return location;
    }*/

    /*public void setLocation(Hashtable<String, String> location) {
        this.location = location;
    }*/

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

package co.edu.udea.arrendamientossantafe.arrendamientossantafe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "booking")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="home")
    private Home idHome;

    private String checkIn;
    private String checkOut;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;

    }
    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}

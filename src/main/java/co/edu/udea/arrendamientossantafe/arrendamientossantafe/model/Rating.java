package co.edu.udea.arrendamientossantafe.arrendamientossantafe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "rating")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="home")
    private Home idHome;

    private double rate;

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;

    }

    public Home getIdHome() {
        return idHome;
    }

    public void setIdHome(Home idHome) {
        this.idHome = idHome;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

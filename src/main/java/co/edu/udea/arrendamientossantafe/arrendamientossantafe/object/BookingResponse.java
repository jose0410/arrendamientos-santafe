package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Booking;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Location;

import java.util.List;

public class BookingResponse {
    private Agency agency;
    private List<BookingsObject> homes;

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public List<BookingsObject> getHomes() {
        return homes;
    }

    public void setHomes(List<BookingsObject> homes) {
        this.homes = homes;
    }
}

package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;

public class SimpleBooking {
    private long bookingId;
    private String checkIn;
    private String checkOut;

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long l) {
        this.bookingId = l;
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

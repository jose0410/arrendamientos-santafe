package co.edu.udea.arrendamientossantafe.arrendamientossantafe.controller;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Booking;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.*;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.City;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Type;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.HomeRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.BookingRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.CityRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.TypeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.json.*;

import static java.lang.Integer.parseInt;


@RestController
@RequestMapping("/v1/homes")
public class HomeController {

    @Autowired
    HomeRepository homeRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    TypeRepository typeRepository;

    private boolean firebaseUp = false;

    // "checkIn": "07-04-2018",
    // "checkOut": "10-04-2018",
    // "city": "CO-MDE",
    // "type": "1"DAte checkIn
    @PostMapping("/search")
    public Search getAllHomes(@RequestBody String search) throws JsonProcessingException, ParseException {

        JSONObject obj = new JSONObject(search);

        String initialDate = obj.getString("checkIn");
        String endDate = obj.getString("checkOut");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate checkInDate = LocalDate.parse(initialDate, formatter);
        LocalDate checkOutDate = LocalDate.parse(endDate, formatter);

        obj.put("checkIn", checkInDate.toString());
        obj.put("checkOut", checkOutDate.toString());

        City city = cityRepository.searchCity(obj.getString("city"));
        Type type = typeRepository.searchType(parseInt(obj.getString("type")));
        List<Home> homes = homeRepository.searchHome(obj.getString("checkIn"), obj.getString("checkOut"), type, city);
        List<Home2> homes2 = new ArrayList<Home2>();
        for (Home i : homes) {
            Home2 aux = new Home2(i.getId(), i.getName(), i.getDescription(), i.getLocation(), i.getRaiting(), i.getTotalAmount(), i.getCity().getName(), i.getType().getName(), i.getPricePerNight(), i.getThumbnail());
            homes2.add(aux);
        }
        Agency agency = new Agency("1234-1123-1234", "Arrendamientos Santa Fé", "Arrendamientos Santa Fé");
        Search res = new Search(agency, homes2);
        return res;
    }

    @PostMapping("/booking")
    public NewBookingResponse bookingHome(@RequestBody String booking, @RequestHeader("token") String token) throws JsonProcessingException, ParseException,IOException, FirebaseAuthException {
      if (!firebaseUp) {
          initFirebase();
      }
      FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
      String uid = decodedToken.getUid();
      JSONObject obj = new JSONObject(booking);
      String initialDate = obj.getString("checkIn");
      String endDate = obj.getString("checkOut");
      int id = Integer.parseInt(obj.getString("id"));

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
      LocalDate checkInDate = LocalDate.parse(initialDate, formatter);
      LocalDate checkOutDate = LocalDate.parse(endDate, formatter);
      Agency agency = new Agency("1234-1123-1234", "Arrendamientos Santa Fé", "Arrendamientos Santa Fé");
      Home home = homeRepository.getHome(id);
      int code;
      String message;
      try{
        Booking res = new Booking();
        res.setIdHome(home);
        res.setCheckIn(checkInDate.toString());
        res.setCheckOut(checkOutDate.toString());
        res.setUser(uid);
        res = bookingRepository.save(res);
        code = 1;
        message = "Success";
      } catch (Exception e) {
        code = 1;
        message = e.toString();
      }
      NewBookingResponse response = new NewBookingResponse(agency, message, code);
      return response;
  }

    @PostMapping("/myBooking")
    public BookingResponse myBooking(@RequestHeader("token") String token) throws IOException, FirebaseAuthException {
        if (!firebaseUp) {
            initFirebase();
        }
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        String uid = decodedToken.getUid();
        List<Booking> bookings = bookingRepository.getAllByUser(uid);
        BookingResponse bookingResponse = new BookingResponse();
        Set<Home> homeSet = new HashSet<>();
        for (Booking booking : bookings) {
            Home home = homeRepository.getHome(booking.getIdHome().getId());
            if (null != home) {
                homeSet.add(home);
            }
        }
        List<BookingsObject> homes = populateBookingObject(homeSet, bookings);
        bookingResponse.setHomes(homes);
        bookingResponse.setAgency(new Agency("1123-1233-12313-51414", "Arrendamientos Santa Fé", "Arrendamientos Santa Fé"));
        return bookingResponse;
    }

    private List<BookingsObject> populateBookingObject(Set<Home> homeSet, List<Booking> bookings) {
        List<BookingsObject> bookingsObjects = new ArrayList<>();
        for (Home home : homeSet) {
            List<SimpleBooking> simpleBookings = new ArrayList<>();
            BookingsObject bookingsObject = new BookingsObject();
            bookingsObject.setCity(home.getCity().getName());
            bookingsObject.setId(home.getId());
            bookingsObject.setDescription(home.getDescription());
            bookingsObject.setLocation(home.getLocation());
            bookingsObject.setLocation(home.getLocation());
            bookingsObject.setType(home.getType().getName());
            bookingsObject.setRaiting(home.getRaiting());
            bookingsObject.setPricePerNight(home.getPrice_per_night());
            bookingsObject.setPrice_per_night(home.getPrice_per_night());
            bookingsObject.setThumbnail(home.getThumbnail());
            for (Booking booking : bookings) {
                if (booking.getIdHome().getId() == home.getId()) {
                    SimpleBooking simpleBooking = new SimpleBooking();
                    simpleBooking.setCheckOut(booking.getCheckOut());
                    simpleBooking.setCheckIn(booking.getCheckIn());
                    simpleBooking.setBookingId(booking.getId());
                    simpleBookings.add(simpleBooking);
                }
            }
            bookingsObject.setBooking(simpleBookings);
            bookingsObjects.add(bookingsObject);
        }
        return bookingsObjects;
    }
    private void initFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://yotearriendo-d532f.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
        firebaseUp = true;

    }
}

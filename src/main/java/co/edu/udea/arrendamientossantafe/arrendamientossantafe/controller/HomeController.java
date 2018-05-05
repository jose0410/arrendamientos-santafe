package co.edu.udea.arrendamientossantafe.arrendamientossantafe.controller;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Booking;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Search;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.HomeRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.*;


@RestController
@RequestMapping("/v1/homes")
public class HomeController {

    @Autowired
    HomeRepository homeRepository;
    BookingRepository bookingRepository;
    // "checkIn": "07-04-2018",
    // "checkOut": "10-04-2018",
    // "city": "CO-MDE",
    // "type": "1"DAte checkIn
    @PostMapping("/search")
    public List<Home> getAllHomes(@RequestBody String search){
      JSONObject obj = new JSONObject(search);
      System.out.println(obj.getString("prueba"));
      return homeRepository.findAll();
    }
}

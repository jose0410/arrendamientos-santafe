package co.edu.udea.arrendamientossantafe.arrendamientossantafe.controller;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.City;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Type;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Booking;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Search;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.HomeRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.BookingRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.CityRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.TypeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    // "checkIn": "07-04-2018",
    // "checkOut": "10-04-2018",
    // "city": "CO-MDE",
    // "type": "1"DAte checkIn
    @PostMapping("/search")
    public List<Home> getAllHomes(@RequestBody String search) throws JsonProcessingException, ParseException {

        JSONObject obj = new JSONObject(search);

        String initialDate = obj.getString("checkIn");
        String endDate = obj.getString("checkOut");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate checkInDate = LocalDate.parse(initialDate, formatter);

        LocalDate checkOutDate = LocalDate.parse(endDate, formatter);

        obj.put("checkIn",checkInDate.toString());
        obj.put("checkOut",checkOutDate.toString());

        City city = cityRepository.searchCity(obj.getString("city"));
        Type type = typeRepository.searchType(parseInt(obj.getString("type")));
        List<Home> homes = homeRepository.searchHome(obj.getString("checkIn"), obj.getString("checkOut"), type, city);

        return homes;
    }
}

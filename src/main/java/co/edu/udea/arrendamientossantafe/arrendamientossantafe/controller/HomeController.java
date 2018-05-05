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
    public List<Home> getAllHomes(@RequestBody String search){
      JSONObject obj = new JSONObject(search);
      // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      // Date checkIn = null;
      // Date checkOut = null;
      // try {
      //   checkIn = formatter.parse(obj.getString("checkIn"));
      //   checkOut =  formatter.parse(obj.getString("checkOut"));
      // } catch (ParseException e) {
      //   e.printStackTrace();
      // }
      // System.out.println(checkOut);
      City city = cityRepository.searchCity(obj.getString("city"));
      Type type = typeRepository.searchType(obj.getInt("type"));

      return homeRepository.searchHome(obj.getString("checkIn"),obj.getString("checkOut") ,type, city);
    }
}

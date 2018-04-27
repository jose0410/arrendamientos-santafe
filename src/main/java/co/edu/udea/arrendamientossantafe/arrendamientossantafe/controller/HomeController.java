package co.edu.udea.arrendamientossantafe.arrendamientossantafe.controller;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/homes")
public class HomeController {

    @Autowired
    HomeRepository homeRepository;

    private String startDate, endDate;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    @PostMapping("/search")
    public List<Home> getAllHomes(@Valid @RequestBody Home home){

        startDate = format.format(home.getCheckIn());
        endDate = format.format(home.getCheckOut());
        //format.parse(startDate),format.parse(endDate)
        return homeRepository.findHomesByDate(new Date(home.getCheckIn().toString()),new Date(home.getCheckOut().toString()));
        //return null;
    }
}

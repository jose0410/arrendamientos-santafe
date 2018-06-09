package co.edu.udea.arrendamientossantafe.arrendamientossantafe;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


import co.edu.udea.arrendamientossantafe.arrendamientossantafe.controller.HomeController;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.City;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Location;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Type;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Agency;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Home2;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Remove;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Search;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.BookingRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.CityRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.HomeRepository;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository.TypeRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HomeRepository homeRepository;
    @MockBean
    BookingRepository bookingRepository;
    @MockBean
    CityRepository cityRepository;
    @MockBean
    TypeRepository typeRepository;


    @Test
    public void searchHomesTest() throws Exception {
        JsonObject body = new JsonObject();
        body.addProperty("checkIn", "26-05-2018");
        body.addProperty("checkOut", "29-05-2018");
        body.addProperty("type", "1");
        body.addProperty("city", "MDE");

        Search search = new Search(getAgency(), getHomes2());

        when(cityRepository.searchCity("MDE")).thenReturn(getCity());
        when(homeRepository.searchHome(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Type.class), Mockito.any(City.class))).thenReturn(getHomes());
        when(typeRepository.searchType(1)).thenReturn(getType());

        this.mockMvc.perform(post("/v1/homes/search").content(body.toString())).andExpect(status().isOk()).andExpect(content().string(containsString(search.getHomes().get(0).getCity())))
                .andExpect(content().string(containsString(search.getHomes().get(0).getThumbnail())))
                .andExpect(content().string(containsString(search.getHomes().get(0).getLocation().getAddress())))
                .andExpect(content().string(containsString(search.getHomes().get(0).getLocation().getLatitude())));
    }


    @Test
    public void removeBookingTest() throws Exception {
        JsonObject body = new JsonObject();
        body.addProperty("bookingId", "157");
        this.mockMvc.perform(delete("/v1/homes/removeBooking").content(body.toString()).header("token", "token")).andExpect(status().isOk());
    }

    @Test
    public void bookingTest() throws Exception {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("checkIn", "26-05-2018");
        jsonObject.addProperty("checkOut", "29-05-2018");
        jsonObject.addProperty("id", "1");
        this.mockMvc.perform(post("/v1/homes/booking").content(jsonObject.toString()).header("token", "token")).andExpect(status().isOk());
    }

    @Test
    public void myBookingTest() throws Exception {
        this.mockMvc.perform(post("/v1/homes/myBooking").header("token", "token")).andExpect(status().isOk());
    }

    private City getCity() {
        City city = new City();
        city.setId("1");
        city.setName("MDE");
        return city;
    }

    private Location getLocation() {
        Location location = new Location();
        location.setAddress("address");
        location.setLatitude("1234");
        location.setLongitude("1234");
        return location;
    }

    private Type getType() {
        Type type = new Type();
        type.setId(1);
        type.setName("1");
        return type;
    }

    private List<Home> getHomes() {
        List<Home> homes = new ArrayList<>();
        Home home = new Home();
        home.setCity(getCity());
        home.setDescription("description1");
        home.setId(1);
        home.setLocation(getLocation());
        home.setName("name1");
        home.setPrice_per_night(2.0);
        home.setRaiting(4.0);
        home.setThumbnail("THUMBNAIL");
        home.setTotalAmount("20");
        home.setType(getType());
        homes.add(home);
        return homes;
    }

    private Agency getAgency() {
        Agency agency = new Agency("123", "agencyName", "description");
        return agency;
    }

    private List<Home2> getHomes2() {
        List<Home2> home2List = new ArrayList<>();
        Home2 home2 = new Home2(1, "name1", "description1", getLocation(), 4.0, "20", "MDE", "1", 2.0, "THUMBNAIL");
        home2List.add(home2);
        return home2List;
    }
}
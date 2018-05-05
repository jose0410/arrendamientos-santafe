package co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.City;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Type;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Long> {
  @Query("select  h.id, h.name, h.description, h.address,h.latitude, h.longitude, h.thumbnail, h.price_per_night,c.name as cityName,t.name as typeName from Home as h left join City as c on h.city=c.id left join Type as t on h.type = t.id where h.id not in (select idHome from Booking where (check_in<=:check_out and check_out>=:check_out) or (check_in>=:check_in and check_out<=:check_in) and h.city=:city and h.type=:type)")
  List<Home> searchHome(@Param("check_in") String check_in ,@Param("check_out") String check_out,@Param("type") Type type, @Param("city") City city);
}

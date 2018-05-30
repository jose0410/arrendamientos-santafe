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
  @Query("select h from Home as h where h.city = :city and h.type = :type and NOT exists(select idHome from Booking as b where h.id = b.idHome and ((:check_in between check_in and check_out) or (:check_out between check_in and check_out)))")
  List<Home> searchHome(@Param("check_in") String check_in ,@Param("check_out") String check_out,@Param("type") Type type, @Param("city") City city);
}

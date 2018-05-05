package co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Long> {
  //@Query("SELECT t FROM Home t  where t.id not in (select id from Booking where checkIn >= :checkIn and checkOut <= :checkOut)")
  //List<Home> findHomeById(@Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut);
  //List<Home> findHomeById(@Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut);
}

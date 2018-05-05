package co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.City;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
  @Query("select c from City as c where id=:id")
  City searchCity(@Param("id") String id);
}

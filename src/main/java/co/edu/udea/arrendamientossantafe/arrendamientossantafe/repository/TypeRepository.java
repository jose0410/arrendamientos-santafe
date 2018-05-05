package co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Type;
import co.edu.udea.arrendamientossantafe.arrendamientossantafe.object.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {
  @Query("select t from Type as t where id=:id")
  Type searchType(@Param("id") int id);
}

package co.edu.udea.arrendamientossantafe.arrendamientossantafe.repository;

import co.edu.udea.arrendamientossantafe.arrendamientossantafe.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Long> {


}

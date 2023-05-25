package Tournoi.Via.Web.Repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Tournoi.Via.Web.Model.But;
import Tournoi.Via.Web.Model.Player;

public interface ButRepository  extends JpaRepository<But, Long> {

	
	@Query("select count(p) from But p  group by p.dateBut"  )
	 public List<Count> getCountByCountryAndState(@Param("name") Player name);
	 
         
	   public int countAllBydateBut(Date year);

	
	}

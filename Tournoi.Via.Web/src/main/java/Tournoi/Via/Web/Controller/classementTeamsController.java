package Tournoi.Via.Web.Controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Tournoi.Via.Web.Model.Standing;
import Tournoi.Via.Web.Repository.StandingRepository;

@Controller
public class classementTeamsController {

	@Autowired // pour l'injection de dépendances
	private StandingRepository standingRepository;

	  @GetMapping("/all")
	  public String showAll(Model model) {
			
		  List<Standing> table =  orderTableByPoints(standingRepository.findAll());
	        model.addAttribute("Teams", table);
	      return "pages/Classement";
	  }
	  public static List<Standing> orderTableByPoints(List<Standing> table) {
		  table.sort( Comparator.comparing(Standing::getPoints)
			        .thenComparing(Standing::getGoalDifference)
			        .thenComparing(Standing::getFootballTeamId).reversed());
			          updateTablePositions(table);
		    return table;
		  
}
	  private static void updateTablePositions(List<Standing> table) {
		    for (int i = 0; i < table.size(); i++) {
		      table.get(i).setTablePosition(i + 1);
		    }
		  }
	 
	
	  

}
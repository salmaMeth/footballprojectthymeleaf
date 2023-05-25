package Tournoi.Via.Web.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Model.Standing;
import Tournoi.Via.Web.Repository.StandingRepository;
@Controller
public class ResultTeamsController {
	@Autowired // pour l'injection de dépendances
	private StandingRepository standingRepository;
	
	 @RequestMapping(value="/getresults",method=RequestMethod.GET) 
	 
	  public String  getupdateTeam(Model model  ,@RequestParam(defaultValue = "1",name = "currentStandings") Long option,
			  HttpServletRequest request, @ModelAttribute("winsText") String winsvalue) {
			

			  model.addAttribute("Standings", standingRepository.findAll());

			  model.addAttribute("standing", standingRepository.findById(option)); 

		
		/*
		 * 			String btnName = request.getParameter("action");

		 * if(btnName.equals("valider"))
		 * 
		 * {
		 * 
		 * model.addAttribute("standing", standingRepository.findById(option)); } else
		 * if(btnName.equals("wins"))
		 * 
		 * { model.addAttribute("standing", standingRepository.findById(option));
		 * System.out.println(winsvalue+"ddd");
		 * 
		 * }
		 */
		 
			return "/pages/updateresult";
	 }
	  
	  

	  @RequestMapping(value="/updatestanding",method=RequestMethod.GET) 
	  public String getTeam(Model model ,@Valid Standing  standing, @RequestParam(defaultValue = "1",name = "currentStandings") long
	  option) {
	  
	  model.addAttribute("Standings");
	  
	  model.addAttribute("standing" ); 
	  standing.setStandingId(option);
	  standingRepository.save(standing); 
	  
	  return "/pages/updateresult";
	  
	  
	  
	  }
	 

	  @RequestMapping(value="/action",method=RequestMethod.GET) 
	  public String edit(Model model,    @RequestParam(value="action", required=true ,defaultValue = "1") String action , 
			  @RequestParam(defaultValue = "1",name = "points") long points,
			  @Valid Standing standing,@RequestParam(defaultValue = "1",name = "currentStandings") long option) {
	      switch(action) {
	          case "valider":
	  
	        	  break;
	          case "loss":

	        	  
	        	  break;
	          case "wins":
	              // do stuff
	              break;
	          default:
	              // do stuff
	              break;
	      }
			return "/pages/updateresult";
	  }

	  }


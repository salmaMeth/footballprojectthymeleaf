package Tournoi.Via.Web.Controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Tournoi.Via.Web.Model.But;
import Tournoi.Via.Web.Model.Player;
import Tournoi.Via.Web.Repository.ButRepository;
import Tournoi.Via.Web.Repository.FootballTeamRepositry;
import Tournoi.Via.Web.Repository.PlayersRepositry;
import Tournoi.Via.Web.entity.dao.ButDao;
import Tournoi.Via.Web.entity.dao.JoueurDao;

@Controller
public class GoogleChartsController {
	
	@Autowired // pour l'injection de dépendances
	private FootballTeamRepositry footballRepos;
	
	@Autowired
	private ButDao serviceBut;
		@Autowired
	private JoueurDao serviceJoueur;
	@Autowired // pour l'injection de dépendances
	private ButRepository butRepository;
	@Autowired // pour l'injection de dépendances
	private PlayersRepositry playersRepositry;
	
	
	
	
	@GetMapping(path = "/chart")
	public String getPieChart(Model model, @RequestParam(defaultValue = "1", name = "redSoc" ,required=false) String redSoc) 
	{
                 

			model.addAttribute("players", playersRepositry.findAll());
			
		Map<String, Integer> graphData = new TreeMap<>();
		List<But>  B = serviceBut.findAllByJoueur((Long.valueOf(redSoc)));
		
		for (int i=0; i<B.size();i++)
		{
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			 String year = df.format(B.get(i).getDateBut());
			 
			 int but =butRepository.countAllBydateBut(B.get(i).getDateBut());
			 System.out.println(year+""+B.size());
			 graphData.put(year, but);

		}
		
		
		model.addAttribute("chartData", graphData);
		return "/pages/charts";
	}
}
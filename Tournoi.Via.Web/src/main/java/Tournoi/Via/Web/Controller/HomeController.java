package Tournoi.Via.Web.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Tournoi.Via.Web.Model.Entraineur;
import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Model.Manager;
import Tournoi.Via.Web.Model.Player;
import Tournoi.Via.Web.Repository.FootballTeamRepositry;
import Tournoi.Via.Web.Repository.PlayersRepositry;
import Tournoi.Via.Web.entity.dao.ManagerDao;

@Controller // pour déclarer un contrôleur

public class HomeController {

	@Autowired
	private ManagerDao servicemanager;
	@Autowired // pour l'injection de dépendances
	private FootballTeamRepositry footballRepos;

	@Autowired // pour l'injection de dépendances
	private PlayersRepositry PlayersRepos;

	@RequestMapping(value = "/tableTeams")
	public String tableTeamsf(Model model, // paramètre pour le numéro de la page (0 par défaut)
			@RequestParam(name = "page", defaultValue = "0") int p, // p =numero de page
//paramètre "motCle"
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
//récupérer la page numero "p" (de taille 6)
		Page<FootballTeam> pg = footballRepos.findByteamNameLike("%" + mc + "%", PageRequest.of(p, 10));

//nombre total des pages
		int nbrePages = pg.getTotalPages();
//créer un tableau d'entier qui contient les numéros des pages
		int[] pages = new int[nbrePages];

		for (int i = 0; i < nbrePages; i++) {

			pages[i] = i;
		}

//placer le tableau dans le "Model"
		model.addAttribute("pages", pages);
//placer la page des produits dans le "Model" comme un attribut"
		model.addAttribute("pageteams", pg);
//retourner le numéro de la page courante
		model.addAttribute("pageCourante", p);
//retourner la valeur du mot clé
		model.addAttribute("motCle", mc);
//retourner le nom de la vue WEB à afficher
		return "/pages/footballteam";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(name = "footballTeamId") Long footballTeamId)

	{
		// récupérer l'objet ayant l'id spécifié
		FootballTeam f = footballRepos.findById(footballTeamId).orElse(null);
		// placer le produit trouvé dans le modèle
		model.addAttribute("FootballTeam", f);
		return "/pages/updateFottballTeam";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, @Valid FootballTeam FootballTeam, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			// en cas d'erreurs de validation
			return "/pages/updateFottballTeam";
		// enregistrer le produit dans la BD
		footballRepos.save(FootballTeam);
		// Afficher une page pour confirmer l'enregistrement
		model.addAttribute("FootballTeam", FootballTeam);

		return "/pages/confirmation";
	}

	@RequestMapping(value = "/ok", method = RequestMethod.GET)
	public String valider(Model model) {

		return "redirect:tableTeams";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(FootballTeam FootballTeam, int page, String motCle) {

		footballRepos.deleteById(FootballTeam.getFootballTeamId());

		return "redirect:tableTeams?page=" + page + "&motCle=" + motCle;
	}

	@RequestMapping(value = "/getplayer", method = RequestMethod.GET)
	public String getALLplayer(Model model, FootballTeam FootballTeam,
			@RequestParam(name = "page", defaultValue = "0") int p) {
		Page<Player> pg = PlayersRepos.findBycurrentClub(FootballTeam, PageRequest.of(p, 10));

		int nbrePages = pg.getTotalPages();
		int[] pages = new int[nbrePages];
		for (int i = 0; i < nbrePages; i++) {

			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		model.addAttribute("pageplyer", pg);
		model.addAttribute("pageCourante", p);

		return "/pages/Listplayer";
	}

	
	  @RequestMapping(value="/save",method=RequestMethod.GET) 
	  public String  save(Model model, @Valid FootballTeam FootballTeam, BindingResult bindingResult) {
		  
		  
		  
			 if (bindingResult.hasErrors())
  
				return "redirect:form";
			model.addAttribute("FootballTeam",FootballTeam);


			footballRepos.save(FootballTeam);
 
			return "/pages/confirmation";
		
	    
	  
	  }
	 
	  @RequestMapping(value="/getupdateTeams",method=RequestMethod.GET) 
	  public String  getupdateTeam(Model model  ,@RequestParam(defaultValue = "1",name = "currentTeames") long option) {
			model.addAttribute("FootballTeam", new FootballTeam());

			model.addAttribute("Teams", footballRepos.findAll());

			model.addAttribute("FootTeam", footballRepos.findById(option));

			return "/pages/updateTeams";
		
	    
	  
	  }
	  @RequestMapping(value="/updateTeams",method=RequestMethod.GET) 
	  public String  getTeam(Model model ,@Valid FootballTeam FootTeam, @RequestParam(defaultValue = "1",name = "currentTeames") long option) {
		  FootTeam.setTeamName("REAL");
		//  FootTeam.setTeamName( footballRepos.findById(option).get().getTeamName());

			model.addAttribute("FootTeam",FootTeam );

			model.addAttribute("Teams", footballRepos.findAll());

			footballRepos.save(FootTeam);
			return "/pages/updateTeams";
		
	    
	  
	  }
		 
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formFottballTeam(Model model) {
		// placer un objet de type "Produit" dans le modèle
		model.addAttribute("FootballTeam", new FootballTeam());
		List<Entraineur> Entraineur = servicemanager.findAll();

		model.addAttribute("Entraineur", Entraineur);
		return "/pages/addFottballTeam";
	}
}

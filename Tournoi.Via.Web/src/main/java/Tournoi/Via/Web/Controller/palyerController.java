package Tournoi.Via.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Repository.PlayersRepositry;

@Controller

public class palyerController {

	@Autowired // pour l'injection de dépendances
	private PlayersRepositry PlayersRepos;
	

	
	
	
	
}

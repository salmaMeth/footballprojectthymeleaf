package Tournoi.Via.Web.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import Tournoi.Via.Web.Model.FootballTeam;


public interface FootballTeamRepositry extends JpaRepository<FootballTeam, Long> {

	Page<FootballTeam> findByteamNameLike(String string, Pageable pageable);
	// Retourner la page des Produits selon une recherche par designation
	}

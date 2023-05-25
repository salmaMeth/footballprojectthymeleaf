package Tournoi.Via.Web.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Model.Player;

public interface PlayersRepositry extends JpaRepository<Player, Long> {

	Page<Player> findBycurrentClub( FootballTeam FootballTeam ,Pageable pageable);
	// Retourner la page des Produits selon une recherche par designation
	}

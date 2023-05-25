package Tournoi.Via.Web.entity.dao;


import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Model.Player;

import java.util.List;


/**
 * Provides a list of methods that are used to interact with the table Player in the database.
 *
 * @author Elliot
 */
public interface PlayerDao {

  public List<Player> getAllPlayersForFootballTeam(FootballTeam footballTeam);
}

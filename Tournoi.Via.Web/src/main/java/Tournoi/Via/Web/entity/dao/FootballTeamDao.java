package Tournoi.Via.Web.entity.dao;

import java.util.Collection;

import Tournoi.Via.Web.Model.FootballTeam;

/**
 * @author Salma
 */
public interface FootballTeamDao {

  
  public Collection<FootballTeam> getAllFootballTeams(Long leagueId);

  public FootballTeam getFootballTeamById(Long footballTeamId);

 
  public FootballTeam getFootballTeamByName(String footballTeamName);
}

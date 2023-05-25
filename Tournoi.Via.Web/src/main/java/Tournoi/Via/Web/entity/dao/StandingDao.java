package Tournoi.Via.Web.entity.dao;


import java.util.List;

import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Model.Standing;

/**
 * @author Salma
 */
public interface StandingDao {

  public void createNewStandingForFootballTeam(FootballTeam footballTeam);

  /**
   * Updates the Standing object stored in the database
   *
   * @param standing Standing object to be updated
   */
  public void updateStandingRecord(Standing standing);

  /**
   * @param footballTeamId The FootballTeam you want to retrieve the Standing object for
   * @return The Standing object
   */
  public Standing getStandingByFootballTeamId(Integer footballTeamId);

  /**
   * @param leagueId The league we want all FootballTeam standings for
   * @return List of standings for given league
   */
  //TODO: Replace List<Standing> with LeagueTable object
  public List<Standing> getOrderedTableByLeagueId(Integer leagueId);
}

package Tournoi.Via.Web.entity.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Model.Standing;
import Tournoi.Via.Web.entity.dao.StandingDao;
import Tournoi.Via.Web.standings.StandingComparator;

@Repository
@Transactional
public class StandingDaoImpl implements StandingDao {
	@PersistenceContext
	private EntityManager em;

 
  @Override
  public void updateStandingRecord(Standing standing) {
    String query =
        "UPDATE STANDING SET LEAGUE_ID = ?, FOOTBALL_TEAM_ID = ?, WINS = ?, LOSSES = ?," +
            " DRAWS = ?, GOALS_FOR = ?, GOALS_AGAINST = ?, GOAL_DIFFERENCE = ?," +
            " POINTS = ?, TABLE_POSITION = ?, GAMES_PLAYED = ? WHERE FOOTBALL_TEAM_ID = ?";

     
  }

  @Override
  public Standing getStandingByFootballTeamId(Integer footballTeamId) {
    String query = "SELECT * FROM STANDING WHERE FOOTBALL_TEAM_ID = ?";
	return null;

  }

  @Override
  public List<Standing> getOrderedTableByLeagueId(Integer leagueId) {
    List<Standing> table = new ArrayList<Standing>();
    String query = "SELECT * FROM STANDING WHERE LEAGUE_ID = ?";

    return table;
  }



  private List<Standing> orderTableByPoints(List<Standing> table) {
    return StandingComparator.orderTableByPoints(table);
  }

@Override
public void createNewStandingForFootballTeam(FootballTeam footballTeam) {
	// TODO Auto-generated method stub
	em.persist(footballTeam);

}


}

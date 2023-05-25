package Tournoi.Via.Web.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 * @author Salma
 */
@Entity
public class League {

	@Id
	@GeneratedValue
  private Integer leagueId;
	
	@OneToMany(mappedBy = "League1", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
	private List<Fixture> upcomingFixtures;
	
  private String leagueName;
  private Integer countryId;
  
  @OneToMany(mappedBy = "League", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
  private List<FootballTeam> footballTeams;
  
  

  public League() {

  }

 
  public League(Integer leagueId, String leagueName, Integer countryId, List<FootballTeam> footballTeams,
		List<Fixture> upcomingFixtures) {
	super();
	this.leagueId = leagueId;
	this.leagueName = leagueName;
	this.countryId = countryId;
	this.footballTeams = footballTeams;
	this.upcomingFixtures = upcomingFixtures;
}


public Integer getLeagueId() {
    return leagueId;
  }

  public void setLeagueId(Integer leagueId) {
    this.leagueId = leagueId;
  }

  public String getLeagueName() {
    return leagueName;
  }

  public void setLeagueName(String leagueName) {
    this.leagueName = leagueName;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }

  public List<FootballTeam> getFootballTeams() {
    return footballTeams;
  }

  public void setFootballTeams(List<FootballTeam> footballTeams) {
    this.footballTeams = footballTeams;
  }

  public List<Fixture> getUpcomingFixtures() {
    return upcomingFixtures;
  }

  public void setUpcomingFixtures(List<Fixture> upcomingFixtures) {
    this.upcomingFixtures = upcomingFixtures;
  }

  public String printLeagueMenuInfo() {
    return "[" + this.getLeagueId() + "]" + " " + this.getLeagueName();
  }
}

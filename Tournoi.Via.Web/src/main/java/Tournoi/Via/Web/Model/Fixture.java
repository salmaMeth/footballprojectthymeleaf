package Tournoi.Via.Web.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The Fixture class provides information about an upcoming Football match. Information about the
 * two FootballTeams, competition and date are stored.
 *
 * @author Elliot
 */
@Entity

public class Fixture {

	@Id
	@GeneratedValue
  private Long fixtureId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fixtureId", referencedColumnName = "footballTeamId")	
  private FootballTeam homeTeam;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fixtureId", referencedColumnName = "footballTeamId")
  	    private FootballTeam awayTeam;
  
	
  private Date dateOfFixture;
  
  @ManyToOne
  private League League1;

  public Fixture() {

  }

  public Fixture(Long fixtureId, FootballTeam homeTeam, FootballTeam awayTeam,
      Date dateOfFixture, League League) {
    this.fixtureId = fixtureId;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.dateOfFixture = dateOfFixture;
    
    this.League1 = League;
  }

  public Long getFixtureId() {
    return fixtureId;
  }

  public void setFixtureId(Long fixtureId) {
    this.fixtureId = fixtureId;
  }

  public FootballTeam getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(FootballTeam homeTeam) {
    this.homeTeam = homeTeam;
  }

  public FootballTeam getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(FootballTeam awayTeam) {
    this.awayTeam = awayTeam;
  }

  public Date getDateOfFixture() {
    return dateOfFixture;
  }

  public void setDateOfFixture(Date dateOfFixture) {
    this.dateOfFixture = dateOfFixture;
  }



  public League getLeague() {
	return League1;
}

public void setLeague(League league) {
	this.League1 = league;
}

@Override
public String toString() {
	return "Fixture [fixtureId=" + fixtureId + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", dateOfFixture="
			+ dateOfFixture + ", League=" + League1 + "]";
}

@Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fixture fixture = (Fixture) o;
    return Objects.equals(fixtureId, fixture.fixtureId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fixtureId, homeTeam, awayTeam, dateOfFixture, League1);
  }

 
}

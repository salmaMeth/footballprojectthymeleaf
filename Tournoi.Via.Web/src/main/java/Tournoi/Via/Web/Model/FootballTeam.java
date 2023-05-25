package Tournoi.Via.Web.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import Tournoi.Via.Web.entity.dao.PlayerDao;
import Tournoi.Via.Web.entity.dao.impl.PlayerDaoImpl;
import Tournoi.Via.Web.footballteam.matchsetup.FootballTeamMatchSetup;

/**
 * @author Salma
 */
@Entity


public class FootballTeam implements Serializable  {

	@Id
	@GeneratedValue
  private Long footballTeamId;
	 @Size(min=3, max=50)//spécifier la taille acceptée
	@Column(length = 50)
     private String teamName;
  
  public FootballTeam(@NotNull @Size(min = 3, max = 50) String teamName, String location, String stadium,
			boolean status, Entraineur entraineurcurrent, List<Player> equipe,
			Collection<Player> players) {
		super();
		this.teamName = teamName;
		this.location = location;
		this.stadium = stadium;
		Status = status;
		Entraineurcurrent = entraineurcurrent;
		this.equipe = equipe;
		this.players = players;
	}
@ManyToOne
  private  League League;
  
  public Integer getNbMatchsSuspendus() {
	return NbMatchsSuspendus;
}

public void setNbMatchsSuspendus(Integer nbMatchsSuspendus) {
	NbMatchsSuspendus = nbMatchsSuspendus;
}

public boolean isStatus() {
	return Status;
}

public void setStatus(boolean status) {
	Status = status;
}
private String location;
  private String stadium;
  private Integer stadiumCapacity;
  private Integer  NbMatchsSuspendus;
  
  private boolean Status ;
  @OneToOne(mappedBy = "homeTeam")
  private Fixture Fixtureteamhome;
  
  public Fixture getFixtureteamhome() {
	return Fixtureteamhome;
}

public void setFixtureteamhome(Fixture fixtureteamhome) {
	Fixtureteamhome = fixtureteamhome;
}

public Fixture getFixtureawayTeam() {
	return FixtureawayTeam;
}

public void setFixtureawayTeam(Fixture fixtureawayTeam) {
	FixtureawayTeam = fixtureawayTeam;
}

public Entraineur getEntraineur() {
	return Entraineur;
}

public void setEntraineur(Entraineur entraineur) {
	Entraineur = entraineur;
}

public FootballTeam(Long footballTeamId, @Size(min = 3, max = 50) String teamName, Tournoi.Via.Web.Model.League league,
		String location, String stadium, Integer stadiumCapacity, Integer nbMatchsSuspendus, boolean status,
		Fixture fixtureteamhome, Fixture fixtureawayTeam, Tournoi.Via.Web.Model.Entraineur entraineur,
		Tournoi.Via.Web.Model.Entraineur entraineurcurrent, List<Player> equipe, FootballTeamMatchSetup matchSetup,
		Collection<Player> players) {
	super();
	this.footballTeamId = footballTeamId;
	this.teamName = teamName;
	League = league;
	this.location = location;
	this.stadium = stadium;
	this.stadiumCapacity = stadiumCapacity;
	NbMatchsSuspendus = nbMatchsSuspendus;
	Status = status;
	Fixtureteamhome = fixtureteamhome;
	FixtureawayTeam = fixtureawayTeam;
	Entraineur = entraineur;
	Entraineurcurrent = entraineurcurrent;
	this.equipe = equipe;
	this.matchSetup = matchSetup;
	this.players = players;
}

public Entraineur getEntraineurcurrent() {
	return Entraineurcurrent;
}

public void setEntraineurcurrent(Entraineur entraineurcurrent) {
	Entraineurcurrent = entraineurcurrent;
}
@OneToOne(mappedBy = "awayTeam")
  private Fixture FixtureawayTeam;
  
@ManyToOne(cascade = CascadeType.ALL)
  private Entraineur Entraineur;
  
  @OneToOne(cascade = CascadeType.ALL)
 private Entraineur Entraineurcurrent;
  
 @OneToMany(mappedBy = "currentClub", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })

  private List<Player> equipe;

  
  public League getLeague() {
	return League;
}

public void setLeague(League league) {
	League = league;
}
private FootballTeamMatchSetup matchSetup;

  public FootballTeam() {

  }


  public List<Player> getEquipe() {
	return equipe;
}

public void setEquipe(List<Player> equipe) {
	this.equipe = equipe;
}

public Collection<Player> getPlayers() {
	return players;
}

public void setPlayers(Collection<Player> players) {
	this.players = players;
}
@OneToMany(mappedBy = "FootballTeam", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
	  private Collection<Player> players  = new ArrayList<Player>();

  private void buildequipe() {
    PlayerDao pDao = new PlayerDaoImpl();
    this.setequipe(pDao.getAllPlayersForFootballTeam(this));
  }

  private void getMatchSetupFromDatabase() {
   // FootballTeamMatchSetupDao footballTeamMatchSetupDao = new FootballTeamMatchSetupDaoImpl();
  //  this.setMatchSetup(footballTeamMatchSetupDao.getFootballTeamMatchSetup(footballTeamId));
  }

  public Long getFootballTeamId() {
    return footballTeamId;
  }

  public void setFootballTeamId(Long footballTeamId) {
    this.footballTeamId = footballTeamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

 

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStadium() {
    return stadium;
  }

  public void setStadium(String stadium) {
    this.stadium = stadium;
  }

  public Integer getStadiumCapacity() {
    return stadiumCapacity;
  }

  public void setStadiumCapacity(Integer stadiumCapacity) {
    this.stadiumCapacity = stadiumCapacity;
  }

  public List<Player> getequipe() {
    if (equipe == null) {
    	buildequipe();
    }
    return equipe;
  }

  public void setequipe(List<Player> squad) {
    this.equipe = squad;
  }

  public FootballTeamMatchSetup getMatchSetup() {
    if (matchSetup == null) {
      getMatchSetupFromDatabase();
    }

    return matchSetup;
  }

  public void setMatchSetup(FootballTeamMatchSetup matchSetup) {
    this.matchSetup = matchSetup;
  }


  public String printFootballTeamMenuInfo() {
    return "[" + this.getFootballTeamId() + "]" + " " + this.getTeamName();
  }



  @Override
  public int hashCode() {
    return Objects
        .hash(footballTeamId, teamName, League, location, stadium, stadiumCapacity, equipe,
            matchSetup);
  }
}

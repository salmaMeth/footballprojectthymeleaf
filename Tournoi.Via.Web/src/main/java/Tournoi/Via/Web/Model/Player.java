package Tournoi.Via.Web.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE_player")
@DiscriminatorValue("Player")public class Player implements Serializable {
	@Id
	@GeneratedValue
  private Long id;
	
  public List<Avertissements> getAvertissement() {
		return Avertissement;
	}
  @OneToMany(mappedBy = "Player", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
  private List<But> But;
  
	public void setAvertissement(List<Avertissements> avertissement) {
		Avertissement = avertissement;
	}

	public List<But> getBut() {
		return But;
	}

	public void setBut(List<But> but) {
		But = but;
	}
	 @Size(min=3, max=50)//spécifier la taille acceptée
	@Column(length = 50)
  private String name;
  private Integer age;
  private String nationality;
  private Integer overallRating;
  
	@ManyToOne
	private FootballTeam FootballTeam;
	
	@ManyToOne
	  private FootballTeam currentClub;
	
	  private Double valueFixture;
	  private Double salaire;

	 @OneToMany(mappedBy = "player", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
	  private List<Avertissements> Avertissement;

	  
	  
	  @OneToMany(mappedBy = "Player", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
	  private List<Expulsions> Expulsions;
	
  public List<Expulsions> getExpulsions() {
	return Expulsions;
}

public void setExpulsions(List<Expulsions> expulsions) {
	Expulsions = expulsions;
}

 


  public Player() {

  }

  public Player(Long id, String name, Integer age, String nationality, Integer overallRating,
      FootballTeam currentClub, Double value, Double salaire) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.nationality = nationality;
    this.overallRating = overallRating;
    this.currentClub = currentClub;
    this.valueFixture = value;
    this.salaire = salaire;
  }



	public Double getValueFixture() {
	return valueFixture;
}

public void setValueFixture(Double valueFixture) {
	this.valueFixture = valueFixture;
}

public Double getSalaire() {
	return salaire;
}

public void setSalaire(Double salaire) {
	this.salaire = salaire;
}






  public FootballTeam getFootballTeam() {
		return FootballTeam;
	}

	public void setFootballTeam(FootballTeam footballTeam) {
		FootballTeam = footballTeam;
	}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Integer getOverallRating() {
    return overallRating;
  }

  public void setOverallRating(Integer overallRating) {
    this.overallRating = overallRating;
  }

  public FootballTeam getCurrentClub() {
    return currentClub;
  }

  public void setCurrentClub(FootballTeam currentClub) {
    this.currentClub = currentClub;
  }

  public Double getvalueFixture() {
    return valueFixture;
  }

  public void setvalueFixture(Double value) {
    this.valueFixture = value;
  }

  public Double getsalaire() {
    return salaire;
  }

  public void setWages(Double salaire) {
    this.salaire = salaire;
  }






}

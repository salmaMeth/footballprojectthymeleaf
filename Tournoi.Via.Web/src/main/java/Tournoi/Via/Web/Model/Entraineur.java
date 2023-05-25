package Tournoi.Via.Web.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Entraineur {
	
	@Id
	@GeneratedValue
	private Integer managerId;
	  private String firstName;
	  private String lastName;
	  
	  @OneToMany(mappedBy = "Entraineur", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
	  private List<FootballTeam> FootballTeam;
	  
	  
	  
	  @OneToOne(mappedBy = "Entraineurcurrent",cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
	  private FootballTeam currentFootballTeam;

	  public Entraineur() {

	  }

	  public Entraineur(Integer managerId, String firstName, String lastName,
	      FootballTeam currentFootballTeam) {
	    this.setManagerId(managerId);
	    this.firstName = firstName;
	    this.lastName = lastName;
	    
	    
	    this.currentFootballTeam = currentFootballTeam;
	  }

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

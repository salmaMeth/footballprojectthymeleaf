package Tournoi.Via.Web.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Joueur")

public class Joueur extends Player{
	
	 
	  
	 private Integer BestDistanceMatch;


	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getBestDistanceMatch() {
		return BestDistanceMatch;
	}


	public void setBestDistanceMatch(Integer bestDistanceMatch) {
		BestDistanceMatch = bestDistanceMatch;
	}




	

	
	
	
	
	

}

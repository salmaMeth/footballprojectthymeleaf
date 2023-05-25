package Tournoi.Via.Web.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("Gardien")

public class Gardien extends Player{
	

	 private int BestDistanceMatch;


	public Gardien() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getBestDistanceMatch() {
		return BestDistanceMatch;
	}


	public void setBestDistanceMatch(int bestDistanceMatch) {
		BestDistanceMatch = bestDistanceMatch;
	}


	
	
	
	
	

}

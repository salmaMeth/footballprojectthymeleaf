package Tournoi.Via.Web.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avertissements implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	  private  Player player;
	
	private String avertissements;

	private Integer totalAvertissementsRecu;
	private Integer avertissementsActifs;
	
	public Integer getId() {
		return id;
	}


	public String getAvertissements() {
		return avertissements;
	}

	public void setAvertissements(String avertissements) {
		this.avertissements = avertissements;
	}

	public Integer getTotalAvertissementsRecu() {
		return totalAvertissementsRecu;
	}

	public void setTotalAvertissementsRecu(Integer totalAvertissementsRecu) {
		this.totalAvertissementsRecu = totalAvertissementsRecu;
	}

	public Integer getAvertissementsActifs() {
		return avertissementsActifs;
	}

	public void setAvertissementsActifs(Integer avertissementsActifs) {
		this.avertissementsActifs = avertissementsActifs;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Avertissements() {
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}





	


	

	
	

}
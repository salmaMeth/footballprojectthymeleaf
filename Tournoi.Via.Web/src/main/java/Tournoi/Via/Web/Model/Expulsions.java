package Tournoi.Via.Web.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Expulsions {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	  private  Player Player;
	
	@Column (name ="totaleExpulsions")
	private Integer totaleExpulsions;

	
	public Integer getId() {
		return id;
	}

	public Integer getTotaleExpulsions() {
		return totaleExpulsions;
	}

	public void setTotaleExpulsions(Integer totaleExpulsions) {
		this.totaleExpulsions = totaleExpulsions;
	}

	public Player getPlayer() {
		return Player;
	}

	public void setPlayer(Player player) {
		Player = player;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public Expulsions() {
		super();
	}

}
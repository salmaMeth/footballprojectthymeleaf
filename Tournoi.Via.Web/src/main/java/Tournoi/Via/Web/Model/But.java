package Tournoi.Via.Web.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class But {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Date getDateBut() {
		return dateBut;
	}

	public But() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Player getJoueur() {
		return Player;
	}

	public void setJoueur(Player player) {
		Player = player;
	}


	public void setDateBut(java.util.Date dateBut) {
		this.dateBut = dateBut;
	}


	@Id
	@GeneratedValue
	private Long id;
	

	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	java.util.Date dateBut;
	
	@ManyToOne
	  private Player Player;

	
	

}

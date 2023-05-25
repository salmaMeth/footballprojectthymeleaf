package Tournoi.Via.Web.entity.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.Model.Player;
import Tournoi.Via.Web.entity.dao.PlayerDao;


/**
 * @author Elliot
 */
@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao {

	@PersistenceContext
	private EntityManager em;

  @Override
public List<Player> getAllPlayersForFootballTeam(FootballTeam footballTeam) {
   
		Query query = em.createQuery("select p from Player p where p.currentClub like :footballTeam");
		query.setParameter("footballTeam", footballTeam);
			
		return  query.getResultList();
		

  }





}

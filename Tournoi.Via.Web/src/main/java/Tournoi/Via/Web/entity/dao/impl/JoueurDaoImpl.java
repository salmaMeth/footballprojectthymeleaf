package Tournoi.Via.Web.entity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import Tournoi.Via.Web.Model.Joueur;
import Tournoi.Via.Web.entity.dao.JoueurDao;

@Repository
@Transactional

public class JoueurDaoImpl   implements JoueurDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Joueur> findAll() {
		// TODO Auto-generated method stub
				Query query = em.createQuery("select m from Joueur m ");
				return query.getResultList();
	}

}

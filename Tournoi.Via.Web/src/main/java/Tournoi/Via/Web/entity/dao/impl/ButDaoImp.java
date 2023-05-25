package Tournoi.Via.Web.entity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tournoi.Via.Web.Model.But;
import Tournoi.Via.Web.entity.dao.ButDao;

@Service
@Transactional(readOnly = false)
public class ButDaoImp implements ButDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<But> findAllByJoueur( Long id) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select B from But B where B.Player.id like :id"); 
		     query.setParameter("id", id);
				return query.getResultList();
				}
	
	
	}
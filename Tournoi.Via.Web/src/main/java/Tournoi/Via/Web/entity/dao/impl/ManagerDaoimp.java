package Tournoi.Via.Web.entity.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tournoi.Via.Web.Model.Entraineur;
import Tournoi.Via.Web.entity.dao.ManagerDao;
@Service
@Transactional(readOnly = false)
public class ManagerDaoimp implements ManagerDao {

	@PersistenceContext
	private EntityManager em;


	@Override
	public List<Entraineur> findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select m from Entraineur m ");
		return query.getResultList();
	}



}

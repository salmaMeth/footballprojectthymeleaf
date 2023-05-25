package Tournoi.Via.Web.entity.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tournoi.Via.Web.Model.FootballTeam;
import Tournoi.Via.Web.entity.dao.FootballTeamDao;

@Service
@Transactional(readOnly = false)
public class FootballTeamDaoImpl implements FootballTeamDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Collection<FootballTeam> getAllFootballTeams(Long leagueId) {

		Query query = em.createQuery("select p from FootballTeam p where p.leagueId like :leagueId");
		query.setParameter("leagueId", leagueId);

		return query.getResultList();
	}

	@Override
	public FootballTeam getFootballTeamByName(String footballTeamName) {

		Query query = em.createQuery("select f from FootballTeam f where f.teamName like :footballTeamName");
		query.setParameter("footballTeamName", "%" + footballTeamName + "%");

		return (FootballTeam) query.getResultList();

	}

	@Override
	public FootballTeam getFootballTeamById(Long footballTeamId) {

		FootballTeam f = em.find(FootballTeam.class, footballTeamId);
		return f;

	}
}

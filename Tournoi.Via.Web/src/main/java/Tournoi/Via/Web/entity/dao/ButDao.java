package Tournoi.Via.Web.entity.dao;

import java.util.List;

import Tournoi.Via.Web.Model.But;

public interface ButDao {
	
	 List<But> findAllByJoueur(Long id);



}

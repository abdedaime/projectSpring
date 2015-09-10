package com.pfa.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pfa.app.entities.Utilisateur;
/**
 * 
 * @author hicham-pc
 *
 */
@Repository
public class ImplIdaoUser implements IdaoUser {
	@PersistenceContext(unitName = "UP_Pfa")
	private EntityManager em;

	@Override
	public void add(Utilisateur user) {
		// TODO Auto-generated method stub
		em.persist(user);

	}

	@Override
	public Utilisateur getUser(String email) {
		Utilisateur user = em.find(Utilisateur.class, email);
		return user;
	}

}

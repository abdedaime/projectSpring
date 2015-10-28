package com.pfa.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pfa.app.entities.Role;
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

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		em.persist(role);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> getAllusers() {
		// TODO Auto-generated method stub
	  return	em.createQuery("select u From Utilisateur  u ").getResultList();
		
	}

	@Override
	public void UpdateUser(Utilisateur u) {
		// TODO Auto-generated method stub
		   try {
			   Query query = em.createQuery(
					      "UPDATE Utilisateur  u SET u.enabled =true " +
					      "WHERE u.email='"+u.getEmail()+"'");
					//  int updateCount = query.setParameter("p", u.getEmail()).executeUpdate();
			 int id=  query.executeUpdate();
					  System.out.println("+++++++++++++++++++"+id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		
			}

}

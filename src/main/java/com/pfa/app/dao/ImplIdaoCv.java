package com.pfa.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pfa.app.entities.Competence;
import com.pfa.app.entities.Cv;
import com.pfa.app.entities.Experience;
import com.pfa.app.entities.Formation;
/**
 * 
 * @author hicham-pc
 *
 */
@Repository
public class ImplIdaoCv implements IdaoCv {
	@PersistenceContext(unitName = "UP_Pfa")
	private EntityManager em;

	@Override
	public void addCv(Cv cv) {
		
		em.persist(cv);

	}

	@Override
	public void addCompetence(Competence cmpt) {
		
		em.persist(cmpt);

	}

	@Override
	public void addFormation(Formation fr) {
		
		em.persist(fr);

	}

	@Override
	public void addExperience(Experience ex) {
		
		em.persist(ex);

	}

	@Override
	public Cv getCV(int id) {
		
		return em.find(Cv.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Competence> getCompetence(String mot) {
		
     System.out.println("-----------la requetttte ---------------"+ParsesrXpathJava.construireSql(mot));
		return em.createQuery(ParsesrXpathJava.construireSql(mot)).getResultList();
	}

	@Override
	public Cv getCV(String username) {
		
		Query   qr=null;
		try {
			  qr=em.createQuery("select cv  from Cv  as cv where cv.user.email=:p ");
			qr.setParameter("p", username);
			return (Cv) qr.getSingleResult();
			
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
		  catch (NonUniqueResultException      e) {
			// TODO: handle exception
			  return  (Cv) qr.getResultList().get(0);
		}
		
	}

}

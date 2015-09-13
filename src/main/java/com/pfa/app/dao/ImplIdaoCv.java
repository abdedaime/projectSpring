package com.pfa.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated method stub
		em.persist(cv);

	}

	@Override
	public void addCompetence(Competence cmpt) {
		// TODO Auto-generated method stub
		em.persist(cmpt);

	}

	@Override
	public void addFormation(Formation fr) {
		// TODO Auto-generated method stub
		em.persist(fr);

	}

	@Override
	public void addExperience(Experience ex) {
		// TODO Auto-generated method stub
		em.persist(ex);

	}

	@Override
	public Cv getCV(int id) {
		// TODO Auto-generated method stub
		return em.find(Cv.class, id);
	}

	@Override
	public List<Competence> getCompetence(String mot) {
		// TODO Auto-generated method stub
		   
		return em.createQuery(ParsesrXpathJava.construireSql(mot)).getResultList();
	}

}

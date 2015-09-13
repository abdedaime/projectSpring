package com.pfa.app.dao;

import java.util.List;

import com.pfa.app.entities.Competence;
import com.pfa.app.entities.Cv;
import com.pfa.app.entities.Experience;
import com.pfa.app.entities.Formation;

/***
 * 
 * @author hicham-pc
 * 
 */
public interface IdaoCv {
	public void addCv(Cv cv);

	public void addCompetence(Competence cmpt);

	public void addFormation(Formation fr);

	public void addExperience(Experience ex);

	public Cv getCV(int id);

	public List<Competence> getCompetence(String mot);

}

package com.pfa.app.service;

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
public interface IserviceCv {
	
	public void addCv( Cv cv);
	public void addCompetence( Competence cmpt);
	public void addFormation(Formation  fr);
	public void addExperience(Experience  ex);
	public    Cv getCV(int id);
	public List<Competence> getCompetence(String mot);

}

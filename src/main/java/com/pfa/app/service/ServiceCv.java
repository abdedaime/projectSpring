package com.pfa.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.app.dao.IdaoCv;
import com.pfa.app.entities.Competence;
import com.pfa.app.entities.Cv;
import com.pfa.app.entities.Experience;
import com.pfa.app.entities.Formation;
/***
 * 
 * @author hicham-pc
 *
 */
@Service
@Transactional
public class ServiceCv implements IserviceCv {
	@Autowired
	private IdaoCv daoCv;

	@Override
	public void addCv(Cv cv) {
      daoCv.addCv(cv);
	}

	@Override
	public void addCompetence(Competence cmpt) {
     daoCv.addCompetence(cmpt);
	}

	@Override
	public void addFormation(Formation fr) {
		daoCv.addFormation(fr);

	}

	@Override
	public void addExperience(Experience ex) {
		daoCv.addExperience(ex);
	}

	@Override
	public Cv getCV(int id) {
		
		return daoCv.getCV(id);
	}

	@Override
	public List<Competence> getCompetence(String mot) {
		
		return daoCv.getCompetence(mot);
	}

	@Override
	public Cv getCV(String username) {
		
		return daoCv.getCV(username);
	}

}

package com.pfa.app.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfa.app.entities.Competence;
import com.pfa.app.entities.Cv;
import com.pfa.app.entities.Experience;
import com.pfa.app.entities.Formation;
import com.pfa.app.entities.Utilisateur;
import com.pfa.app.service.IServiceUser;
import com.pfa.app.service.IserviceCv;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/applicationContext.xml")
public class TestDbCv {
	@Autowired
	private IserviceCv serviceCv;
	@Autowired
	private IServiceUser service;
	private Utilisateur u;
	private Cv cv;

	@Before
	public void setUp() {
		u = service.getUser("hicham.suptech@gmail.com");

		System.out.println(u.toString());
	}

	/*
	 * @Test public void teAddCv() { cv = new
	 * Cv("Ingénieur d'étude et developement java/jee at sqli",
	 * "j'ai des bonnes connaisance sur java ,je suis passionée par salesforce"
	 * ); cv.setUser(u); serviceCv.addCv(cv); }
	 */

	@Test
	public void teAddCompetence() {
		/*
		 * Competence cmp = new Competence("java"); cmp.setCv(cv);
		 */
		// serviceCv.addCompetence(cmp);
		/*
		 * Competence cmp1 = new Competence("ejb"); cmp1.setCv(cv);
		 * serviceCv.addCompetence(cmp1); Competence cmp2 = new
		 * Competence("jsp"); cmp2.setCv(cv); serviceCv.addCompetence(cmp2);
		 * Competence mp3 = new Competence("servlet"); mp3.setCv(cv);
		 * serviceCv.addCompetence(mp3);
		 */

	}

//	@Test
//	public void teAddExceperience() {
//		cv = serviceCv.getCV(1);
//
//		Experience ex = new Experience("creation d'une application salesofrce",
//				"mobiblanc", "devvvv", new Date(), new Date());
//		ex.setCv(cv);
//		serviceCv.addExperience(ex);
//	}

	@Test
	public void teAddFormation() {
     Formation   fr=new Formation("bac+5", "software ingénieur", new Date(), new Date(), "commmentaire");
     fr.setCv(serviceCv.getCV(1));
      serviceCv.addFormation(fr);
	}

}

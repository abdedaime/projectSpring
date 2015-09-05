package com.pfa.app.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfa.app.entities.Utilisateur;
import com.pfa.app.service.IServiceUser;

/**
 * 
 * @author PC-Mobiblanc-HP-02
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/applicationContext.xml")
public class UserRoleDbunit {
	@Autowired
    private IServiceUser      service;
	@Test
	public void test() {
		Utilisateur user = new Utilisateur();
		user.setEmail("hicham.suptech@gmail.co");
		user.setDate(new Date());
		user.setEnabled(true);
		user.setNom("hicham");
		user.setPrenom("abdedaim");
		 service.add(user);

	}
}

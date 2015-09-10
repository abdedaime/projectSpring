package com.pfa.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.app.dao.IdaoUser;
import com.pfa.app.entities.Utilisateur;
/**
 * 
 * @author hicham-pc
 *
 */
@Service
@Transactional
public class ServiceUser  implements IServiceUser {
	@Autowired
    private    IdaoUser   dao;
	@Override
	public void add(Utilisateur user) {
		// TODO Auto-generated method stub
		   dao.add(user);
	}

	@Override
	public Utilisateur getUser(String email) {
		// TODO Auto-generated method stub
		return dao.getUser(email);
	}

}

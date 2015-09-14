package com.pfa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.app.dao.IdaoUser;
import com.pfa.app.entities.Role;
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

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		 dao.addRole(role);
	}

	@Override
	public List<Utilisateur> getAllusers() {
		// TODO Auto-generated method stub
		return dao.getAllusers();
	}

	@Override
	public void UpdateUser(Utilisateur u) {
		// TODO Auto-generated method stub
		dao.UpdateUser(u);
	}

}

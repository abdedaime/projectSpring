package com.pfa.app.service;

import java.util.List;

import com.pfa.app.entities.Role;
import com.pfa.app.entities.Utilisateur;

public interface IServiceUser      {
	public void add( Utilisateur user);
	public  Utilisateur   getUser(   String  email);
	public void addRole(Role role);
	public List<Utilisateur> getAllusers();
	public void UpdateUser(Utilisateur u);


}

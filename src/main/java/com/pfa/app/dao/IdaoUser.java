package com.pfa.app.dao;

import com.pfa.app.entities.Role;
import com.pfa.app.entities.Utilisateur;
/**
 * 
 * @author hicham-pc
 *
 */
public interface IdaoUser {
	public void add( Utilisateur user);
	public  Utilisateur   getUser(   String  email);
	public void addRole(Role role);
}

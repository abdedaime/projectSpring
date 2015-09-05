package com.pfa.app.service;

import com.pfa.app.entities.Utilisateur;

public interface IServiceUser      {
	public void add( Utilisateur user);
	public  Utilisateur   getUser(   String  email);

}

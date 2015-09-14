package com.pfa.app.service;

import com.pfa.app.entities.Utilisateur;

public interface IApplicationMailer {
	public void sendMail(Utilisateur  user,String  token);
    public void sendMimeMessage(String from, String to, String subject, String msg) throws Exception;


}

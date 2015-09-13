package com.pfa.app.service;

public interface IApplicationMailer {
	public void sendMail(String to, String subject, String body);
    public void sendMimeMessage(String from, String to, String subject, String msg) throws Exception;


}

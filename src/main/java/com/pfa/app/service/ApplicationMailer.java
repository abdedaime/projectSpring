package com.pfa.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class ApplicationMailer implements  IApplicationMailer {
    @Autowired
    private JavaMailSender mailSender;
    public void sendMail(String to, String subject, String body) 
    {
    	 
        SimpleMailMessage message = new SimpleMailMessage();
        
        
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
    
     
}
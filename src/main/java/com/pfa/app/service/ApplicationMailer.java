package com.pfa.app.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class ApplicationMailer implements IApplicationMailer {
	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String to, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}

	public void sendMimeMessage(String from, String to, String subject,
			String msg) throws Exception {
		MimeMessage mime = this.mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);

		String string = "<!DOCTYPE html>	<html lang='en'>	<head> "
				+ "<title>Bootstrap Example</title>"
				+ "<meta charset='utf-8'>"
				+ " <meta name='viewport' content='width=device-width, initial-scale=1'>"
				+ "  <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>"
				+ "  <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>"
				+ " <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>"
				+ "	</head>"
				+ "  	<body>"

				+ "	<div class='container'> "
				+ "   <div class='jumbotron'> "
				+ "       <h1>Activer votre compte</h1> "
				+ "       <p class='lead'>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p> "
				+ "   <p><a class='btn btn-lg btn-success ' href='#' role='button'>Activer</a></p> "
				+ "   </div> " + "	</div> " + " </body> " + "	</html>";

	/*	String htmlText = "<div style='background:#00FA9A;text-align:center;"
				+ "font-size:12pt;font-weight:bold;color:#800000;padding:10px;'>"
				+ "That feeling when......<br /><br />"
				+ "You miss your spectacles while looking for your spectacles....<br /><br />"
				+ "The person whom you secretly dislike, helps you......<br /><br />"
				+ "The person whom you have crush on seems happy all the time....<br /><br />"
				+ "the beggar recognizes you and stops asking for penny from you since you have never given....<br /><br />"
				+ "</div>";*/
		helper.setText(string, true);
		this.mailSender.send(mime);
	}
}
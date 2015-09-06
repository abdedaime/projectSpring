package com.pfa.app.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfa.app.entities.Utilisateur;
import com.pfa.app.service.IApplicationMailer;
import com.pfa.app.service.IServiceUser;

/**
 * 
 * @author PC-Mobiblanc-HP-02
 * 
 */
@Controller
public class IndexController {
	@Autowired
	private IApplicationMailer app;
	@Autowired
	private IServiceUser iservice;

	@RequestMapping("/")
public String indexz() {
	return "index";
}

@RequestMapping("/index.htm")
public String index() {
	return "index";
}

@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
public String login() {

	return "login";
}

@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
public String register(Model model) {
	model.addAttribute("user", new Utilisateur());
return "register";
}

@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
public String login(@ModelAttribute("user") @Valid Utilisateur user,
	BindingResult bin, Model model) {
System.out.println("tessssssssssst" + bin.toString());

if (bin.hasErrors()) {
	// model.addAttribute("user", user);
	model.addAttribute("succes", false);
	bin.getErrorCount();
	return "register";

}
else {
     user.setConfirmepass(PasswordToMd5(user.getPassword()));
	user.setPassword(PasswordToMd5(user.getPassword()));
	user.setDate(new Date());
	user.setEnabled(true);
	iservice.add(user);
	model.addAttribute("succes", true);
	model.addAttribute("user", new Utilisateur());

	return "register";

	}

}

@RequestMapping("/available.htm")
@ResponseBody
public String available(@RequestParam String email) {
	Boolean available = iservice.getUser(email) == null;
	return available.toString();
}

private String PasswordToMd5(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		 System.out.println(sb.toString());
		return sb.toString();

	}

}

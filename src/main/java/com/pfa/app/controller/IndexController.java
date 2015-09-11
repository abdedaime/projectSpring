package com.pfa.app.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
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

import com.pfa.app.entities.Cv;
import com.pfa.app.entities.Utilisateur;
import com.pfa.app.service.IApplicationMailer;
import com.pfa.app.service.IServiceUser;
import com.pfa.app.service.IserviceCv;

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
	@Autowired
	private IserviceCv serviceCv;

	@RequestMapping("/")
	public String indexz() {
		return "index";
	}

	@RequestMapping("/addCv.htm")
	public String cv(Model model) {
		model.addAttribute("cv", new Cv());
		return "saveCv";
	}

	@RequestMapping("/index.htm")
	public String index(Model model, Principal pr) {
		model.addAttribute("email", pr.getName());
		Utilisateur u = iservice.getUser(pr.getName());
		model.addAttribute("role", u.getRoles().get(0).toString());
		model.addAttribute("user", u.toString());

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

	@RequestMapping(value = "/addCv.htm", method = RequestMethod.POST)
	public String SaveCv(@ModelAttribute("cv") @Valid Cv cv,
			BindingResult bind, Model model, Principal principal) {
		Utilisateur user = iservice.getUser(principal.getName());
		if (bind.hasErrors()) {
			model.addAttribute("succes", false);

			return "saveCv";
		}
		cv.setUser(user);
		serviceCv.addCv(cv);
		model.addAttribute("succes", true);
		model.addAttribute("cv", new Cv());
        return "saveCv";
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

		} else {
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

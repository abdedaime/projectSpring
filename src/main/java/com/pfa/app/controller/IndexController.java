package com.pfa.app.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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

import com.pfa.app.entities.Competence;
import com.pfa.app.entities.Cv;
import com.pfa.app.entities.Experience;
import com.pfa.app.entities.Formation;
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

	@ModelAttribute("cv")
	public Cv monCv() {
		return new Cv();
	}

	@ModelAttribute("formation")
	public Formation formation() {
		return new Formation();
	}
	@ModelAttribute("competence")
	public Competence compt(){
		return   new Competence();
	}

	@ModelAttribute("experience")
	public Experience experience() {
		return new Experience();
	}

	@RequestMapping("/")
	public String indexz() {
		return "index";
	}

	@RequestMapping("/addCv.htm")
	public String cv(Model model) {
		// model.addAttribute("cv", new Cv());
		// model.addAttribute("formation", new Formation());
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
			BindingResult bind, Model model, Principal principal,
			HttpServletRequest request) {
		Utilisateur user = iservice.getUser(principal.getName());
		System.out.println(bind.toString());
		if (bind.hasErrors()) {
			model.addAttribute("cvcreated", false);

			return "saveCv";
		}
		cv.setUser(user);
		serviceCv.addCv(cv);
		request.getSession().setAttribute("cvv", cv);
		model.addAttribute("cvcreated", true);
		model.addAttribute("cv", new Cv());
		return "saveCv";
	}

	@RequestMapping(value = "/addExper.htm", method = RequestMethod.POST)
	public String SaveExper(
			@ModelAttribute("experience") @Valid Experience exp,
			BindingResult bind, Model model, Principal principal,
			HttpServletRequest request) {
		// Utilisateur user = iservice.getUser(principal.getName());
		System.out.println(bind.toString());
		if (bind.hasErrors()) {
			model.addAttribute("expCreated", false);

			return "saveCv";
		}
		final Cv cv = (Cv) request.getSession().getAttribute("cvv");
		request.getSession().setAttribute("cvv", cv);
		exp.setCv(cv);
	//	System.out.println("--------------" + cv.getDescription());
		serviceCv.addExperience(exp);
		model.addAttribute("expCreated", true);
		model.addAttribute("experience", new Experience());
		return "saveCv";
	}

	
	@RequestMapping(value = "/addCompet.htm", method = RequestMethod.POST)
	public String SaveCmpt(
			@ModelAttribute("competence") @Valid Competence cmp,
			BindingResult bind, Model model, Principal principal,
			HttpServletRequest request) {
		// Utilisateur user = iservice.getUser(principal.getName());
		System.out.println(bind.toString());
		if (bind.hasErrors()) {
			model.addAttribute("cmptCreated", false);

			return "saveCv";
		}
		final Cv cv = (Cv) request.getSession().getAttribute("cvv");
		request.getSession().setAttribute("cvv", cv);
		cmp.setCv(cv);
	//	System.out.println("--------------" + cv.getDescription());
		serviceCv.addCompetence(cmp);
		model.addAttribute("cmptCreated", true);
		model.addAttribute("competence", new Competence());
		return "saveCv";
	}
	
	@RequestMapping(value = "/addForm.htm", method = RequestMethod.POST)
	public String SaveFormation(
			@ModelAttribute("formation") @Valid Formation form,
			BindingResult bind, Model model, HttpServletRequest request) {
		// Utilisateur user = iservice.getUser(principal.getName());
		if (bind.hasErrors()) {
			model.addAttribute("succes", false);
			// model.addAttribute("cv", new Cv());

			return "saveCv";
		}
		// Cv cv = serviceCv.getCV(2);
		Cv cv = (Cv) request.getSession().getAttribute("cvv");
		// System.out.println("----------------------- :"+cv.getDescription());
		form.setCv(cv);
		request.getSession().setAttribute("cvv", cv);
		serviceCv.addFormation(form);
		model.addAttribute("succes", true);
		model.addAttribute("formation", new Formation());
		// model.addAttribute("cv", new Cv());
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

		// System.out.println(sb.toString());
		return sb.toString();

	}

}

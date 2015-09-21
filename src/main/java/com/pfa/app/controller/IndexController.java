package com.pfa.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pfa.app.entities.Competence;
import com.pfa.app.entities.Cv;
import com.pfa.app.entities.Experience;
import com.pfa.app.entities.Formation;
import com.pfa.app.entities.Role;
import com.pfa.app.entities.Utilisateur;
import com.pfa.app.service.IApplicationMailer;
import com.pfa.app.service.IServiceUser;
import com.pfa.app.service.IserviceCv;

/**
 * 
 * @author PC-Mobiblanc-HP-02
 * 
 */
// https://gist.github.com/kjunine/7578710
@Controller
public class IndexController {
	
	
	@Value("#{'/resources/img/profile.png'}")
	private Resource resource;
	
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
	public Competence compt() {
		return new Competence();
	}

	@ModelAttribute("experience")
	public Experience experience() {
		return new Experience();
	}

	@RequestMapping(value = "image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getImage(String id)  throws  Exception{
		Utilisateur user = iservice.getUser(id);
		if(user.getPhoto()==null ){
			InputStream in = resource.getInputStream();
			return IOUtils.toByteArray(in);
		}
		return user.getPhoto();
	}

	@RequestMapping("/")
	public String indexz() {
		return "login";
	}

	@RequestMapping(value = "/doactiver.htm", method = RequestMethod.GET)
	public String activer(@RequestParam("token") String token) {
		activerCompte(token.trim());
		return "active";
	}

	@RequestMapping(value = "/profil.htm", method = RequestMethod.GET)
	public String profil(Model model, Principal pr) {

		Utilisateur user = iservice.getUser(pr.getName());
		model.addAttribute("useer", user);
		model.addAttribute("cvv", serviceCv.getCV(pr.getName()));
		return "profil";
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

	@RequestMapping(value = "/index.htm", method = RequestMethod.POST)
	public String search(@RequestParam("search") String mot, Model model) {
		model.addAttribute("userr", serviceCv.getCompetence(mot));
		return "index";
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(Model model) {
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
		// System.out.println("--------------" + cv.getDescription());
		serviceCv.addExperience(exp);
		model.addAttribute("expCreated", true);
		model.addAttribute("experience", new Experience());
		return "saveCv";
	}

	@RequestMapping(value = "/addCompet.htm", method = RequestMethod.POST)
	public String SaveCmpt(@ModelAttribute("competence") @Valid Competence cmp,
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
		// System.out.println("--------------" + cv.getDescription());
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
			BindingResult bin, Model model,
			@RequestParam("image") MultipartFile file) {
		System.out.println("tessssssssssst" + bin.toString());

		if (bin.hasErrors()) {
			// model.addAttribute("user", user);
			model.addAttribute("succes", false);
			bin.getErrorCount();
			return "register";

		} else {
			byte[] content = null;
			if (!file.isEmpty()) {
				try {
					content = file.getBytes();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			app.sendMail(user, PasswordToMd5(user.getEmail().trim()));
			user.setPhoto(content);
			user.setConfirmepass(PasswordToMd5(user.getPassword()));
			user.setPassword(PasswordToMd5(user.getPassword()));
			user.setDate(new Date());
			user.setEnabled(false);
			Role role = new Role();
			role.setUser(user);
			role.setRole(user.getType());

			System.out.println("-------------------" + user.getType());
			iservice.add(user);
			iservice.addRole(role);
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

	private void activerCompte(String token) {
		System.out.println("-----------------" + token);
		// String encrypt=PasswordToMd5(token);
		// System.out.println(encrypt);
		// service.getAllusers()
		// System.out.println(service.getAllusers().size());
		for (Utilisateur u : iservice.getAllusers()) {

			if (PasswordToMd5(u.getEmail()).equals(token)) {
				System.out.println("equaklkkkkkkkkks");
				u.setEnabled(true);
				iservice.UpdateUser(u);

				break;
			}

		}
	}

}

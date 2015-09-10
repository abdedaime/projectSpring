package com.pfa.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.pfa.app.annotation.FieldMatch;
import com.pfa.app.annotation.UniqueUsername;
/**
 * 
 * @author hicham-pc
 *
 */
//https://github.com/jirutka/validator-spring
@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmepass", message ="Mot de passe non conforme"),
})
@Entity
@Table(name = "user")
public class Utilisateur    {
	@Id
	@Email
	@NotNull
	@UniqueUsername(message="adresse  mail  existe    déja")
	private String email;
	@Size(min = 4, max = 10, message = "la taille doit etre entre 3 et 10")
	private String nom;
	@Size(min = 4, max = 10)
	private String prenom;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull
	private Date dateNaissance;
	@Column(name = "date_inscription")
	private Date date;
	@Transient
	@NotNull
	@Size(min = 5, max = 32)
	private String confirmepass;

	public Date getDate() {
		return date;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getConfirmepass() {
		return confirmepass;
	}

	public void setConfirmepass(String confirmepass) {
		this.confirmepass = confirmepass;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	private boolean enabled;
	@NotNull
	@Size(min = 5, max = 32)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Utilisateur [email=" + email + ", nom=" + nom + ", prenom="
				+ prenom + ", dateNaissance=" + dateNaissance + ", date="
				+ date + ", confirmepass=" + confirmepass + ", enabled="
				+ enabled + ", password=" + password + "]";
	}
	
	
	
	
}

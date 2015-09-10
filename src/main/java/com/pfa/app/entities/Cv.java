package com.pfa.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * 
 * @author hicham-pc
 *
 */
@Entity
public class Cv {
	@Id
	@Column(name = "id_cv")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String description;
	@OneToMany(mappedBy = "cv", fetch = FetchType.EAGER)
	private List<Formation> formations;
	@OneToMany(mappedBy = "cv", fetch = FetchType.EAGER)
	private List<Experience> experiences;
	@OneToMany(mappedBy = "cv", fetch = FetchType.EAGER)
	private List<Competence> competences;
	@ManyToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private Utilisateur user;

	public Cv() {
		super();
	}

	public Cv(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

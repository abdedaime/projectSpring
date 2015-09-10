package com.pfa.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author hicham-pc
 * 
 */
// http://stackoverflow.com/questions/5669422/how-to-extract-rdf-triples-from-xml-file-using-an-existing-ontology
@Entity
public class Competence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comp")
	private int id;
	private String nom;
	@ManyToOne
	@JoinColumn(name = "idcv", referencedColumnName = "id_cv")
	private Cv cv;

	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Competence(String nom) {
		super();
		this.nom = nom;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

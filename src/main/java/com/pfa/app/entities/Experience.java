package com.pfa.app.entities;

import java.util.Date;

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
@Entity
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String commentaire;
	private String entrerpise;
	private String mission;
	private Date dateDebut;
	private Date dateFin;
	@ManyToOne
	@JoinColumn(name = "idcv", referencedColumnName = "id_cv")
	private Cv cv;

	public Experience() {
		super();
	}

	public Experience(String commentaire, String entrerpise, String mission,
			Date dateDebut, Date dateFin) {
		super();
		this.commentaire = commentaire;
		this.entrerpise = entrerpise;
		this.mission = mission;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getEntrerpise() {
		return entrerpise;
	}

	public void setEntrerpise(String entrerpise) {
		this.entrerpise = entrerpise;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}

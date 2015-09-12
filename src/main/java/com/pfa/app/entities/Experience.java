package com.pfa.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	@NotNull
	@Size(min=3,max=50)
	private String commentaire;
	@NotNull
	@Size(min=3,max=20)
	private String entrerpise;
	@NotNull
	@Size(min=3,max=20)
	private String mission;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull
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

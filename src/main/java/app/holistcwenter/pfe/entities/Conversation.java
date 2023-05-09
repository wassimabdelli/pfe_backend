package app.holistcwenter.pfe.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conversation implements Serializable  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long emetteur; 
 	private Long destinataire;
 	private String message;
 	private Date date;
 	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(Long emetteur) {
		this.emetteur = emetteur;
	}
	public Long getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(Long destinataire) {
		this.destinataire = destinataire;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
 	
}

package app.holistcwenter.pfe.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Association implements Serializable {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id ;
	  private String name;
	  private String email;
	  private String password;
	  private Date DateFondation;
	  private int numtel;
	  private String categorie;
	  private String img;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateFondation() {
		return DateFondation;
	}
	public void setDateFondation(Date dateFondation) {
		DateFondation = dateFondation;
	}
	public int getNumtel() {
		return numtel;
	}
	public void setNumtel(int numtel) {
		this.numtel = numtel;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	  
	 
	  
}

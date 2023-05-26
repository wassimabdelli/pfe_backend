package app.holistcwenter.pfe.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rep_Ch {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 	private Long idCh;
 	private Long idUser;
 	private Date date;
 	private String img;
 	private String type ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCh() {
		return idCh;
	}
	public void setIdCh(Long idCh) {
		this.idCh = idCh;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
 	
 	
}

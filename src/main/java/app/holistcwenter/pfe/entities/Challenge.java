package app.holistcwenter.pfe.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Challenge implements Serializable {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		private Long idAssoc;
		private String title;
		private String descr;
		private String img;
		private Date date_challenge;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getIdAssoc() {
			return idAssoc;
		}
		public void setIdAssoc(Long idAssoc) {
			this.idAssoc = idAssoc;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public Date getDate_challenge() {
			return date_challenge;
		}
		public void setDate_challenge(Date date_challenge) {
			this.date_challenge = date_challenge;
		}
		 
		

}

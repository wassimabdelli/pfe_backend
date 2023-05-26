package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.holistcwenter.pfe.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>  {
	public List<Utilisateur> findByFirstName(String firstName);
	public Utilisateur findByEmail(String email);
		
}

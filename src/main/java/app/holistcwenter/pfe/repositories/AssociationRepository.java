package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Association;
import app.holistcwenter.pfe.entities.Utilisateur;

public interface AssociationRepository extends JpaRepository<Association, Long>{
	
	public List<Association> findByName(String Name);
	public Association findByEmail(String email);
}

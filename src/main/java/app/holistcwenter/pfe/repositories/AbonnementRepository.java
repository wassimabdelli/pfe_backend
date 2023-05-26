package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Abonnement;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long>{
	
	List<Abonnement> findByIdUser(Long idUser);
	
}

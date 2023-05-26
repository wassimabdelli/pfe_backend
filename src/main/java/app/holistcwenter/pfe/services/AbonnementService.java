package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Abonnement;

public interface AbonnementService {

	// Methode basique
	public List<Abonnement> getAllAbonnement();
	public Abonnement createAbonnement(Abonnement aboonAbonnement);
	public void deleteAbonnement(Long id);
	//methode avancees
	List<Abonnement> findByIdUser(Long idUser);
	
}

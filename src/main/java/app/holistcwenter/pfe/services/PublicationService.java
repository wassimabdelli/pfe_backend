package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Utilisateur;


public interface PublicationService {
	
	// Methode basique
	public List<Publication>getAllPubs(); 
	public Publication findPubsById(Long id); 
	public Publication createPublication(Publication publication); 
	public Publication updatePublication(Publication publication);  
	public void deletePublication(Long id); 
	//Methode avacée 
	public List<Publication> findByIdUser(Long IdUser);

}

package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Association;
import app.holistcwenter.pfe.entities.Utilisateur;

public interface AssociationService {
	
	//methode crud basique
	public List<Association>getAllAssociations();
	public Association findAssociationById(Long id);
	public Association createAssociation(Association association);
	public Association UpdateAssociation(Association association);
	public void deleteAssociation(Long id); 
	//methode avancees
	public List<Association> findByName(String Name);
	public Association findByEmail(String email);

	
	
}

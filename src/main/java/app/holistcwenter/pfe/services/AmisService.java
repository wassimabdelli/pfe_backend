package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Amis;

public interface AmisService {
	// Methode basique
	public List<Amis>getAllAmis(); 
	public Amis createAmis(Amis amis); 
	public void deleteAmis(Long id); 
	//Methode Avancées
	List<Amis> findByIdCompte(Long idCompte);
	List<Amis> findByIdCompteAndIdAmi(Long idCompte , Long idAmi);
	List<Amis> findByIdAmiAndIdCompte(Long idAmi , Long idCompte);
}

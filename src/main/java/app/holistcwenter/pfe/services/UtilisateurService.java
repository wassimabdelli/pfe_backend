package app.holistcwenter.pfe.services;

import java.util.List;


import app.holistcwenter.pfe.entities.Utilisateur;

public interface UtilisateurService {
	//methode crud basique
	public List<Utilisateur>getAllUtilisateurs();
	public Utilisateur findUtilisateurById(Long id);
	public Utilisateur createUtilisateur(Utilisateur utilisateur); 
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);  
	public void deleteUtilisateur(Long id); 
	
	//methode avacees
	public List<Utilisateur> findByFirstName(String firstName);
	public Utilisateur findByEmail(String email);
//	public List<Long> Tab(Long id);
	
	
}

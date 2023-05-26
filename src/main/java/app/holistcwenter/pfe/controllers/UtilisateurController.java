package app.holistcwenter.pfe.controllers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.holistcwenter.pfe.entities.Utilisateur;
import app.holistcwenter.pfe.services.UtilisateurService;
 
@RestController
@RequestMapping("/utilisateur") //localhost:8080/utilisateur  
public class UtilisateurController {
	
	@Autowired					
	private UtilisateurService utilisateurService;
	
	@GetMapping  
	public List<Utilisateur> getAllUtilisateurs() {
		
		return utilisateurService.getAllUtilisateurs();
		
	}
	
	@GetMapping(path = "/{id}")//localhost:8080/utilisateur/3  
	public ResponseEntity<Utilisateur> findUtilisateurById(@PathVariable Long id) {
	 	Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
	 	if(utilisateur == null) {	
	 		return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
		}
	} 

	@PostMapping
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) 
	{

		return utilisateurService.createUtilisateur(utilisateur);
	}
	
	@PutMapping
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
			
			return utilisateurService.updateUtilisateur(utilisateur);
		}
	@DeleteMapping(path = "/{id}") //localhost:8080/utilisateur/3  
	public void deleteUtilisateur(@PathVariable Long id) {
		
		 utilisateurService.deleteUtilisateur(id);
	}

	@GetMapping(path = "/findbyFirstName/{firstName}")//localhost:8080/utilisateur//findbyFirstName{id}  
	public ResponseEntity<List<Utilisateur>> findUtilisateurByFirstName(@PathVariable String firstName) {
	 	List<Utilisateur> utilisateur = utilisateurService.findByFirstName(firstName);
	 	if(utilisateur.isEmpty()) {
	 		return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateur,HttpStatus.OK);
		}
	} 
	@GetMapping(path = "/login/{email}/{password}")//localhost:8080/utilisateur/"/login/email/password
	 public Long authenticate(@PathVariable String email,@PathVariable  String password) {
		    Utilisateur utilisateur = utilisateurService.findByEmail(email);
		      if (password.equals(utilisateur.getPassword()) && email.equals(utilisateur.getEmail()  )) {
		    	  return utilisateur.getId();
		      }else {
				return null ;
			}	
		      
		    }
	@GetMapping(path = "/random/{idExclu}")
	public List<Utilisateur> getUtilisateursAleatoires(@PathVariable Long idExclu) {
		    List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
	    utilisateurs = utilisateurs.stream()
	        .filter(u -> !u.getId().equals(idExclu))
	        .collect(Collectors.toList());
	    Collections.shuffle(utilisateurs);
	    return utilisateurs.subList(0, 4);
	}

}

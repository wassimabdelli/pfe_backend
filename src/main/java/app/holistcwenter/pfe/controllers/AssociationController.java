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

import app.holistcwenter.pfe.entities.Abonnement;
import app.holistcwenter.pfe.entities.Association;
import app.holistcwenter.pfe.entities.Utilisateur;
import app.holistcwenter.pfe.repositories.AssociationRepository;
import app.holistcwenter.pfe.services.AbonnementService;
import app.holistcwenter.pfe.services.AssociationService;


@RestController
@RequestMapping("/association") //localhost:8080/association  
public class AssociationController {
	
				
	private AssociationService associationService;
	private AbonnementService abonnementService;
	@Autowired	
	public AssociationController(AssociationService associationService , AbonnementService abonnementService )
	{
		this.associationService = associationService;
		this.abonnementService = abonnementService;
	}
	@GetMapping  
	public List<Association> getAllAssociations() {
		
		return associationService.getAllAssociations();
		
	}
	@GetMapping(path = "/{id}")//localhost:8080/association/3  
	public ResponseEntity<Association> findAssociationById(@PathVariable Long id) {
	 	Association association= associationService.findAssociationById(id);
	 	if(association == null) {	
	 		return new ResponseEntity<Association>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<Association>(association,HttpStatus.OK);
		}
	} 
	
	@PostMapping
	public Association createAssociation(@RequestBody Association association) 
	{

		return associationService.createAssociation(association);
	}
	
	@PutMapping
	public Association updateUtilisateur(@RequestBody Association association) {
			
			return associationService.UpdateAssociation(association);
		}
	@DeleteMapping(path = "/{id}") //localhost:8080/association/3  
	public void deleteUtilisateur(@PathVariable Long id) {
		
		 associationService.deleteAssociation(id);
	}
	
	@GetMapping(path = "/findAssocByName/{name}")//localhost:8080/association//findAssocByName/{id}  
	public ResponseEntity<List<Association>> findAssociationByName(@PathVariable String name) {
	 	List<Association> association = associationService.findByName(name);
	 	if(association.isEmpty()) {
	 		return new ResponseEntity<List<Association>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Association>>(association,HttpStatus.OK);
		}
	} 
	
	
	
	
	@GetMapping(path = "/login/{email}/{password}")//localhost:8080/utilisateur/"/login/email/password
	 public Long authenticate(@PathVariable String email,@PathVariable  String password) {
		    Association association = associationService.findByEmail(email);
		      if (password.equals(association.getPassword()) && email.equals(association.getEmail()  )) {
		    	  return association.getId();
		      }else {
				return null ;
			}	
		      
		    }
	
	@GetMapping(path = "/aleatoire/{assoc_exclu}")
	public List<Association> getAssociationAleatoires(@PathVariable Long assoc_exclu) {
		List<Abonnement> listesAssoc = abonnementService.findByIdUser(assoc_exclu);
	 	List idAssoc = new ArrayList<>();
	 	for (Abonnement assoc : listesAssoc) {
	 		idAssoc.add(assoc.getIdAssoc()); 
	 	}
	 	List<Association> associations = associationService.getAllAssociations();
	    List<Association> RandomAssoc = associations.stream()
	            .filter(assoc -> !idAssoc.contains(assoc.getId()))
	            .collect(Collectors.toList());
	    Collections.shuffle(RandomAssoc);
	    return RandomAssoc.subList(0, 4);
	}
		
		
	
		@GetMapping(path = "/test/{idUser}")
	public List<Long> listeAbonnement(@PathVariable Long idUser) {
	 	List<Abonnement> listesAssoc = abonnementService.findByIdUser(idUser);
	 	List idAssoc = new ArrayList<>();
	 	for (Abonnement assoc : listesAssoc) {
	 		idAssoc.add(assoc.getIdAssoc()); 
	 	}
	 	return idAssoc;
	}
}
/*  List<Association> associations = associationService.getAllAssociations();
associations = associations.stream()
.filter(assoc -> !assoc.getId().equals(assoc_exclu))
.collect(Collectors.toList());
Collections.shuffle(associations);
return associations.subList(0, 4);*/
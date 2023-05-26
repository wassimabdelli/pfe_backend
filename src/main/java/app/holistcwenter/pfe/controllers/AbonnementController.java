package app.holistcwenter.pfe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.holistcwenter.pfe.entities.Abonnement;
import app.holistcwenter.pfe.entities.Amis;
import app.holistcwenter.pfe.services.AbonnementService;

@RestController
@RequestMapping("/abonnement") //localhost:8080/abonnement
public class AbonnementController {
	
	private AbonnementService abonnementService;
	
	@Autowired
	public AbonnementController (AbonnementService abonnementService) {
		this.abonnementService = abonnementService;
	}
	
	@GetMapping	
	public List<Abonnement> getAllAbonnement() {
		return abonnementService.getAllAbonnement();	
	}

	@PostMapping
	public Abonnement createAbonnement(@RequestBody Abonnement abonnement) 
	{

		return abonnementService.createAbonnement(abonnement);
	}
	
	@DeleteMapping(path = "/{id}") //localhost:8080/abonnement/3  
	public void deleteAbonnement(@PathVariable Long id) {
        	abonnementService.deleteAbonnement(id);
	}
	
	@GetMapping(path = "/listeAbonnementV1/{idUser}")
	public List<Long> listeAbonnementV1(@PathVariable Long idUser) {
	 	List<Abonnement> listesAssoc = abonnementService.findByIdUser(idUser);
	 	List idAssoc = new ArrayList<>();
	 	for (Abonnement assoc : listesAssoc) {
	 		idAssoc.add(assoc.getIdAssoc()); 
	 	}
	 	return idAssoc;
	}
	
	@GetMapping(path = "/listeAbonnementV2/{idUser}")
	public List<Abonnement> listeAbonnementV2(@PathVariable Long idUser) {
	 	List<Abonnement> listesAssoc = abonnementService.findByIdUser(idUser);
	 	List idAssoc = new ArrayList<>();
	 	for (Abonnement assoc : listesAssoc) {
	 		idAssoc.add(assoc); 
	 	}
	 	return idAssoc;
	}
}

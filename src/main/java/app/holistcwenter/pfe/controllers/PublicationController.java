package app.holistcwenter.pfe.controllers;

import java.util.Collections;
import java.util.Comparator;
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

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Utilisateur;
import app.holistcwenter.pfe.services.PublicationService;

@RestController
@RequestMapping("/publication") //localhost:8080/publication
public class PublicationController {
	
	private PublicationService publicationService;

	@Autowired
	public PublicationController(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
	
	@GetMapping	
	public List<Publication> getAllpubs() {
		return publicationService.getAllPubs();	
	}
	@GetMapping(path = "/{id}")//localhost:8080/publication/3  
	public ResponseEntity<Publication> findPublicationById(@PathVariable Long id) {
	 	Publication publication = publicationService.findPubsById(id);
	 	
	 	if(publication == null) {	
	 		return new ResponseEntity<Publication>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<Publication>(publication,HttpStatus.OK);
		}
	} 

	@PostMapping
	public Publication createPublication(@RequestBody Publication publication) 
	{

		return publicationService.createPublication(publication);
	}
	@PutMapping
	public Publication updatePublication(@RequestBody Publication publication) {
			
			return publicationService.updatePublication(publication);
		}
	
	@DeleteMapping(path = "/{id}") //localhost:8080/publication/3  
	public void deletePublication(@PathVariable Long id) {
		
		publicationService.deletePublication(id);
	}
	@GetMapping(path = "/findbyIdUser/{iduser}")//localhost:8080/publication/findbyIdUser{iduser}  
	public ResponseEntity<List<Publication>> findPublicationByIdUser(@PathVariable Long iduser) {
	 	List<Publication> publication = publicationService.findByIdUser(iduser);
	 	 publication.sort(Comparator.comparing(Publication::getDate_pub).reversed());
	 	if(publication.isEmpty()) {
	 		return new ResponseEntity<List<Publication>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Publication>>(publication,HttpStatus.OK);
		}
	} 
	
	
	
	@GetMapping(path = "/findbyIdUser/{iduser}/{type}")//localhost:8080/publication/findbyIdUser{iduser}  
	public ResponseEntity<List<Publication>> findPublicationByIdUserAndType(@PathVariable Long iduser , @PathVariable String type) {
	 	List<Publication> publication = publicationService.findByIdUserAndType(iduser,type);
	 	 publication.sort(Comparator.comparing(Publication::getDate_pub).reversed());
	 	if(publication.isEmpty()) {
	 		return new ResponseEntity<List<Publication>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Publication>>(publication,HttpStatus.OK);
		}
	} 
	
	
	@GetMapping(path = "/randomPubs")
	public List<Publication> getPublicationsAleatoires() {
		    List<Publication> pubs = publicationService.getAllPubs();
		    int l = pubs.size() / 2; 
		    pubs = pubs.stream()
	        .collect(Collectors.toList());
	    Collections.shuffle(pubs);
	    return pubs.subList(0, l);
	}
	
	
	
	
	
}

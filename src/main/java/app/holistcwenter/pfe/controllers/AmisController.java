package app.holistcwenter.pfe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.holistcwenter.pfe.entities.Amis;
import app.holistcwenter.pfe.entities.Reaction;
import app.holistcwenter.pfe.services.AmisService;

@RestController
@RequestMapping("/amis") //localhost:8080/amis
public class AmisController {
	private AmisService amisService;
	
	@Autowired
	public  AmisController(AmisService amisService) {
		this.amisService = amisService;
	}
	
	@GetMapping	
	public List<Amis> getAllAmis() {
		return amisService.getAllAmis();	
	}
	
	@PostMapping
	public Amis createAmis(@RequestBody Amis amis) 
	{

		return amisService.createAmis(amis);
	}
	
	@DeleteMapping(path = "/{id}") //localhost:8080/amis/3  
	public void deleteAis(@PathVariable Long id) {
        	amisService.deleteAmis(id);
	}
	
	
	
	
	
	
	@GetMapping(path = "/{idCompte}")//localhost:8080/amis/3  
	public ResponseEntity<List<Amis>> findAmisById(@PathVariable Long idCompte) {
	 	List<Amis> amis = amisService.findByIdCompte(idCompte);
	 	if(amis == null) {	
	 		return new ResponseEntity<List<Amis>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Amis>>(amis,HttpStatus.OK);
	} 
	}
	
	
	
	
	@GetMapping(path = "/chercher/{idCompte}")//localhost:8080/amis/3  
	public List<Long> findIdAmis(@PathVariable Long idCompte) {
	 	List<Amis> amis = amisService.findByIdCompte(idCompte);
	 	List idAMI = new ArrayList<>();
	 	for (Amis ami : amis) {
	 	   idAMI.add(ami.getIdAmi()); 
	 	}
	 	return idAMI;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

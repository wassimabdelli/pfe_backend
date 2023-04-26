package app.holistcwenter.pfe.controllers;

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

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Invitation;
import app.holistcwenter.pfe.entities.Reaction;
import app.holistcwenter.pfe.services.InvitationService;

@RestController
@RequestMapping("/invitation") //localhost:8080/invitation
public class InvitationController {
	private InvitationService invitationService;
	
	@Autowired
	public InvitationController(InvitationService invitationService) {
		this.invitationService = invitationService;
	}
	
	@GetMapping	
	public List<Invitation> getAllInvits() {
		return invitationService.getAllInvits();	
	}
	@PostMapping
	public Invitation createInvi(@RequestBody Invitation invitation) 
	{

		return invitationService.createInvi(invitation);
	}
	
	@DeleteMapping(path = "/{id}") //localhost:8080/invitation/3  
	public void deleteInvit(@PathVariable Long id) {
		invitationService.deleteInvi(id);
	}
	
	
	@GetMapping(path = "/{destinataire}")//localhost:8080/invitation./3
	public ResponseEntity<List<Invitation>> findIvitationsById(@PathVariable Long destinataire) {
	 	List<Invitation> invitations = invitationService.findByDestinataire(destinataire);
	 	if(invitations == null) {	
	 		return new ResponseEntity<List<Invitation>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Invitation>>(invitations,HttpStatus.OK);
	} 
	}
	
	
}

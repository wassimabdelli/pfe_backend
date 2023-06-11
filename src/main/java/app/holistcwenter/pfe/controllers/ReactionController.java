package app.holistcwenter.pfe.controllers;

import java.util.List;

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

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Reaction;
import app.holistcwenter.pfe.entities.Utilisateur;
import app.holistcwenter.pfe.services.PublicationService;
import app.holistcwenter.pfe.services.ReactionService;

@RestController
@RequestMapping("/reaction") //localhost:8080/reaction
public class ReactionController {

	private ReactionService reactionService;

	@Autowired
	public ReactionController(ReactionService reactionService) {
		this.reactionService = reactionService;
	}
	
	@GetMapping	
	public List<Reaction> getAllReactions() {
		return reactionService.getAllReactions();	
	}
	
	@GetMapping(path = "/{idPub}")//localhost:8080/Reaction/3  
	public ResponseEntity<List<Reaction>> findReactionById(@PathVariable Long idPub) {
	 	List<Reaction> reaction = reactionService.findByIdPub(idPub);
	 	if(reaction == null) {	
	 		return new ResponseEntity<List<Reaction>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Reaction>>(reaction,HttpStatus.OK);
	} 
	}
	
	@PostMapping
	public Reaction createReaction(@RequestBody Reaction reaction) 
	{

		return reactionService.createReaction(reaction);
	}
	
	@PutMapping
	public Reaction updatePublication(@RequestBody Reaction reaction) {
			
			return reactionService.updateReaction(reaction);
		}
	
	@DeleteMapping(path = "/{idUser}/{idPub}") //localhost:8080/reaction/3  
	public void deleteReaction(@PathVariable Long idUser,@PathVariable Long idPub  ) {
		
		  Reaction reaction= reactionService.findByIdUserIdPub(idUser, idPub);
		reactionService.deleteReaction(reaction);
	}
	
	
	@GetMapping(path = "/countLike/{idPub}")//localhost:8080/reaction/countLike/3
	 public Long countLike(@PathVariable  Long idPub) {
		    List<Reaction> reaction= reactionService.findByIdPub(idPub);
		    var count = 0;
		    for(Reaction r : reaction)
		    {
		      if (r.getType().equals("Like"))  {
		    	  count++;
		      }
		      
		    }
		    return (long) count;
	}
	
	@GetMapping(path = "/countDislike/{idPub}")//localhost:8080/reaction/countLike/3
	 public Long countDislike(@PathVariable  Long idPub) {
		    List<Reaction> reaction= reactionService.findByIdPub(idPub);
		    var count = 0;
		    for(Reaction r : reaction)
		    {
		      if (r.getType().equals("Dislike"))  {
		    	  count++;
		      }
		      
		    }
		    return (long) count;
	}
	// trouver sa reaction 
	@GetMapping(path = "/findReact/{idUser}/{idPub}")//localhost:8080/reaction/findReact/3
	 public Reaction findreactByUser(@PathVariable  Long idUser,@PathVariable  Long idPub) {
		    Reaction reaction= reactionService.findByIdUserIdPub(idUser, idPub);
		  return reaction;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

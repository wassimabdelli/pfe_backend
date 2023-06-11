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

import app.holistcwenter.pfe.entities.Challenge;
import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.services.ChallengeService;

@RestController
@RequestMapping("/challenge") 
public class ChallengeController {

	private ChallengeService challengeService; 
	
	@Autowired
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}
	
	@GetMapping	
	public List<Challenge> getAllChallenges() {
		return challengeService.getAllChallenges();	
	}
	
	@GetMapping(path = "/{id}")//localhost:8080/challenge/3  
	public ResponseEntity<Challenge> findChallengesById(@PathVariable Long id) {
	 	Challenge challenge= challengeService.findById(id);
	 	
	 	if(challenge == null) {	
	 		return new ResponseEntity<Challenge>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<Challenge>(challenge,HttpStatus.OK);
		}
	} 
	@PostMapping
	public Challenge createChallenge(@RequestBody Challenge challenge) 
	{

		return challengeService.createChallenge(challenge);
	}
	@PutMapping
	public Challenge updateChallenge(@RequestBody Challenge challenge) {
			
			return challengeService.updateChallenge(challenge);
		}
	@DeleteMapping(path = "/{id}") //localhost:8080/challenge/3  
	public void deleteChallenge(@PathVariable Long id) {
		
		challengeService.deleteChallenge(id);
	}
	@GetMapping(path = "/findbyIdAssoc/{idAssoc}")//localhost:8080/challenge/findbyIdAssocr{idAssoc}  
	public ResponseEntity<List<Challenge>> findChallengeByIdAssoc(@PathVariable Long idAssoc) {
	 	List<Challenge> challenges = challengeService.findByIdAssoc(idAssoc);
	 	 challenges.sort(Comparator.comparing(Challenge::getDate_challenge).reversed());
	 	if(challenges.isEmpty()) {
	 		return new ResponseEntity<List<Challenge>>(HttpStatus.NO_CONTENT);
	 	}else {
			return new ResponseEntity<List<Challenge>>(challenges,HttpStatus.OK);
		}
	} 
	
	@GetMapping(path = "/randomCh")
	public List<Challenge> getChallengesAleatoires() {
		    List<Challenge> ch = challengeService.getAllChallenges();
		    int l = ch.size() / 2; 
		    ch = ch.stream()
	        .collect(Collectors.toList());
	    Collections.shuffle(ch);
	    return ch.subList(0, l);
	}
	
	
}

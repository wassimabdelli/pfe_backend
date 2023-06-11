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

import app.holistcwenter.pfe.entities.Amis;
import app.holistcwenter.pfe.entities.Followers;
import app.holistcwenter.pfe.services.FollowersService;

@RestController
@RequestMapping("/follow") //localhost:8080/follow
public class FollowersController {
	
	private FollowersService followersService;
	@Autowired 
	public FollowersController(FollowersService followersService) {
		this.followersService = followersService;
	}
	
	@GetMapping	
	public List<Followers> getAllFollowers() {
		return followersService.getAllFollowers();	
	}
	@PostMapping
	public Followers createFollow(@RequestBody Followers followers) 
	{

		return followersService.createFollow(followers);
	}
	@DeleteMapping(path = "/{id}") //localhost:8080/follow/3  
	public void deleteFollow(@PathVariable Long id) {
        	followersService.deleteFollow(id);
	}
	
	@GetMapping(path = "/listeFollow/{idAssoc}")
	public List<Long> listeFollow(@PathVariable Long idAssoc) {
	 	List<Followers> listeUser = followersService.findByIdAssoc(idAssoc);
	 	List idUsers = new ArrayList<>();
	 	for (Followers user : listeUser) {
	 		idUsers.add(user.getIdUser()); 
	 	}
	 	return idUsers;
	}
	
	@GetMapping(path = "/listFollow/{idAssoc}")
	public List<Followers> findIdAmis(@PathVariable Long idAssoc) {
	 	List<Followers> followers = followersService.findByIdAssoc(idAssoc);
	 	List idFollowers = new ArrayList<>();
	 	for (Followers followerss : followers) {
	 		if(followerss.getType().equals("assoc"))
	 		{
	 			idFollowers.add(followerss.getIdUser()); 
	 		}
	 		
	 	}
	 	return followers;
	}
	
}

package app.holistcwenter.pfe.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Rep_Ch;
import app.holistcwenter.pfe.services.RepChService;

@RestController	
@RequestMapping("/repch") //localhost:8080/repch
public class RepChController {
	private RepChService repChService;
	
	@Autowired
	public RepChController (RepChService repChService) {
		this.repChService = repChService;
	}
	
	@GetMapping
	public List<Rep_Ch> getAllRepCh() {
		return repChService.getAllRepCh();
	}
	
	@PostMapping
	public Rep_Ch createRepCh ( @RequestBody Rep_Ch rep_Ch) {
		return repChService.createRepCh(rep_Ch);
	}
	@PutMapping
	public Rep_Ch updateRepCh (@RequestBody Rep_Ch rep_Ch) {
		return repChService.updateRepCh(rep_Ch);
	}
	
	@DeleteMapping(path ="/{id}")//localhost:8080/RepCh/3  
	public void deleteRepCh(@PathVariable Long id) {
		repChService.deleteRepCh(id);
	}
	@GetMapping(path="/{idCh}")
	public List<Rep_Ch> findByIdCh(@PathVariable Long idCh){
		List<Rep_Ch> rep = repChService.findByIdCh(idCh);
		rep.sort(Comparator.comparing(Rep_Ch::getDate).reversed());
		return rep;
	}
	
	@GetMapping(path="/{idCh}/{idUser}")
	public List<Rep_Ch> findByIdChAndIdUser(@PathVariable Long idCh , @PathVariable Long idUser ){
		List<Rep_Ch> rep = repChService.findByIdUserAndIdCh(idCh, idUser);
		rep.sort(Comparator.comparing(Rep_Ch::getDate).reversed());
		return rep;
	}
	
	
	@GetMapping(path = "/randomCH")
	public List<Rep_Ch> getPublicationsAleatoires() {
		    List<Rep_Ch> Ch = repChService.getAllRepCh();
		    int l = Ch.size() / 2; 
		    Ch = Ch.stream()
	        .collect(Collectors.toList());
	    Collections.shuffle(Ch);
	    return Ch.subList(0, l);
	}
	
	
}

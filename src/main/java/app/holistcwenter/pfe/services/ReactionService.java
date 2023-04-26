package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Reaction;

public interface ReactionService {
	
		//Methode basique
		public List<Reaction>getAllReactions(); 
		public Reaction findReactionById(Long id); 
		public Reaction createReaction(Reaction reaction); 
		public Reaction updateReaction(Reaction reaction);  
		public void deleteReaction(Reaction reaction); 
		//Methode avacée 
		List<Reaction> findByIdPub(Long idPub);
		 Reaction findByIdUserIdPub(Long idUser, Long isPub);
}

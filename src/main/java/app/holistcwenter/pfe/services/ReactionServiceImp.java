package app.holistcwenter.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Reaction;
import app.holistcwenter.pfe.repositories.PublicationRepository;
import app.holistcwenter.pfe.repositories.ReactionRepository;

@Service
public class ReactionServiceImp implements ReactionService {
	
	@Autowired
	private ReactionRepository reactionRepository;

	@Override
	public List<Reaction> getAllReactions() {
		return reactionRepository.findAll();
	}

	@Override
	public Reaction findReactionById(Long id) {
		Optional<Reaction> utOptional = reactionRepository.findById(id);
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return utOptional.get();
	}
	}

	@Override
	public Reaction createReaction(Reaction reaction) {
		return reactionRepository.save(reaction);
	}

	@Override
	public Reaction updateReaction(Reaction reaction) {
		Optional<Reaction> utOptional = reactionRepository.findById(reaction.getId());
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return reactionRepository.save(reaction);
		}
	}

	@Override
	public void deleteReaction(Reaction reaction) {
		
		reactionRepository.delete(reaction); 		
		
	}

	@Override
	public List<Reaction> findByIdPub(Long idPub) {
		return reactionRepository.findByIdPub(idPub);
	}

	@Override
	public Reaction findByIdUserIdPub(Long idUser, Long isPub) {
		return reactionRepository.findByIdUserAndIdPub(idUser, isPub);
	}

	
	
}

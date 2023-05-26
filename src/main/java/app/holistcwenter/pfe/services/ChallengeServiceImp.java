package app.holistcwenter.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Challenge;
import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.repositories.ChallengeRepository;

@Service
public class ChallengeServiceImp implements ChallengeService {

	@Autowired
	private ChallengeRepository challengeRepository;
	
	@Override
	public List<Challenge> getAllChallenges() {
	return challengeRepository.findAll();
	}

	@Override
	public Challenge findById(Long id) {
		Optional<Challenge> utOptional = challengeRepository.findById(id);
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return utOptional.get();
		}
	}

	@Override
	public Challenge createChallenge(Challenge challenge) {
		return challengeRepository.save(challenge);
	}

	@Override
	public Challenge updateChallenge(Challenge challenge) {
		Optional<Challenge> utOptional = challengeRepository.findById(challenge.getId());
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return challengeRepository.save(challenge);
		}
	}

	@Override
	public void deleteChallenge(Long id) {
		challengeRepository.deleteById(id);
		
	}

	@Override
	public List<Challenge> findByIdAssoc(Long idAssoc) {
		return challengeRepository.findByIdAssoc(idAssoc);
	}
	
	

}

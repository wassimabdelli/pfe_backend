package app.holistcwenter.pfe.services;
import java.util.List;

import app.holistcwenter.pfe.entities.Challenge;
public interface ChallengeService {
	// Methode basique
	public List<Challenge> getAllChallenges();
	public Challenge findById(Long id);
	public Challenge createChallenge(Challenge challenge);
	public Challenge updateChallenge(Challenge challenge);
	public void deleteChallenge(Long id);
	// Methode avacée
	public List<Challenge> findByIdAssoc(Long idAssoc);
}

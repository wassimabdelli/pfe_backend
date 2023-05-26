package app.holistcwenter.pfe.services;
import java.util.List;

import app.holistcwenter.pfe.entities.Followers;
public interface FollowersService {

	//Methode basique
	public List<Followers> getAllFollowers();
	public Followers createFollow (Followers followers);
	public void deleteFollow(Long id);
	//methode avancees
	List<Followers> findByIdAssoc(Long idAssoc);
}

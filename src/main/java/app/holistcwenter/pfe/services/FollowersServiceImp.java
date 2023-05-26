package app.holistcwenter.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Followers;
import app.holistcwenter.pfe.repositories.FollowersRepository;
@Service
public class FollowersServiceImp implements FollowersService {

	@Autowired
	private FollowersRepository followersRepository;
	
	@Override
	public List<Followers> getAllFollowers() {
		return followersRepository.findAll();
	}

	@Override
	public Followers createFollow(Followers followers) {
		return followersRepository.save(followers);
	}

	@Override
	public void deleteFollow(Long id) {
		followersRepository.deleteById(id);
		
	}

	@Override
	public List<Followers> findByIdAssoc(Long idAssoc) {
		return followersRepository.findByIdAssoc(idAssoc);
	}

}

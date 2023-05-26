package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Followers;

public interface FollowersRepository extends JpaRepository<Followers,Long> {
	
	List<Followers> findByIdAssoc(Long idAssoc);

}

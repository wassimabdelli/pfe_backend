package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.holistcwenter.pfe.entities.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

	List<Challenge> findByIdAssoc(Long idAssoc);

}

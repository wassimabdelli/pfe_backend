package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

	List<Reaction> findByIdPub(Long idPub);
    Reaction findByIdUserAndIdPub(Long idUser, Long isPub);
	
}

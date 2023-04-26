package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Utilisateur;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

	List<Publication> findByIdUser(Long idUser);

}

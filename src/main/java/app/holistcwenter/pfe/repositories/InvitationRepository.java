package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import app.holistcwenter.pfe.entities.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
	List<Invitation> findByDestinataire(Long destinataire);
}

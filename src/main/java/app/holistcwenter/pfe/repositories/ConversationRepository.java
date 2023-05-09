package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
	List<Conversation> findByEmetteurAndDestinataire(Long emutteur, Long destinataire);
	List<Conversation> findByDestinataireAndEmetteur(Long destinataire, Long emutteur);
	

}

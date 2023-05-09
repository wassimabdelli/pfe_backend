package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Conversation;

public interface ConversationService {
	// Methode basique
			public List<Conversation>getAllMsg(); 
			public Conversation createMsg(Conversation conversation);  
			public void deleteConversation(Long id); 
	//Methode Avancée
			public List<Conversation> findByEmetteurAndDestinataire(Long emutteur, Long destinataire);
			public List<Conversation> findByDestinataireAndEmetteur(Long destinataire, Long emutteur);

}

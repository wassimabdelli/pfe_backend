package app.holistcwenter.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Conversation;
import app.holistcwenter.pfe.repositories.ConversationRepository;

@Service
public class ConversationServiceImp implements ConversationService  {
	
	@Autowired
	public ConversationRepository conversationRepository;

	@Override
	public List<Conversation> getAllMsg() {
		return conversationRepository.findAll();
	}

	@Override
	public Conversation createMsg(Conversation conversation) {
		return conversationRepository.save(conversation);
	}

	@Override
	public void deleteConversation(Long id) {
		conversationRepository.deleteById(id);
		
	}

	@Override
	public List<Conversation> findByEmetteurAndDestinataire(Long emutteur, Long destinataire) {
		return conversationRepository.findByEmetteurAndDestinataire(emutteur, destinataire);
	}

	@Override
	public List<Conversation> findByDestinataireAndEmetteur(Long destinataire, Long emutteur) {
		return conversationRepository.findByDestinataireAndEmetteur(destinataire, emutteur);
	}

}

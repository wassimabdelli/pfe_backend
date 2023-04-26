package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Amis;
import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Invitation;

public interface InvitationService {
			// Methode basique
			public List<Invitation>getAllInvits(); 
			public Invitation createInvi(Invitation invitation); 
			public void deleteInvi(Long id); 
			//Methode avancées
			List<Invitation> findByDestinataire(Long destinataire);
}	

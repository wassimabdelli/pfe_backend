package app.holistcwenter.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.holistcwenter.pfe.entities.Invitation;
import app.holistcwenter.pfe.repositories.CommentRepository;
import app.holistcwenter.pfe.repositories.InvitationRepository;
@Service
public class InvitationServiceImp implements InvitationService {
	

	@Autowired
	private InvitationRepository invitationRepository;


	@Override
	public List<Invitation> getAllInvits() {
		return invitationRepository.findAll();
	}

	@Override
	public Invitation createInvi(Invitation invitation) {
		return invitationRepository.save(invitation);
	}

	@Override
	public void deleteInvi(Long id) {
		invitationRepository.deleteById(id);
		
	}

	@Override
	public List<Invitation> findByDestinataire(Long destinataire) {
		return invitationRepository.findByDestinataire(destinataire);
	}

}

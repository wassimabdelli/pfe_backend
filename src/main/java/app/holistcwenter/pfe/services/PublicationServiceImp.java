package app.holistcwenter.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Publication;
import app.holistcwenter.pfe.entities.Utilisateur;
import app.holistcwenter.pfe.repositories.PublicationRepository;
import app.holistcwenter.pfe.repositories.UtilisateurRepository;

@Service
public class PublicationServiceImp implements PublicationService {
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public List<Publication> getAllPubs() {
		return publicationRepository.findAll();
	}

	@Override
	public Publication createPublication(Publication publicaton) {
		
		return publicationRepository.save(publicaton);
	}

	@Override
	public Publication updatePublication(Publication publication) {
		Optional<Publication> utOptional = publicationRepository.findById(publication.getId());
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return publicationRepository.save(publication);
		}
	}

	@Override
	public void deletePublication(Long id) {
		publicationRepository.deleteById(id); 		
	}

	@Override
	public Publication findPubsById(Long id) {
		Optional<Publication> utOptional = publicationRepository.findById(id);
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return utOptional.get();
		}
		
	}

	@Override
	public List<Publication> findByIdUser(Long IdUser) {

			
			return publicationRepository.findByIdUser(IdUser);
		}

	@Override
	public List<Publication> findByIdUserAndType(Long idUser, String type) {
		return publicationRepository.findByIdUserAndType(idUser, type);
	}
	

	



}

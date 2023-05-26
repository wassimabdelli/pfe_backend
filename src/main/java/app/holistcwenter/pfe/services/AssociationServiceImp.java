package app.holistcwenter.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Association;
import app.holistcwenter.pfe.entities.Utilisateur;
import app.holistcwenter.pfe.repositories.AssociationRepository;
import app.holistcwenter.pfe.repositories.UtilisateurRepository;

@Service
public class AssociationServiceImp implements AssociationService {
	@Autowired
	private AssociationRepository associationRepository;
	@Override
	public List<Association> getAllAssociations() {
		return associationRepository.findAll();
	}

	@Override
	public Association findAssociationById(Long id) {
		Optional<Association> utOptional = associationRepository.findById(id);
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return utOptional.get();
		}
	}

	@Override
	public Association createAssociation(Association association) {
		return associationRepository.save(association);
	}

	@Override
	public Association UpdateAssociation(Association association) {
		Optional<Association> utOptional = associationRepository.findById(association.getId());
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return associationRepository.save(association);
		}
	}

	@Override
	public void deleteAssociation(Long id) {
		associationRepository.deleteById(id);
		
	}

	@Override
	public List<Association> findByName(String Name) {
		return associationRepository.findByName(Name);
	}

	@Override
	public Association findByEmail(String email) {
		return associationRepository.findByEmail(email);
	}

}

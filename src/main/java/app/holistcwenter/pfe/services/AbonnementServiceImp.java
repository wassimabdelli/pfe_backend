package app.holistcwenter.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Abonnement;
import app.holistcwenter.pfe.repositories.AbonnementRepository;
@Service
public class AbonnementServiceImp implements AbonnementService {
	
	@Autowired
	private AbonnementRepository abonnementRepository;

	@Override
	public List<Abonnement> getAllAbonnement() {
		return abonnementRepository.findAll();
	}

	@Override
	public Abonnement createAbonnement(Abonnement  abonnement) {
	return abonnementRepository.save(abonnement);
	}

	@Override
	public void deleteAbonnement(Long id) {
		abonnementRepository.deleteById(id);
		
	}

	@Override
	public List<Abonnement> findByIdUser(Long idUser) {
		return abonnementRepository.findByIdUser(idUser);
	}

}

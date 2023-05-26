package app.holistcwenter.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Amis;
import app.holistcwenter.pfe.entities.Invitation;
import app.holistcwenter.pfe.repositories.AmisRepository;
@Service
public class AmisServicesImp implements AmisService {
	
	@Autowired
	private AmisRepository amisRepository;

	@Override
	public List<Amis> getAllAmis() {
		return amisRepository.findAll();
	}

	@Override
	public Amis createAmis(Amis amis) {
		return amisRepository.save(amis);
	}

	@Override
	public void deleteAmis(Long idAmi) {
		amisRepository.deleteById(idAmi);
		
	}

	@Override
	public List<Amis> findByIdCompte(Long idCompte) {
		return amisRepository.findByIdCompte(idCompte);
	}

	@Override
	public List<Amis> findByIdCompteAndIdAmi(Long idCompte, Long idAmi) {
		return amisRepository.findByIdCompteAndIdAmi(idCompte, idAmi);
	}

	@Override
	public List<Amis> findByIdAmiAndIdCompte(Long idAmi, Long idCompte) {
		return amisRepository.findByIdAmiAndIdCompte(idAmi, idCompte);
	}

}

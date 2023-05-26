package app.holistcwenter.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.holistcwenter.pfe.entities.Rep_Ch;
import app.holistcwenter.pfe.repositories.RepChRepository;

@Service
public class RepChServiceImp implements RepChService {
	
	@Autowired
	private RepChRepository repChRepository;

	@Override
	public List<Rep_Ch> getAllRepCh() {
		return repChRepository.findAll();
	}

	@Override
	public Rep_Ch createRepCh(Rep_Ch rep_Ch) {
		return repChRepository.save(rep_Ch);
	}

	@Override
	public Rep_Ch updateRepCh(Rep_Ch rep_Ch) {
		Optional<Rep_Ch> utOptional = repChRepository.findById(rep_Ch.getId());
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return repChRepository.save(rep_Ch);
		}
	}

	@Override
	public void deleteRepCh(Long id) {
		repChRepository.deleteById(id);
		
	}

	@Override
	public List<Rep_Ch> findByIdCh(Long idCh) {
		return repChRepository.findByIdCh(idCh);
	}

	@Override
	public List<Rep_Ch> findByIdUserAndIdCh(Long idUser, Long idCh) {
		return repChRepository.findByIdUserAndIdCh(idUser, idCh);
	}

}

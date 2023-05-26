package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Rep_Ch;

public interface RepChService {
	// Methode basique
	public List<Rep_Ch> getAllRepCh();
	public Rep_Ch createRepCh (Rep_Ch rep_Ch);
	public Rep_Ch updateRepCh (Rep_Ch rep_Ch);
	public void deleteRepCh(Long id);
	//Methode avacée  
	List<Rep_Ch> findByIdCh(Long idCh);
	List<Rep_Ch> findByIdUserAndIdCh(Long idUser , Long idCh);
}

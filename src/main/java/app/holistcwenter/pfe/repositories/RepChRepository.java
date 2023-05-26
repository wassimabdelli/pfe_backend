package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Rep_Ch;

public interface RepChRepository extends JpaRepository<Rep_Ch, Long> {
	
	List<Rep_Ch> findByIdCh(Long idCh);
	List<Rep_Ch> findByIdUserAndIdCh(Long idUser , Long idCh);

}

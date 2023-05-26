package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Amis;
import app.holistcwenter.pfe.entities.Reaction;

public interface AmisRepository extends JpaRepository<Amis, Long> {
	
	Amis findByIdAmi(Long idAmi);
	List<Amis> findByIdCompte(Long idCompte);
	List<Amis> findByIdCompteAndIdAmi(Long idCompte , Long idAmi);
	List<Amis> findByIdAmiAndIdCompte(Long idAmi , Long idCompte);

}

package app.holistcwenter.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Reaction;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByIdPub(Long idPub);
	List<Comment> findByIdUserAndIdPub(Long idUser, Long isPub);
	
}

package app.holistcwenter.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.repositories.CommentRepository;

@Service
public class CommentServiceImp implements CommentService  {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	
	@Override
	public Comment createComment(Comment comment) {
	return commentRepository.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		Optional<Comment> utOptional = commentRepository.findById(comment.getId());
		if(utOptional.isEmpty())
		{
			return null;
		}else {
			return commentRepository.save(comment);
		}
	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
		
	}


	@Override
	public List<Comment> findByIdUserIdPub(Long idUser, Long idPub) {
		return commentRepository.findByIdUserAndIdPub(idUser,idPub);
	}


	@Override
	public List<Comment> findByIdPub(Long idPub) {
		return commentRepository.findByIdPub(idPub);
	}

	

}

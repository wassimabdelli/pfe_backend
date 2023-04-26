package app.holistcwenter.pfe.services;

import java.util.List;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Reaction;



public interface CommentService {
	// Methode basique
		public List<Comment>getAllComments(); 
		public Comment createComment(Comment comment); 
		public Comment updateComment(Comment comment);  
		public void deleteComment(Long id); 
		//Methode avacée 
		 List<Comment> findByIdUserIdPub(Long idUser, Long isPub);
		 List<Comment> findByIdPub(Long idPub);
}

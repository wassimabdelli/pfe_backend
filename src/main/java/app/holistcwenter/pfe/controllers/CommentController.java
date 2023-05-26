package app.holistcwenter.pfe.controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Reaction;
import app.holistcwenter.pfe.services.CommentService;
import app.holistcwenter.pfe.services.ReactionService;

@RestController
@RequestMapping("/comment") //localhost:8080/comment
public class CommentController {
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping	
	public List<Comment> getAllComments() {
		return commentService.getAllComments();	
	}
	@PostMapping
	public Comment createComment(@RequestBody Comment comment) 
	{

		return commentService.createComment(comment);
	}
	
	@PutMapping
	public Comment updateComment(@RequestBody Comment comment) {
			
			return commentService.updateComment(comment);
		}
	@DeleteMapping(path = "/{id}") //localhost:8080/comment/3  
	public void deleteComment(@PathVariable Long id) {
		 commentService.deleteComment(id);
	}
	@GetMapping(path = "/{idUser}/{idPub}")
	public List<Comment> findCommentsByidUserETidPub(@PathVariable Long idUser, @PathVariable Long idPub) {
	    List<Comment> comments = commentService.findByIdUserIdPub(idUser, idPub);
	    comments.sort(Comparator.comparing(Comment::getDate).reversed());
	    return comments;
	}
	@GetMapping(path = "/{idPub}")
	public List<Comment> findReactionsByidPub(@PathVariable Long idPub) {
	    List<Comment> comments = commentService.findByIdPub(idPub);
	    comments.sort(Comparator.comparing(Comment::getDate).reversed());// sans reserved => croissante 
	    return comments;
	}
	
	@GetMapping(path = "/nbComments/{idPub}")
	public int getCommentsCountByIdPub(@PathVariable Long idPub) {
	    List<Comment> comments = commentService.findByIdPub(idPub);
	    int commentsCount = comments.size();
	    return commentsCount;
	}



}

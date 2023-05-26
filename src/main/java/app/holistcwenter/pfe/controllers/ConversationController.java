package app.holistcwenter.pfe.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.holistcwenter.pfe.entities.Comment;
import app.holistcwenter.pfe.entities.Conversation;
import app.holistcwenter.pfe.services.CommentService;
import app.holistcwenter.pfe.services.ConversationService;

@RestController
@RequestMapping("/Conversation")
public class ConversationController {
	private ConversationService conversationService;
	
	@Autowired
	public ConversationController(ConversationService conversationService) {
		this.conversationService = conversationService;
	}
	
	@GetMapping	
	public List<Conversation> getAllMsg() {
		return conversationService.getAllMsg();	
	}
	
	@PostMapping
	public Conversation createConversation(@RequestBody Conversation conversation) 
	{

		return conversationService.createMsg(conversation);
	}
	
	@DeleteMapping(path = "/{id}")  
	public void deleteMsg(@PathVariable Long id) {
		conversationService.deleteConversation(id);
	}
		@GetMapping(path = "/{emutteur}/{destinataire}")
		public List<Conversation> findMsgByEmutteurETdestinataire(@PathVariable Long emutteur, @PathVariable Long destinataire) {
		    List<Conversation> MSGEmuttuer = conversationService.findByEmetteurAndDestinataire(emutteur, destinataire);
		    List<Conversation> MSGsDestinataire  = conversationService.findByDestinataireAndEmetteur(emutteur, destinataire);
		    List<Conversation> Msg = new ArrayList<>();
		    Msg.addAll(MSGsDestinataire);
		    Msg.addAll(MSGEmuttuer);
		    Msg.sort(Comparator.comparing(Conversation::getId));
		    return Msg;
		}
}

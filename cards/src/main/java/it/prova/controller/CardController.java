package it.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.prova.model.Card;
import it.prova.service.CardService;
@CrossOrigin
@RestController
public class CardController {
	
	@Autowired
	private CardService service;
	
	@GetMapping ("/api/cards")
	public Iterable <Card> getAllCards () {
		return service.getAllCards();
	}
	
	@GetMapping ("/api/cards/{id}")
	public Card getById(@PathVariable Integer id) {
		Card card = service.getCardById(id);
		if (card == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card non trovata");
		} return card;
		
		
	}
	
	@PostMapping ("/admin/api/save")
	public Card save (@RequestBody Card card) {
		service.addCard(card);
		return card;
		
	}
	
	@PutMapping("/admin/api/update/ {id}")
	public Card update(@PathVariable Integer id, @RequestBody Card card) {
		Card ca = service.updateCard(id, card);
		if (card == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card non trovata");
			
		}
		return ca;
		
	}
	
	@DeleteMapping("/admin/api/delete/{id}")
	public Card delete(@PathVariable Integer id) {
		Card card = service.getCardById(id);
		if (card == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card non trovata");
		}else {
			service.deleteCardById (id);
			return card;
		}
	}
	

}

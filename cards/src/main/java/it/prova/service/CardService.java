package it.prova.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.model.Card;
import it.prova.repository.CardRepository;

@Service
public class CardService implements iCardService{

	@Autowired
	private CardRepository repository;
	
	
	@Override
	public Iterable<Card> getAllCards() {
		
		return repository.findAll();
	}

	@Override
	public Card getCardById(Integer id) {
		Optional<Card> card = repository.findById(id);
		if (card.isEmpty()==false) {
			return card.get();
		}
		return null;
	}

	@Override
	public Card addCard(Card card) {
	
		return repository.save(card);
	}

	@Override
	public Card updateCard(Integer id, Card card) {
		Optional<Card> ca = repository.findById(id);
		if (ca.isEmpty()==false) {
			ca.get().setDescrizione(card.getDescrizione());
			repository.save(ca.get());
			
			return ca.get();
		}
		return null;
	}

	@Override
	public Card deleteCardById(Integer id) {
		Optional <Card> ca = repository.findById(id);
		if ( ca.isEmpty()==false) {
			repository.deleteById(id);
			return ca.get();
		}
		return null;
	}

	
}

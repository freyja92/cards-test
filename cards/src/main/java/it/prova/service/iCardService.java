package it.prova.service;

import it.prova.model.Card;

public interface iCardService {
	public Iterable<Card> getAllCards();
	public Card getCardById(Integer id);
	public Card addCard(Card card);
	public Card updateCard(Integer id, Card card);
	public Card deleteCardById (Integer id);

}

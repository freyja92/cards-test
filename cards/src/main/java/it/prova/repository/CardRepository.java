package it.prova.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.prova.model.Card;

@Repository
public interface CardRepository extends CrudRepository <Card, Integer> {

}

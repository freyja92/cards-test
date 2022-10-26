package it.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
private Integer id;
	
	@Column (name="img")
private String img;
	
	@Column (name="descrizione")
private String descrizione;
public Card() {
	
}
public Card(String img, String descrizione) {
	
	this.img = img;
	this.descrizione = descrizione;
}
public Card(Integer id, String img, String descrizione) {
	this.id = id;
	this.img = img;
	this.descrizione = descrizione;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
@Override
public String toString() {
	return "Card [id=" + id + ", img=" + img + ", descrizione=" + descrizione + "]";
}

}

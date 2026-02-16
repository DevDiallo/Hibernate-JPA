package Modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Poulet {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id_poulet ; 
	private Double poids ; 
	private Double prix ; 
	
	public Poulet() {}
	
	public Poulet(int id , Double poids , Double prix) {
		this.id_poulet = id ; 
		this.poids = poids ; 
		this.prix = prix ; 
	}
	
	// getters et setters 
	public Integer getId() {
		return this.id_poulet ; 
	}
	public Double getPoids() {
		return this.poids ; 
	}
	public Double getPrix() {
		return this.prix ; 
	}
	
	// affichage en toString()
	public String toString() {
		return "Id_poulet : " + getId() + "Poids : " + getPoids() + "Prix : " + getPrix() ; 
	}
}

package Modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity 
public class Commande extends Utilisateur {
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Integer N_commande ; 
	@ManyToMany
	@JoinTable(
	    name = "Commande_Poulet",
	    joinColumns = @javax.persistence.JoinColumn(name = "id_user"),  // PK de Commande / Utilisateur
	    inverseJoinColumns = @javax.persistence.JoinColumn(name = "id_poulet")  // PK de Poulet
	)
	private List<Poulet> pouletsValide;
 
	
	public Commande() {} ; 
	public Commande(String id_user , String nom , String prenom , List<Poulet> poulets) {
		// TODO Auto-generated constructor stub
		super(id_user , nom , prenom) ; 
		this.pouletsValide = poulets ; 
	}
	
	// getters et setters 
	public List<Poulet> getCommande() { return this.pouletsValide ; }

}

package Modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	@Id
	private String id_user ; 
	private String nom ; 
	private String prenom ; 
	public Utilisateur() {} ; 
	public Utilisateur(String id_user ,String nom , String prenom) {
		// TODO Auto-generated constructor stub
		this.id_user = id_user ; 
		this.nom = nom ; 
		this.prenom = prenom ; 
	}
	
	// getters et setters 
	public String getIdUser() {
		return this.id_user ; 
	}
	public String getNom() {
		return this.nom ; 
	}
	public String getPrenom() {
		return this.prenom ; 
	}

}

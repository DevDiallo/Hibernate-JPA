package DAO;

import java.util.ArrayList;
import java.util.List;

import Modele.Poulet;

public class PanierCRUD {
	private List<Poulet> poulets ; 
	public PanierCRUD(List<Poulet> poulets) {
		// TODO Auto-generated constructor stub
		this.poulets = poulets ; 
	}
	// Methode pour supprimer un element à partir de son index 
	public void removePoulet(int index) {
		this.poulets.remove(index) ; 
	}

}

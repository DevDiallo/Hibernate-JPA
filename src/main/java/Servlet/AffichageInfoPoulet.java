package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ConnectorDB;
import DAO.PanierCRUD;
import Modele.Poulet;

/**
 * Servlet implementation class AffichageInfoPoulet
 */
@WebServlet("/AffichageInfoPoulet")
public class AffichageInfoPoulet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageInfoPoulet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// afficher les info du poulet depuis la table de la BD 
		 
		Poulet poulet = null ;
		EntityManager em = ConnectorDB.getEntityManager() ; 
		 
		try {
			System.out.println("Connection à la BD etablie") ; 
			EntityTransaction transaction = em.getTransaction() ; 
			transaction.begin() ; 
			
			poulet = em.createQuery("from Poulet" , Poulet.class).getSingleResult() ;
			
			transaction.commit() ; 
			
		} finally {
			// TODO: handle finally clause
			em.close() ; 
		}
		// ajouter les elements dans le panier à chaque selection sur le bouton ajouter au panier 
		Integer NombreElements = (Integer) request.getSession().getAttribute("NbrElement");
		List<Poulet> poulets = (List<Poulet>) request.getSession().getAttribute("PouletsList") ; 
		if (NombreElements == null) {
		    NombreElements = 0;
		}
		if(poulets == null) { poulets = new ArrayList<>() ; }
		String btn_ajoutPanier = request.getParameter("Ajout-Panier");
		if (btn_ajoutPanier != null) {
			poulets.add(poulet) ; 
		    NombreElements += 1;
		    request.getSession().setAttribute("PouletsList",poulets) ;
		    request.getSession().setAttribute("NbrElement", NombreElements);
		    System.out.println("Liste de poulets : " + poulets) ; 
		}
		
		String btn_voirPanier = request.getParameter("voirPanier") ; 
		if(btn_voirPanier != null) {
			request.getSession().setAttribute("PouletsList",poulets) ; 
			request.getRequestDispatcher("/AffichagePanier.jsp").forward(request, response) ; 
			return ; 
		}

		
		System.out.println("Nombre de poulet : " + NombreElements) ; 
		request.setAttribute("InfoPoulet", poulet) ; 
		
		request.getRequestDispatcher("/Vue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String index = request.getParameter("selectedIndex") ; 
		String btn_supprimer = request.getParameter("btn-supprimer") ; 
		 
		if(index != null) {
			int ind = Integer.parseInt(index) ; 
			List<Poulet> poulets = (List<Poulet>) request.getSession().getAttribute("PouletsList") ; 
			Integer NombreElements = (Integer) request.getSession().getAttribute("NbrElement");
			if(poulets!=null && ind>=0 && ind<poulets.size() && btn_supprimer != null) {
				PanierCRUD paniercrud = new PanierCRUD(poulets) ; 
				paniercrud.removePoulet(ind) ; 
				NombreElements -= 1 ; 
				request.getSession().setAttribute("NbrElement", NombreElements) ; 
				request.getSession().setAttribute("PouletsList", poulets) ; 
			}
		}
		request.getRequestDispatcher("/AffichagePanier.jsp").forward(request, response);
	}

}

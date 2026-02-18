package Servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ConnectorDB;
import Modele.Commande;
import Modele.Poulet;

/**
 * Servlet implementation class persistenceCommande
 */
@WebServlet("/persistenceCommande")
public class persistenceCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public persistenceCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String message = null ; 
		EntityManager em = ConnectorDB.getEntityManager() ; 
		List<Poulet> poulets = (List<Poulet>) request.getSession().getAttribute("PouletsList") ; 
		try {
			System.out.println("2 eme connexion à la BD reussi") ; 
			System.out.println("La commande : " + poulets) ;
			EntityTransaction transaction = em.getTransaction() ; 
			transaction.begin() ; 
			Commande commande = new Commande("A10","DIALLO","Aliou",poulets) ; 
			em.persist(commande) ; 
			message = "Felicitaion votre commande est bien validé" ; 
			transaction.commit() ; 
		} finally {
			// TODO: handle finally clause 
			em.close() ; 
		}
		request.setAttribute("message", message) ; 
		request.getRequestDispatcher("/AffichagePanier.jsp").forward(request, response); 
		 
	}
}

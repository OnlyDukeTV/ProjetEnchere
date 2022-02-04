package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;

/**
 * Servlet implementation class Encheres
 */
@WebServlet("/AccueilNonConnecter")
public class AccueilNonConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = CategorieManager.getInstance();
		try {
			String [] categories = {"menu","sport","yuioyuy"};
			//List<Categorie> categories = cm.lister();
			//System.out.println("bonjour");
			request.setAttribute("categories",categories);
			request.getRequestDispatcher("/WEB-INF/AccueilNonConnecter.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("déconnecté");
			 request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
		}
		
		// request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
	}

}

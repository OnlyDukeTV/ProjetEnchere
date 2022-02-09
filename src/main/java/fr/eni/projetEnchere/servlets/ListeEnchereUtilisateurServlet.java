package fr.eni.projetEnchere.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.projetEnchere.bll.ArticleVenduManager;

import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.ArticleVendu;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;

/**
 * Servlet implementation class ListeEnchereUtilisateurServlet
 */
@WebServlet("/ListeEnchereUtilisateur")
public class ListeEnchereUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeEnchereUtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// Manager pour aller chercher l'article 
		try {
			
			// Récupération des paramètres
			Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
			int id = utilisateurCo.getNoUtilisateur();
		
			
			
			ArticleVendu article = ArticleVenduManager.getInstance().rechercherParId(id);
			request.setAttribute("utilisateur", utilisateurCo);
			request.setAttribute("article", article);
			request.getRequestDispatcher("/accesConnecte/ListeEnchereUtilisateur.jsp").forward(request, response);
			return;
			
		} catch (DalException | BllException | NumberFormatException e) {
			e.printStackTrace();
			response.sendRedirect("/ProjetEnchere/AccueilConnecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
		int id = utilisateurCo.getNoUtilisateur();
		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			utilisateurCo = um.SelectUser(id);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}

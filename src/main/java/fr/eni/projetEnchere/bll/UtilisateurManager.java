package fr.eni.projetEnchere.bll;

import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DAOFactory;
import fr.eni.projetEnchere.dal.UtilisateurDAO;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {

	}
    //Singleton, methode assurant la création d'une seule instance de l'objet
	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public void addUser(Utilisateur user) throws BllException {
		UtilisateurDAO ud = DAOFactory.getUtilisateurDAO();

		try {
     //verifier l'objet utilisateur
			if (verifierUser(user)) {
				// ajouter l'article à la base de donnée
				ud.insert(user);
			} else {
				 throw new BllException("Probleme sur la methode de verification");
			}

		} catch (Exception e) {
			
			//recuperation du message d'erreur de la methode de verification
			 throw new BllException(e.getMessage());
		}
	}

	public Utilisateur afficherProfil(String pseudo) {
		UtilisateurDAO userDao = DAOFactory.getUtilisateurDAO();

		Utilisateur user = null;
		try {
			user = userDao.selectByPseudo(pseudo);
		} catch (DalException e) {
			
			e.printStackTrace();
		}

		return user;
	}

	public void modifierUser(Utilisateur user,String pseudo) throws DalException, BllException {
		UtilisateurDAO userDao = DAOFactory.getUtilisateurDAO();

		verifierUser(user);
		userDao.update(user,pseudo);

	}
/*
 * Methode permettant s'assurer que les parametres rentrés par l'utilisateur sont conformes au cahier des charges
 */
	public static Boolean verifierUser(Utilisateur u) throws BllException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		if (u == null) {
			throw new BllException("Utilisateur null");
		}

		if (u.getPseudo() == null || u.getPseudo().isBlank()) {
			sb.append("Le pseudo est obligatoire.\n");
			valide = false;
		}
		if (u.getNom() == null || u.getNom().isBlank()) {
			sb.append("Le nom est obligatoire.\n");
			valide = false;
		}

		if (u.getVille() == null || u.getVille().isBlank()) {
			sb.append("La ville est obligatoire.\n");
			valide = false;
		}
		if (u.getRue() == null || u.getRue().trim().isBlank()) {
			sb.append("La rue est obligatoire.\n");
			valide = false;
		}
		if (u.getCodePostal() == null || u.getCodePostal().isBlank()) {
			sb.append("Le code postal est obligatoire.\n");
			valide = false;
		}
		try {
            Float f = Float.parseFloat(u.getCodePostal());
        } catch (NumberFormatException e) {
            valide  = false;
            sb.append("Le code Postal ne doit comporter que des chiffres\n");
        }

		if (u.getPrenom() == null || u.getPrenom().isBlank()) {
			sb.append("Le prenom est obligatoire.\n");
			valide = false;
		}
		if (u.getEmail() == null || u.getEmail().isBlank()) {
			sb.append("La rue est obligatoire.\n");
			valide = false;
		}
		if (u.getMotDePasse() == null || u.getMotDePasse().isBlank()) {
			sb.append("Le mot de passe est obligatoire.\n");
			valide = false;
		}
		if(u.getTelephone().isBlank()) {
			valide = true;
		}
		else if(u.getTelephone() != null) { 
			if(u.getTelephone().trim().length() != 10) {
			sb.append("Le numero de telephone doit comporter 10 chiffres\n");
        	valide  = false;
			}  if(u.getTelephone() != null) {
				try {
		            Float f = Float.parseFloat(u.getTelephone());
		        } catch (NumberFormatException e) {
		        	sb.append("Le numero de telephone ne doit comporter que des chiffres\n");
		        	valide  = false;
		            
		       }    	
		}
		
		}

		if (!valide) {
			throw new BllException(sb.toString());
		}

		return true;
	}

	public void delete(Utilisateur user) throws DalException {
		UtilisateurDAO userDao = DAOFactory.getUtilisateurDAO();

		try {
			userDao.delete(user);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Utilisateur login(Utilisateur user) throws DalException {

		UtilisateurDAO ud = DAOFactory.getUtilisateurDAO();

		return ud.selectByLogin(user);
	}
	
	
	public Utilisateur SelectUser(int id) throws DalException {
		UtilisateurDAO userDao = DAOFactory.getUtilisateurDAO();
		
		Utilisateur user = new Utilisateur();
		
		user = userDao.selectById(id);
		
		return user;
	}

}
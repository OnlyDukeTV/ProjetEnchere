package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;
import fr.eni.projetEnchere.helpers.DBConnectPool;

public class CategorieDAOImpl implements CategorieDAO {

	private final static String LISTER = "SELECT * FROM CATEGORIES;";
	private final static String INSERER = "INSERT INTO CATEGORIES (libelle) values (?);";
	
	// private final static String MODIFIER = "update CATEGORIES set libelle = ?";
	
	private final static String SELECTBYID = "select no_categorie, libelle from CATEGORIES where no_categorie = ?;";
	private static final String DELETE = "delete from categories where no_categorie = ?";

	
	
	
	// Permet de LISTER toutes les catégories
	
	public List<Categorie> lister() throws DalException {
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Categorie> listeCategorie = new ArrayList<>();
		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);
			Categorie categorie;
			while (rs.next()) {
				categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				listeCategorie.add(categorie);

			}
			return listeCategorie;
		} catch (SQLException e) {
			throw new DalException("Problème - listeCategorie-" + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}

			} catch (SQLException e) {
				throw new DalException("Probleme - FermerConnexion" + e.getMessage());
			}
		}

	}

	//Permet de SELECT une catégorie par le libelle
	
	public Categorie selectParId(int noCategorie) throws DalException {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Categorie categorie = null;
		
		try {
			cnx = ConnectionProvider.getConnection(); 
			pstmt = cnx.prepareStatement(SELECTBYID);
			pstmt.setInt(1, noCategorie);
			System.out.println(noCategorie);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				
			}	
			} catch (SQLException e) {
				throw new DalException("Problème - listeCategorie-" + e.getMessage());
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (cnx != null) {
						cnx.close();
					}

				} catch (SQLException e) {
					throw new DalException("Probleme - FermerConnexion" + e.getMessage());
				}
			}
		return categorie;
	}



	

//	@Override
//	public void delete(int no_categorie) throws DalException {
//		
//		try (Connection cnx = ConnectionProvider.getConnection()) {
//			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
//		    pstmt.setInt(1, no_categorie);
//		    pstmt.executeUpdate();
//		    try {
//		        if (pstmt != null){
//		            pstmt.close();
//		        }
//		        if(cnx!=null){
//		            cnx.close();
//		        }
//		    } catch (SQLException e) {
//		        throw new DalException();
//		    }
//		} catch (SQLException e) {
//		    throw new DalException();
//		} 
//	}
}

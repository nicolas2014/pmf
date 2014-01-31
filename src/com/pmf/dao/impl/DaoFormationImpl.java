package com.pmf.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pmf.dao.DaoFormation;
import com.pmf.modele.Formation;

/**
 * @author crp
 * 
 *         Classe d'accès aux données des formations
 */
public class DaoFormationImpl implements DaoFormation {

	public void addFormation(Formation pFormation) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("erreur pendant le chargement du pilote");
		}
		Connection cnx = null;
		try {
			cnx = DriverManager.getConnection("jdbc:mysql://localhost/pmf?"
					+ "user=root&password=niko");
		} catch (SQLException e) {

			System.out.println("erreur pendant la connexion");
		}

		String query = "INSERT INTO formation (nomFormation, lieu, description, dateDebut, dateFin, nbHeure, preRequis) values (?,?,?,?,?,?,?)";

		PreparedStatement ps = null;
		try {
			ps = cnx.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setString(1, pFormation.getNomFormation());
			ps.setString(2, pFormation.getLieu());
			ps.setString(3, pFormation.getDescription());
			ps.setString(4, null);
			ps.setString(5, null);
			ps.setInt(6, pFormation.getNbHeure());
			ps.setString(7, pFormation.getPreRequis());
			ps.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}
	   public void printFormation(Formation f) {
	        String requete = "select * from formation where nomFormation = ?";
	        PreparedStatement ps;
	        ResultSet rs;
	        String donneeString;
	        try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("erreur pendant le chargement du pilote");
			}
			Connection cnx = null;
			try {
				cnx = DriverManager.getConnection("jdbc:mysql://localhost/pmf?"
						+ "user=root&password=niko");
			} catch (SQLException e) {

				System.out.println("erreur pendant la connexion");
			}
			
	        try {
	            ps = cnx.prepareStatement(requete, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	           
	            donneeString = f.getNomFormation();
	            ps.setString(1, donneeString);
	           
	            rs = ps.executeQuery();
	            rs = ps.getResultSet();
	            System.out.println("------------------------------");
	            while(rs.next()){
	                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
	                    System.out.println(rs.getMetaData().getColumnName(i) +" : "+ rs.getString(i));
	                    System.out.println("------------------------------");    }
	            }
	            System.out.println("------------------------------");
	      
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	   }
	   public void deleteFormation(){
	   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("erreur pendant le chargement du pilote");
		}
		Connection cnx = null;
		try {
			cnx = DriverManager.getConnection("jdbc:mysql://localhost/pmf?"
					+ "user=root&password=niko");
		} catch (SQLException e1) {

			System.out.println("erreur pendant la connexion");
		}

		String query = "DELETE FROM `pmf`.`formation` WHERE `idformation`>'26'";
		PreparedStatement ps = null;
		try {
			ps = cnx.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}
	   
}

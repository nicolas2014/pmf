package com.pmf.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.pmf.dao.impl.DaoFormationImpl;
import com.pmf.modele.Formation;
import com.pmf.modele.Stagiaire;
import com.pmf.service.ServiceFormation;
import com.pmf.service.exception.ListePleineException;
import com.pmf.service.exception.TableauFormationsVide;

public class ServiceFormationImpl implements ServiceFormation {
	static List<Formation> tabFormations = new ArrayList<Formation>();
	static int nbFormations = 0;
	static List<Integer> listeNotes = new ArrayList<Integer>();
	static DaoFormationImpl daof= new DaoFormationImpl();
	
	/**
	 * retourne une formation sous forme de chaine
	 * @param f la formation
	 */
	public String toString(Formation f) {
		return f==null?"formation inexistante":f.toString();
	}

	/**
	 * Ajoute la formation au tableau des formations
	 * 
	 * @param pFormation
	 *            la formation � ajouter
	 */
	public void ajouterFormation(Formation pFormation)
			throws ListePleineException {

		
		daof.addFormation(pFormation);
		
/*		if (nbFormations >= 10) {
			throw new ListePleineException("La liste est pleine!");
		}
		// System.out.println("Liste pleine !");
		else {
			tabFormations.add(pFormation);
			System.out.println("La formation a bien �t� ajout�e !");
			nbFormations++;
		}
*/	
	}

	/**
	 * Affiche une formation
	 * 
	 * @param f
	 *            la formation � afficher
	 */
	public void afficherFormation(Formation f) {
		//System.out.println(f);
		daof.printFormation(f);
	}

	public void suppFormation(){
		daof.deleteFormation();
	}
	public void afficherListeFormation(List<Formation> l) {

		Iterator<Formation> iterator = l.iterator();
		while (iterator.hasNext()) {
			System.out.println("Formation: " + iterator.next());
		}
	}

	public static List<Formation> getTabFormations() {
		return tabFormations;
	}

	/**
	 * R�cup�re les formations correspondantes au mot cl�
	 * 
	 * @param motCle
	 *            le mot cl� � rechercher
	 * @return la ou les formations trouv�es
	 * @throws TableauFormationsVide
	 */
	public List<Formation> rechercherFormation(String motCle)
			throws TableauFormationsVide {

		// TODO TableauFormationsVide si le tableau des formations est vide
		if (tabFormations.isEmpty())
			throw new TableauFormationsVide("Tableau des formations vide !!");
		motCle = motCle.toLowerCase();
		Formation f;
		List<Formation> resultRecherche = new ArrayList<Formation>();
		// parcours le tableau des formations
		for (int i = 0; i < ServiceFormationImpl.nbFormations; i++) {
			f = ServiceFormationImpl.tabFormations.get(i);
			// si la formation existe, v�rifie si elle contient le motCle et la
			// m�morise dans les r�sultats de recherche
			if (f != null) {
				if (f.getNomFormation().toLowerCase().contains(motCle)
						|| f.getDescription().toLowerCase().contains(motCle)) {
					resultRecherche.add(f);
				}
			}
		}
		return resultRecherche;
	}

	/**
	 * ajoute un stagiaire (pour l'inscire) dans une liste de stagiaire associ�e
	 * � une foramtion donn�e (� laquelle le stagiaire souhaite s'inscrire)
	 * 
	 * @param formation
	 * @param stagiaire
	 * @return
	 */
	public List<Stagiaire> inscrireStagiaire(Formation formation,
			Stagiaire stagiaire) {
		// TODO FormationDemarreeException si datedebut d�pass�e

		formation.getListeStagiaires().add(stagiaire);
		System.out.println("Le stagiaire " + stagiaire.getIdentifiant()
				+ " a �t� ajout� avec succ�s � la formation "
				+ formation.getNomFormation() + "!");
		return formation.getListeStagiaires();
	}

	/**
	 * demande la saisie d'une note pour noter une formation
	 * 
	 * @param formation
	 */
	@Override
	public void evaluerFormation(Formation formation, int note) {
		// TODO d�placer la saisie dans le main
		BufferedReader br;
		int note1 = 0;
		// TODO boucler tant que la note n'est pas valide
		System.out.println("Veuillez noter la formation, s'il vous plait :");
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			note1 = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO lier la note � un stagiaire
		ServiceFormationImpl.listeNotes.add(note1);
	}

	public List<Formation> rechercheFormationsInscription() {
		BufferedReader br;
		String motCleSaisi = "";
		boolean conditionArret = false;
		List<Formation> formationRecherchee = new ArrayList<Formation>();
		// TODO d�placer dans le main la saisie

		// boucle qui affiche les formations recherchees
		while (!conditionArret) {
			// saisie du mot cl�
			System.out.println("Veuillez saisir un mot-cl�, s'il vous plait :");
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				motCleSaisi = br.readLine();
				// motCleSaisi = motCleSaisi.toLowerCase();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (!motCleSaisi.equals("EXIT")) {
				// recherche des formation en fonction du mot cl� et affichage
				ServiceFormation sf1 = new ServiceFormationImpl();
				try {
					formationRecherchee = sf1.rechercherFormation(motCleSaisi);
				} catch (TableauFormationsVide e) {
					System.err.println(e.getMessage());
				}
				for (int i = 0; i < formationRecherchee.size(); i++) {
					sf1.afficherFormation(formationRecherchee.get(i));
				}
			} else {
				// on sort
				conditionArret = true;
				System.out.println("La recherche est termin�e!\n-------------\n");
			}
		}
		return formationRecherchee;
	}

	@Override
	public void evaluerFormation(Formation formation) {
		// TODO Auto-generated method stub

	}

	public Collection<Formation> listeFormations() {
		return this.listeFormations();

	}

}

package com.pmf.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.pmf.modele.Formation;
import com.pmf.modele.Stagiaire;
import com.pmf.service.ServiceStagiaire;
import com.pmf.service.exception.FormationNonExistantException;

public class ServiceStagiaireImpl implements ServiceStagiaire {
	public static List<Stagiaire> listeStagiaires = new ArrayList<Stagiaire>();
	static List<Integer> listeNotes = new ArrayList<Integer>();

	/**
	 * cr�e un nouveau stagiaire et l'ajoute � la liste des stagiaires
	 * 
	 * @param pAdresseEmail
	 * @param pTelephone
	 * @param pIdentifiant
	 * @param pMotDePasse
	 */
	public Stagiaire inscriptionPlateforme(String pAdresseEmail, String pTelephone,
			String pIdentifiant, String pMotDePasse) {
		// instanciation stagiaire
		Stagiaire stagiaire = new Stagiaire(pAdresseEmail, pTelephone,
				pIdentifiant, pMotDePasse);
		// ajout � la liste
		ServiceStagiaireImpl.listeStagiaires.add(stagiaire);
		System.out.println("F�licitation ! Le stagiare " + pIdentifiant + " est d�sormais inscrit � la plateforme.");
		return stagiaire;
	}

	/**
	 * recherche si un identifiant � d�j� �t� enregistr� dans la liste des
	 * stagiaires
	 * 
	 * @param pIdentifiant
	 * @deprecated
	 */
	public void rechercheStagiaire(String pIdentifiant) {
		for (int i = 0; i < ServiceStagiaireImpl.listeStagiaires.size(); i++) {
			if (ServiceStagiaireImpl.listeStagiaires.get(i).getIdentifiant()
					.contains(pIdentifiant)) {
				System.out.println("Cet identifiant a d�j� �t� cr��!");
			} else {
				System.out.println("Cet identifiant n'existe pas encore!");
			}
		}
	}

	BufferedReader br1;
	BufferedReader br2;
	String login;
	String mdp;

	/**
	 * demande la saisie du login et du mot de passe du stagiaire et v�rifie
	 * avec les donn�es enregistr�es � l'inscription
	 * 
	 * @param pStagiaire
	 * @return 
	 */
	public boolean connexion(String login,String mdp) {
		
		int i;
		Stagiaire s = null;
		// parcours le tableau des stagiaires
		for (i = 0; i < ServiceStagiaireImpl.listeStagiaires.size(); i++) {
			// si le stagiaire existe, v�rifie si l'identifiant et le mot de
			// passe correspondent
			if (ServiceStagiaireImpl.listeStagiaires.get(i).getIdentifiant()
					.equals(login)) {
				// TODO m�moriser le stagiaire trouv�
				s = ServiceStagiaireImpl.listeStagiaires.get(i);
				break;
			}

		}
		// TODO  StagiaireInexistantException si le stagiaire trouv� est
		// null
		
		if (s==null){
			System.out.println("Identifiant inconnu: Veuillez vous identifier!");
			return false;
		}
		else{
	
			if (ServiceStagiaireImpl.listeStagiaires.get(i).getMotDePasse().equals(mdp)) {
				return true;
			}
			else {System.out.println("Mot de passe erron�; Veuillez vous identifier!");
				return false;
			}
		}
	
	}
	
	/**
	 * demande la saisie du nom de la formation d�sir�, v�rifie sa pr�sence dans le tableau de formation recherch�e par mot-cl�
	 * et definit la formation d�sir�e comme formation choisie 
	 * @param pListeChoix
	 * @return
	 */
	@Override
	public Formation choisirFormation(List<Formation> pListeChoix) throws FormationNonExistantException {
		BufferedReader brd;
		String nomFormation = "";
		boolean conditionArret = false;
		Formation formationChoisie = null;
		// TODO d�placer dans le main la saisie

		// boucle
		while (!conditionArret) {
			// afficher un message pour saisir une formation souhaitee
			System.out.println("Entrez le nom de la formation d�sir�e : ");
			brd = new BufferedReader(new InputStreamReader(System.in));
			try {
				// recuperer la saisie console
				nomFormation = brd.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			nomFormation = nomFormation.toLowerCase();
			// recuperer la formation qui correspond � ce nom de formation
			for (int i = 0; i < pListeChoix.size(); i++) {
				Formation a = pListeChoix.get(i);
				if (nomFormation.toLowerCase().contains(
						a.getNomFormation().toLowerCase())) {
					formationChoisie = a;
					// on sort
					conditionArret = true;
				}
				// TODO else FormationNonExistantException
			}
			//if (formationChoisie == null) {
				//throw new FormationNonExistantException();
		//	}
		}
		// retourne la formation
		return formationChoisie;
	}
}

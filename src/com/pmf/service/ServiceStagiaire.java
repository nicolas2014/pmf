package com.pmf.service;

import java.util.List;

import com.pmf.modele.Formation;
import com.pmf.modele.Stagiaire;
import com.pmf.service.exception.FormationNonExistantException;
import com.pmf.service.exception.MotDePasseErronneException;
import com.pmf.service.exception.StagiaireInexistantException;

public interface ServiceStagiaire  {
	/**
	 * cr�e un nouveau stagiaire et l'ajoute � la liste des stagiaires
	 * @param pAdresseEmail
	 * @param pTelephone
	 * @param pIdentifiant
	 * @param pMotDePasse
	 * @return 
	 */
	public Stagiaire inscriptionPlateforme(String pAdresseEmail, String pTelephone, String pIdentifiant, String pMotDePasse);
	
	/**
	 * demande la saisie du login et du mot de passe du stagiaire et v�rifie avec les donn�es enregistr�es � l'inscription 
	 * @param pStagiaire
	 * @throws MotDePasseErronneException 
	 * @throws StagiaireInexistantException 
	 * @throws com.pmf.service.exception.StagiaireInexistantException 
	 */
	public boolean connexion(String login,String mdp);


	
	/**
	 *demande la saisie du nom de la formation d�sir�, v�rifie sa pr�sence dans le tableau de formation recherch�e par mot-cl�
	 * et definit la formation d�sir�e comme formation choisie  
	 * @param pListeChoix
	 * @return
	 * @throws FormationNonExistantException 
	 */
	public Formation choisirFormation(List<Formation> pListeChoix) throws FormationNonExistantException;
	
}

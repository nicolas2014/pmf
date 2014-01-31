package com.pmf.controlleur;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.pmf.modele.Formation;
import com.pmf.modele.Organisme;
import com.pmf.modele.Stagiaire;
import com.pmf.service.ServiceFormation;
import com.pmf.service.exception.ListePleineException;
import com.pmf.service.impl.ServiceFormationImpl;

public class PMF {

	static private Date getDate(int year, int month, int dayOfMonth) {
		return new GregorianCalendar(year, month, dayOfMonth).getTime();
	}

	public static void main(String[] args) {

		// Creation des organismes
		Organisme org1 = new Organisme("org1@gmail.com", "05050500505", "org1",
				"toto", "12212121212", "Organisme 1");
		Organisme org2 = new Organisme("org2@gmail.com", "05050500505", "org2",
				"toto", "12212223333", "Organisme 2");

		// Création des formations
		List<Stagiaire> listestagiaire = new ArrayList<Stagiaire>();
		List<Integer> listeNotes = new ArrayList<Integer>();
		Formation form1 = new Formation("Formation Java", "Toulouse",
				"Formation au java", getDate(2014, 8, 1), new Date(), 20,
				"bac+2", org1, listestagiaire, listeNotes);
		Formation form2 = new Formation("Formation JEE", "Toulouse",
				"Formation au java entreprise edition", getDate(2014, 3, 1),
				new Date(), 20, "bac+2 et java", org1, listestagiaire,
				listeNotes);
		Formation form3 = new Formation("Formation EJB", "Toulouse",
				"Formation au entreprise java bean", getDate(2014, 11, 1),
				new Date(), 20, "bac+2 JEE", org2, listestagiaire, listeNotes);
		Formation form4 = new Formation("Formation JSF", "Toulouse",
				"Formation au java server faces", getDate(2014, 7, 1),
				new Date(), 20, "bac+2 et JEE", org2, listestagiaire,
				listeNotes);
		/*
		 * // declaration map HashMap<Formation, Organisme>
		 * mapFormationParOrganisme = new HashMap<>();
		 * 
		 * // ajout formation, organisme dans la map
		 * 
		 * mapFormationParOrganisme.put(form1, org1);
		 * mapFormationParOrganisme.put(form2, org1);
		 * mapFormationParOrganisme.put(form3, org2);
		 * mapFormationParOrganisme.put(form4, org2);
		 * 
		 * // affichage map System.out.println(mapFormationParOrganisme);
		 */

		// ajout des formations au tableau du service
		ServiceFormation sf1 = new ServiceFormationImpl();
		System.out.println("Ajout des formations");
		try {
			sf1.ajouterFormation(form1);
			sf1.ajouterFormation(form2);
			sf1.ajouterFormation(form3);
			sf1.ajouterFormation(form4);

		} catch (ListePleineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ajout " + form1.getNomFormation());
		System.out.println("Ajout " + form2.getNomFormation());
		System.out.println("Ajout " + form3.getNomFormation());
		System.out.println("Ajout " + form4.getNomFormation());

		
		// affichage des formations par sql
		sf1.suppFormation();
		sf1.afficherFormation(form1);
		//sf1.afficherFormation(form2);
		//sf1.afficherFormation(form3);
		//sf1.afficherFormation(form4);
		
		

		
		
	/*	// affichage de la liste des formations
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("//////////////// Liste des formations");
		Iterator<Formation> it = ServiceFormationImpl.getTabFormations()
				.iterator();
		while (it.hasNext()) {
			Formation formation = it.next();
			System.out.println(formation.toString());

		}

		// Céation et affichage liste chainee de formations
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("//////////////// Liste des formations chainees");
		LinkedList<Formation> listeChainee = new LinkedList<Formation>();
		listeChainee.add(form1);
		listeChainee.add(form2);
		listeChainee.add(form3);
		listeChainee.add(form4);
		ListIterator<Formation> Literator = listeChainee.listIterator();
		while (Literator.hasNext()) {
			System.out.println(Literator.next());
			// Formation formation = iterator.next();
			// System.out.println(formation.toString());

		}

		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");
		System.out.println("/");

		// affichage liste chainee INVERSE
		System.out
				.println("//////////////// Liste des formations chainees INVERSE");

		while (Literator.hasPrevious()) {
			System.out.println(Literator.previous());
		}
*/
		/*
		 * // Affichage formation par date croissante System.out.println("/");
		 * System.out.println("/"); System.out.println("/");
		 * System.out.println("/"); System.out.println("/");
		 * System.out.println("/");
		 * System.out.println("//////////////// Liste des formations CROISSANTE"
		 * );
		 * 
		 * SortedSet<Formation> set = new TreeSet<Formation>(); set.add(form1);
		 * set.add(form2); set.add(form3); set.add(form4);
		 * 
		 * Iterator<Formation> iti = set.iterator(); while (iti.hasNext()) {
		 * System.out.println(iti.next()); }
		 */

		/*
		 * // méthode d'affichage des Arraylist for (Formation formation :
		 * ServiceFormationImpl.getTabFormations()) {
		 * System.out.println(formation.toString()); }
		 */

	/*	// inscription à la plateforme de stagiaire 1
		ServiceStagiaire ssi1 = new ServiceStagiaireImpl();
		ssi1.inscriptionPlateforme("stag1@gmail.com", "0263215876", "stag1",
				"mdp01"); // inscriptionPlateforme à la plateforme de stagiaire
							// 2
		ssi1.inscriptionPlateforme("stag2@gmail.com", "0263247896", "stag2",
				"mdp02");
		ssi1.inscriptionPlateforme("stag3@gmail.com", "0578614050", "stag3",
				"mdp03");

		// connexion à la plateforme du 1er stagiaire BufferedReader br1;

		String login = null;
		String mdp = null;
		boolean a;
		boolean conditionStop1 = false;
		while (!conditionStop1) {
			try {
				System.out.println("Saisissez votre login, s'il vous plait :");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(
						System.in));
				login = br1.readLine();
				System.out
						.println("Saisissez votre mot de passe, s'il vous plait : ");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(
						System.in));
				mdp = br2.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			a = ssi1.connexion(login, mdp);
			System.out.println(a);
			
			if (a == true) {
				conditionStop1 = true;
				System.out.println("le stagiaire1 est bien connecté!");
			}
		}

		// connexion à la plateforme du 2e stagiaire
		login = null;
		mdp = null;
		conditionStop1 = false;
		while (!conditionStop1) {
			try {
				System.out.println("Saisissez votre login, s'il vous plait :");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(
						System.in));
				login = br1.readLine();
				System.out
						.println("Saisissez votre mot de passe, s'il vous plait : ");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(
						System.in));
				mdp = br2.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			a = ssi1.connexion(login, mdp);
			if (a == true) {
				conditionStop1 = true;
				System.out.println("le stagiaire2 est bien connecté!");
			}
		}

		// connexion à la plateforme du 3e stagiaire

		login = null;
		mdp = null;
		conditionStop1 = false;
		while (!conditionStop1) {
			try {
				System.out.println("Saisissez votre login, s'il vous plait :");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(
						System.in));
				login = br1.readLine();
				System.out
						.println("Saisissez votre mot de passe, s'il vous plait : ");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(
						System.in));
				mdp = br2.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			a = ssi1.connexion(login, mdp);
			if (a == true) {
				conditionStop1 = true;
				System.out.println("le stagiaire3 est bien connecté!");
			}
		}

	*/	
	
/*
		 * //ssi1.connexion(inscrStag1); ServiceFormation servform1 = new
		 * ServiceFormationImpl(); ServiceStagiaire servstag1 = new
		 * ServiceStagiaireImpl();
		 * 
		 * // inscription à une formation List<Formation> formationsRetenues1 =
		 * servform1.rechercheFormationsInscription();
		 * servform1.inscrireStagiaire
		 * (servstag1.choisirFormation(formationsRetenues1), stagiaireConnecte);
		 * 
		 * // notation d'une formation servform1.evaluerFormation(form3);
		 * 
		 * List<Formation> formationsRetenues2 = null; // connexion à la
		 * plateforme du 2eme stagiaire //ssi1.connexion(inscrStag2); //
		 * inscription à une formation //List<Formation> formationsRetenues2 =
		 * ServiceFormationImpl.rechercheFormationsInscription();
		 * servform1.inscrireStagiaire
		 * (servstag1.choisirFormation(formationsRetenues2), inscrStag2); //
		 * notation d'une formation // servform2.evaluerFormation(form1);
		 * 
		 * // connexion à la plateforme du 3eme stagiaire
		 * //ssi1.connexion(inscrStag3); // inscription à une formation
		 * List<Formation> formationsRetenues3 =
		 * servform1.rechercheFormationsInscription();
		 * servform1.inscrireStagiaire
		 * (servstag1.choisirFormation(formationsRetenues3), inscrStag3); //
		 * notation d'une formation // servform3.evaluerFormation(form4);
		 */
	}
}
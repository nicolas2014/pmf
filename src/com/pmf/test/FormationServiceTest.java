package com.pmf.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pmf.modele.Formation;
import com.pmf.modele.Organisme;
import com.pmf.service.ServiceFormation;
import com.pmf.service.impl.ServiceFormationImpl;

/**
 * @author nicolas
 * 
 */
public class FormationServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.pmf.service.impl.ServiceFormationImpl#ajouterFormation(com.pmf.modele.Formation)}
	 * .
	 */
	@Test
	public void testAjouterFormation() {
		//fail("Not yet implemented");
		
	}

	/**
	 * Test method for
	 * {@link com.pmf.service.impl.ServiceFormationImpl#toString(com.pmf.modele.Formation)}
	 * .
	 */
	@Test
	public void testToString() {
		// Creation des organismes
		Organisme org1 = new Organisme("org1@gmail.com", "05050500505", "org1",
				"toto", "12212121212", "Organisme 1");
		Organisme org2 = new Organisme("org2@gmail.com", "05050500505", "org2",
				"toto", "12212223333", "Organisme 2");

		// Création des formations
		Formation form1 = new Formation("Formation Java", "Toulouse",
				"Formation au java", new Date(), new Date(), 20, "bac+2", org1, null, null);
		Formation form2 = new Formation("Formation JEE", "Toulouse",
				"Formation au java entreprise edition", new Date(), new Date(),
				20, "bac+2 et java", org1, null, null);
		Formation form3 = new Formation("Formation EJB", "Toulouse",
				"Formation au entreprise java bean", new Date(), new Date(),
				20, "bac+2 JEE", org2, null, null);
		Formation form4 = new Formation("Formation JSF", "Toulouse",
				"Formation au java server faces", new Date(), new Date(), 20,
				"bac+2 et JEE", org2, null, null);

		ServiceFormation sf1 = new ServiceFormationImpl();
		assertNotNull(sf1.toString(form1));
		assertNotNull(sf1.toString(form2));
		assertNotNull(sf1.toString(form3));
		assertNotNull(sf1.toString(form4));

		assertEquals(
				"-------------\nnom formation : Formation JSF\nlieu : Toulouse\ndescription : Formation au java server faces\n"
						+ "date de debut : 16/01/2014\ndate de fin : 16/01/2014",
				sf1.toString(form4));
	}


	@Test
	public void testToStringOrganismeNull() {
		Organisme org2 = null;

		Formation form4 = new Formation("Formation JSF", "Toulouse",
				"Formation au java server faces", new Date(), new Date(), 20,
				"bac+2 et JEE", org2, null, null);

		ServiceFormation sf1 = new ServiceFormationImpl();
		assertNotNull(sf1.toString(form4));
	}

	@Test
	public void testToStringFormationNull() {
		Formation form4 = null;
		ServiceFormation sf1 = new ServiceFormationImpl();
		assertNotNull(sf1.toString(form4));
		assertEquals("formation inexistante", sf1.toString(form4));
	}

	/**
	 * Test method for
	 * {@link com.pmf.service.impl.ServiceFormationImpl#rechercherFormation(java.lang.String)}
	 * .
	 */
	@Test
	public void testRechercherFormation() {
		fail("Not yet implemented");
	}



}

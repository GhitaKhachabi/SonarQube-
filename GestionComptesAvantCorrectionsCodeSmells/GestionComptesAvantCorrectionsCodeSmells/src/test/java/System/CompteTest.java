package System;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class CompteTest {

	@Test
	void testCompteOperations() throws ParseException {
		// Correct Date Format
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// Create Dates
		Date d1 = simpleDateFormat.parse("10/10/2017");
		Date d2 = simpleDateFormat.parse("11/11/2017");

		// Create Accounts
		Compte c1 = new Compte(d1, 1, 1000);
		Compte c2 = new Compte(d2, 2, 2000);

		// Create Client and Add Accounts
		Client cli = new Client("Abassar", 11, "Hajar");
		cli.comptes.add(new Compte(new Date(), 1, 1000));
		cli.comptes.add(new Compte(new Date(), 2, 2000));
		cli.afficherClient();


		// Initial State
		System.out.println("Initial State:");
		cli.afficherClient();
		assertEquals(1000, c1.getSolde());
		assertEquals(2000, c2.getSolde());

		// Credit Account
		c1.crediter(500);
		System.out.println("After Crediting 500 to c1:");
		cli.afficherClient();
		assertEquals(1500, c1.getSolde());

		// Transfer Funds
		c1.virement(c2, 1000);
		System.out.println("After Transferring 1000 from c1 to c2:");
		cli.afficherClient();
		assertEquals(500, c1.getSolde());
		assertEquals(3000, c2.getSolde());
	}
}

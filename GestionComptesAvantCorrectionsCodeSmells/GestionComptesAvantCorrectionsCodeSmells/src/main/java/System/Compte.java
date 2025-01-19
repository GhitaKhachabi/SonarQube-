package System;

import java.util.Date;

public class Compte {

	private Date dateCreation;
	private int numCompte;
	private float solde = 0;

	// Default Constructor
	public Compte() {
		this.dateCreation = new Date(); // Set the current date by default
	}

	// Parameterized Constructor
	public Compte(Date dateCreation, int numCompte, float solde) {
		this.dateCreation = dateCreation != null ? dateCreation : new Date();
		this.numCompte = numCompte;
		this.solde = Math.max(solde, 0); // Ensure non-negative initial balance
	}

	// Getters and Setters
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation != null ? dateCreation : new Date();
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public float getSolde() {
		return solde;
	}

	// Operations
	public void debiter(float montant) {
		if (montant <= 0) {
			throw new IllegalArgumentException("Le montant à débiter doit être positif.");
		}
		if (solde >= montant) {
			solde -= montant;
		} else {
			throw new IllegalArgumentException("Fonds insuffisants pour effectuer le débit.");
		}
	}

	public void crediter(float montant) {
		if (montant <= 0) {
			throw new IllegalArgumentException("Le montant à créditer doit être positif.");
		}
		solde += montant;
	}

	public void virement(Compte c, float montant) {
		if (c == null) {
			throw new IllegalArgumentException("Le compte destinataire ne peut pas être nul.");
		}
		this.debiter(montant); // Ensure debit is successful
		c.crediter(montant);  // Proceed with credit
	}

	@Override
	public String toString() {
		return String.format("Compte créé le %s, Numéro: %d, Solde: %.2f", dateCreation, numCompte, solde);
	}
}

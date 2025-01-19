package System;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String nomClient;
	private int numClient;
	private String prenomClient;
	public List<Compte> comptes = new ArrayList<>();

	// Constructor with parameters
	public Client(String nomClient, int numClient, String prenomClient) {
		this.nomClient = nomClient;
		this.numClient = numClient;
		this.prenomClient = prenomClient;
	}

	// Default constructor
	public Client() {
	}

	// Method to display client details and associated accounts
	public void afficherClient() {
		System.out.println("Nom du client: " + getNomClient());
		System.out.println("Numéro du client: " + getNumClient());
		System.out.println("Prénom du client: " + getPrenomClient());
		System.out.println("------- Les comptes bancaires associés : --------");
		for (Compte compte : comptes) {
			System.out.println(compte.toString());
		}
	}

	// Getter for NomClient
	public String getNomClient() {
		return nomClient;
	}

	// Setter for NomClient
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	// Getter for NumClient
	public int getNumClient() {
		return numClient;
	}

	// Setter for NumClient
	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

	// Getter for PrenomClient
	public String getPrenomClient() {
		return prenomClient;
	}

	// Setter for PrenomClient
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
}

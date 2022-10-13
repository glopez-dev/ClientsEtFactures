package metier;

import java.time.LocalDate;

public class Facture
{
	private Client client;
	private int montantfacture;
	private LocalDate datefacture; 
	private boolean reglementfacture;

	// Constructeur Facture à deux paramètres
	public Facture(int montant, Client client)
	{
		this.montantfacture = montant;
		this.client = client;
		// Initialisation des champs non fournis en paramètres
		this.datefacture = LocalDate.now();
		this.reglementfacture = false;
	}
	
	// Constructeur Facture a trois paramètres
	public Facture(int montant, boolean reglee, Client client)
	{
		this.montantfacture = montant;
		this.reglementfacture = reglee;
		this.client = client;
		// Initialisation des champs non fournis en paramètres
		this.datefacture = LocalDate.now();
	}
	
	// Constructeur Facture à 4 paramètres utilisé dans copie()
	public Facture(int montant, boolean reglee, LocalDate date, Client client)
	{
		this.montantfacture = Client.testMontant(montant);
		this.reglementfacture = reglee;
		this.client = client;
		// Initialisation des champs non fournis en paramètres
		this.datefacture = date;
	}
	
	/**
	 * Retourne le client à qui est adressée la facture..
	 * @return le client.
	 */
	
	public Client getClient()
	{
		return this.client;
	}

	/**
	 * Retourne le montant de la facture.
	 * @return le montant de la facture.
	 */
	
	public int getMontant()
	{
		return this.montantfacture;
	}

	/**
	 * Retourne vrai si la facture est reglée.
	 * @return vrai ssi la facture est reglée.
	 */
	
	public boolean estReglee()
	{
		return this.reglementfacture;
	}

	/**
	 * Retourne la date de la facture.
	 * @return la date de la facture.
	 */
	
	public LocalDate getDate()
	{
		return this.datefacture;
	}

	/**
	 * Supprime la facture
	 */
	
	public void delete()
	{
		client.deleteFacture(this);
	}
	
	/**
	 * Duplique la facture.
	 * @return une copie de la facture.
	 */
	
	public Facture copie()
	{
		Facture copie = new Facture(this.montantfacture, this.reglementfacture, this.datefacture, this.client);
		client.addFacture(copie);
		return copie;
	}
}
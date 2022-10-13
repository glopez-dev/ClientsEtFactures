package metier;

import java.util.ArrayList;
import java.util.List;

public class Client
{
	// Champs de Classe
	private static final List<Client> listeClients = new ArrayList<>();
	// Champs d'instance
	private ArrayList<Facture> factures = new ArrayList<Facture>();
	private String nomclient;
	
	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */
	
	public Client(String nom)
	{
		Client.listeClients.add(this);
		this.nomclient = nom;
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */
	
	public String getNom()
	{
		return this.nomclient;
	}
	
	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */
	
	public void setNom(String nom)
	{
		this.nomclient = nom;
	}
	
	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant)
	{
		Facture f = new Facture(testMontant(montant), this);
		this.factures.add(f);
		return f;
	}

	
	/**
	 * Retourne une copie de la liste des factures du client. 
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		List<Facture> copieListeFactures = new ArrayList<Facture>();
		for (int i = 0; i < this.factures.size(); i++)
		{
			copieListeFactures.add(this.factures.get(i));
		}
		return copieListeFactures;
	}
	
	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */
	
	public int sommeMontants()
	{
		int somme = 0;
		for (int i = 0; i < this.factures.size(); i++)
		{
			somme += this.factures.get(i).getMontant();
		}
		return somme;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * @param montant Le montant de la facture.
	 * @param reglée Vrai si la facture est reglée.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant, boolean reglee)
	{
		Facture f = new Facture(testMontant(montant), reglee, this);
		this.factures.add(f);
		return f;
	}	
	
	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */

	public List<Facture> facturesReglees()
	{
		ArrayList<Facture> facturesReglees = new ArrayList<Facture>();
		for (int i = 0; i < this.factures.size(); i++)
		{
			Facture f = this.factures.get(i);
			if (f.estReglee() == true)
			{
				facturesReglees.add(f);
			}
		}
		return facturesReglees;
	}
	

	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */
	public static List<Client> tous()
	{
		return Client.listeClients;
	}
	
	/**
	 * Supprime le client.
	 */
	
	public void delete()
	{
		Client.listeClients.remove(this);
	}
	
	public static int testMontant(int montant)
	{
		if (montant < 0)
		{
			throw new IllegalArgumentException("Le montant d'une facture ne peut pas être négatif.");
		}
		else return montant;
	}
	
	public void deleteFacture(Facture facture)
	{
		factures.remove(facture);
	}
}


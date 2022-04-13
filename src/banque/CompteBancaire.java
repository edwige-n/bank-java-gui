package banque;

/**
 * @author Edwige
 *
 */
public class CompteBancaire {
	public static double solde; 
	protected static String nomClient; 
	/**
	 * 
	 * @param solde
	 * @param nomClient
	 */
	public CompteBancaire(double solde, String nomClient) {
		this.solde = solde; 
		this.nomClient = nomClient; 
	}
	public static void versements (double montant) {
		if(montant > 0) {
			solde = montant + solde; 
		}
	}
	public static void retrait (double montant) {
		if(montant > 0) {
			solde = solde - montant; 
		}
	}

	 
	/** 
	 * @return le solde du client
	 */
	public static double getSolde() {
		return solde; 
	}
	/**
	 * @param le solde a modifier
	 */
	public void setSolde() {
		this.solde = solde; 
	}
	/**
	 * @return le nom du client
	 */
	protected static String getNomClient() {
		return nomClient; 
	}
	/**
	 * @param le nom du client à modifier
	 */
	protected void setClient() {
		this.nomClient = nomClient; 
}}
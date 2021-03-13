
/**
 * la classe Generique va �tre la g�n�ralisation des classes Acc�s et Fil
 * 
 * @author R. Gourdon, IUT de Nantes 
 * @version Septembre 2010
 */
public abstract class Generique
{
	// l'attribut commun est le nom
	private String nom;

	/**
	 * Constructeur de la classe Generique - version anonyme
	 */
	public Generique()
	{
		nom = "???";
	}

	/**
	 * Constructeur de la classe Generique - version nomm�e
	 */
	public Generique(String s)
	{
		nom = s;
	}

	/**
     * Accesseur pour lire le nom
     * 
     * @param  (aucun)
     * @return  (String) le nom de l'acc�s
     */
    public String getNom()
    {
        return nom;
    }
    
    /**
     * Accesseur (mutateur) pour �crire le nom
     * 
     * @param  (String) le nom affect�
     * @return  (aucun) 
     */
    public void setNom(String s)
    {
        nom = s;
    }

    /**
     * permet de r�cup�rer l'�tat sous forme d'une string
     * 
     * @return  (String) le texte d�crivant la valeur logique pr�sente sur l'�l�ment
     */
    public abstract String toString();
    
}

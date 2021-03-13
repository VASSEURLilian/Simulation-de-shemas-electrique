
/**
 * la classe Generique va être la généralisation des classes Accès et Fil
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
	 * Constructeur de la classe Generique - version nommée
	 */
	public Generique(String s)
	{
		nom = s;
	}

	/**
     * Accesseur pour lire le nom
     * 
     * @param  (aucun)
     * @return  (String) le nom de l'accès
     */
    public String getNom()
    {
        return nom;
    }
    
    /**
     * Accesseur (mutateur) pour écrire le nom
     * 
     * @param  (String) le nom affecté
     * @return  (aucun) 
     */
    public void setNom(String s)
    {
        nom = s;
    }

    /**
     * permet de récupérer l'état sous forme d'une string
     * 
     * @return  (String) le texte décrivant la valeur logique présente sur l'élément
     */
    public abstract String toString();
    
}


/**
 * la class Entree spécialise la classe Acces
 * 
 * @author R. Gourdon, IUT Nantes
 * @version 18 Septembre 2008
 */
public class Entree extends Acces
{
	/**
	 * Constructeur de la classe Entree (version avec nom)
	 */
	public Entree(String s)
	{
		super(s);
	}

	/**
	 * Constructeur de la classe Entree (version avec nom et fil)
	 */
	public Entree(String s,Fil f)
	{
		super(s,f);
	}

    /**
     * Accesseur pour charger une valeur sur l'accès. Nota : si aucun fil valide n'a
     * été relié à l'accès, la valeur sera perdue...
     * 
     * @param  (int) la valeur à mettre sur l'accès qui est alors une entrée
     * @return  (aucun)
     */
    public void setValeur(int val)
    {
        if (ficelle != null) ficelle.setValeur(val);
    }

	/**
     * Accesseur pour lire la valeur présente sur l'accès. Nota : si aucun fil valide n'a
     * été relié à l'accès, le résultat sera "indéterminé"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'accès qui est une entrée
     */
    public int getValeur()
    {
        int res = Fil.X;
        if (ficelle != null) res = ficelle.getValeurFuture();
        return res;
    }

        /**
     * Accesseur pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'accès
     */
    public int getSens()
    {
        return ENTREE;
    }

	  public static void main(String[] args)
    {
        // Création des fils
        Fil f0 = new Fil("net0000");
        Fil f1 = new Fil("net0001");
        // Création des accès
        Entree a1 = new Entree("E1",f0);
        Entree a2 = new Entree("E2",f1);
 
        a1.setValeur(Fil.ZERO);
        a2.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'accès "+f0.getNom()+" porte désormais la valeur "
            +a1.getValeur());
        System.out.println("L'accès "+f1.getNom()+" porte désormais la valeur "
            +a2.getValeur());
        
    }

    public String toString(){
        return String.valueOf(getValeur());
    }
	
}

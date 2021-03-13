
/**
 * la class Sortie spécialise la classe Acces
 * 
 * @author R. Gourdon, IUT Nantes
 * @version 18 Septembre 2008
 */
public class Sortie extends Acces
{

	/**
	 * Constructeur de la classe Sortie (version avec nom)
	 */
	public Sortie(String s)
	{
		super(s);
	}

	/**
	 * Constructeur de la classe Sortie (version avec nom et fil)
	 */
	public Sortie(String s,Fil f)
	{
		super(s,f);
	}
	
	/**
     * Accesseur pour lire la valeur présente sur l'accès. Nota : si aucun fil valide n'a
     * été relié à l'accès, le résultat sera "indéterminé"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'accès qui est alors une sortie
     */
    public int getValeur()
    {
        int res = Fil.X;
        if (ficelle != null) res = ficelle.getValeurActuelle();
        return res;
    }

    /**
     * Accesseur pour charger une valeur sur l'accès. 
     * Comme on est sur une sortie, cette opération n'a aucun effet !
     * 
     * @param  (int) la valeur à mettre sur l'accès qui est une sortie !
     * @return  (aucun)
     */
    public void setValeur(int val)
    {        
    }

    /**
     * Accesseur pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'accès
     */
    public int getSens()
    {
        return SORTIE;
    }
	
    public static void main(String[] args)
    {
        // Création des fils
        Fil f0 = new Fil();
        Fil f1 = new Fil("net0001");
        // Création des accès
        Sortie a3 = new Sortie("S1",f0);
        Sortie a4 = new Sortie("S2",f1);

        f0.setValeur(Fil.ZERO);
        f1.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'accès "+a3.getNom()+" porte désormais la valeur "
            +a3.getValeur());
        System.out.println("L'accès "+a4.getNom()+" porte désormais la valeur "
            +a4.getValeur());
        
    }
    
    public String toString(){
        return String.valueOf(getValeur());
    }


}

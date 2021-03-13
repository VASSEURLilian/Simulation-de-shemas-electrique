
/**
 * la class Entree sp�cialise la classe Acces
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
     * Accesseur pour charger une valeur sur l'acc�s. Nota : si aucun fil valide n'a
     * �t� reli� � l'acc�s, la valeur sera perdue...
     * 
     * @param  (int) la valeur � mettre sur l'acc�s qui est alors une entr�e
     * @return  (aucun)
     */
    public void setValeur(int val)
    {
        if (ficelle != null) ficelle.setValeur(val);
    }

	/**
     * Accesseur pour lire la valeur pr�sente sur l'acc�s. Nota : si aucun fil valide n'a
     * �t� reli� � l'acc�s, le r�sultat sera "ind�termin�"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'acc�s qui est une entr�e
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
     * @return  (int) le sens de l'acc�s
     */
    public int getSens()
    {
        return ENTREE;
    }

	  public static void main(String[] args)
    {
        // Cr�ation des fils
        Fil f0 = new Fil("net0000");
        Fil f1 = new Fil("net0001");
        // Cr�ation des acc�s
        Entree a1 = new Entree("E1",f0);
        Entree a2 = new Entree("E2",f1);
 
        a1.setValeur(Fil.ZERO);
        a2.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'acc�s "+f0.getNom()+" porte d�sormais la valeur "
            +a1.getValeur());
        System.out.println("L'acc�s "+f1.getNom()+" porte d�sormais la valeur "
            +a2.getValeur());
        
    }

    public String toString(){
        return String.valueOf(getValeur());
    }
	
}


/**
 * la class Sortie sp�cialise la classe Acces
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
     * Accesseur pour lire la valeur pr�sente sur l'acc�s. Nota : si aucun fil valide n'a
     * �t� reli� � l'acc�s, le r�sultat sera "ind�termin�"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'acc�s qui est alors une sortie
     */
    public int getValeur()
    {
        int res = Fil.X;
        if (ficelle != null) res = ficelle.getValeurActuelle();
        return res;
    }

    /**
     * Accesseur pour charger une valeur sur l'acc�s. 
     * Comme on est sur une sortie, cette op�ration n'a aucun effet !
     * 
     * @param  (int) la valeur � mettre sur l'acc�s qui est une sortie !
     * @return  (aucun)
     */
    public void setValeur(int val)
    {        
    }

    /**
     * Accesseur pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'acc�s
     */
    public int getSens()
    {
        return SORTIE;
    }
	
    public static void main(String[] args)
    {
        // Cr�ation des fils
        Fil f0 = new Fil();
        Fil f1 = new Fil("net0001");
        // Cr�ation des acc�s
        Sortie a3 = new Sortie("S1",f0);
        Sortie a4 = new Sortie("S2",f1);

        f0.setValeur(Fil.ZERO);
        f1.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'acc�s "+a3.getNom()+" porte d�sormais la valeur "
            +a3.getValeur());
        System.out.println("L'acc�s "+a4.getNom()+" porte d�sormais la valeur "
            +a4.getValeur());
        
    }
    
    public String toString(){
        return String.valueOf(getValeur());
    }


}

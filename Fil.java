
/**
 * la classe Fil impl�mente une liaison dans un sch�ma logique
 * 
 * @author R. Gourdon, IUT Nantes
 * @version Septembre 2008, , r�vis� 2011
 */
public class Fil extends Generique
{
    // variables d'instance
    private int valeurdEntree;
        // valeur affect�e � l'entr�e de la liaison
    private int valeurdeSortie;
        // valeur produite par propagation en sortie de la liaison
    public static final int ZERO = 0;
    public static final int UN = 1;
    public static final int X = 2;
    public static final int IDEM = -1;
        // constantes pour se faciliter l'�criture

    /**
     * Constructeur (version 1) : version par d�faut
     */
    public Fil()
    {
        // Chaque fil doit avoir un nom (ici : non d�fini)
        super();
        valeurdEntree = X;
        valeurdeSortie = X;
    }

    /**
     * Constructeur (version 2) : fixe le nom de la liaison
     */
    public Fil(String s)
    {
        // Chaque fil a un nom, fourni lors de l'instanciation
        super(s);
        valeurdEntree = X;
        valeurdeSortie = X;
    }

    /**
     * permet de r�cup�rer l'�tat du fil sous forme d'une string
     * 
     * @return  (String) le texte d�crivant la valeur logique pr�sente sur la liaison
     */
    public String toString()
    {
        String s;
        switch (valeurdeSortie) {
            case ZERO : s = " - 0 ";break;
            case UN : s = " - 1 ";break;
            case X : s = " - X ";break;
            default : s = " - ? ";break;
        }
        return s;
    }

    /**
     * permet de r�cup�rer l'�tat en sortie de la liaison
     * 
     * @return  (int) la valeur logique pr�sente sur la liaison (sortie)
     */
    public int getValeurActuelle()
    {
        return valeurdeSortie;
    }

    /**
     * permet de r�cup�rer l'�tat en entr�e de la liaison
     * 
     * @return  (int) la valeur logique pr�sente sur la liaison (entr�e)
     */
    public int getValeurFuture()
    {
        return valeurdEntree;
    }
    
    /**
     * permet d'affecter � l'entr�e de la liaison une valeur, qui pourra,
     * par la suite, �tre propag�e vers la sortie de la liaison. Si la valeur
     * transmise est IDEM, la valeurdEntree n'est pas modifi�e...
     * 
     * @param  (int) la valeur logique � mettre "sur" la liaison
     */
    public void setValeur(int val)
    {
        if (val != IDEM) valeurdEntree = val;
    }

    /**
     * permet de propager l'�tat de la liaison depuis son entr�e jusqu'�
     * sa sortie
     */
    public void propager()
    {
        valeurdeSortie = valeurdEntree;
    }
   
    public static void main(String[] args)
    {
        Fil f0 = new Fil("net0000");
        Fil f1 = new Fil("net0001");
        f0.setValeur(UN);
        f1.setValeur(ZERO);
        System.out.println("Le fil "+f0.getNom()+" porte d�sormais la valeur "
            +f0.getValeurFuture()+" (sans propagation)");
        System.out.println("Le fil "+f1.getNom()+" porte d�sormais la valeur "
            +f1.getValeurFuture()+" (sans propagation)");
        f0.propager();
        f1.propager();
        System.out.println("Le fil "+f0.getNom()+" porte d�sormais la valeur "
            +f0.getValeurActuelle()+" (apr�s propagation)");
        System.out.println("Le fil "+f1.getNom()+" porte d�sormais la valeur "
            +f1.getValeurActuelle()+" (apr�s propagation)");        
    }

}

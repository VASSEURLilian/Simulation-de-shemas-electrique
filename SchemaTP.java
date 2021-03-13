/**
 * La classe Schema impl�mente un sch�ma � simuler.
 * De l'ext�rieur, le sch�ma est inconnu : on sait seulement qu'il a des entr�es
 * (ici 2 dans un premier temps) et des sorties (ici : 1). Ce qui int�resse 
 * l'utilisateur de ce sch�ma, c'est de :
 *      - pouvoir appliquer des stimuli sur les entr�es
 *      - faire un pas de propagation
 *      - observer le r�sultat en sortie
 * 
 * A l'int�rieur, le sch�ma g�re les diff�rents constituants d'un sch�ma. En les 
 * instanciant, il �tablit les relations entre eux. Cette version op�re avec
 * des acc�s indff�renci�s (pas d'utilisation des classes Entr�e et Sortie. Cette
 * version permet la r�alisation d'un sch�ma � 2 entr�es et 1 sortie.
 * 
 * @author R. Gourdon, IUT de Nantes
 * @version Septembre 2010
 */
public class SchemaTP
{
    // les variables d'instance constituent le sch�ma
    private Entree entree1;
	private Entree entree2;
    private Sortie sortie;
    private Fil f0;
	private Fil f1;

    /**
     * Constructeur : il cr��e le sch�ma, c'est � dire les �lements reli�s entre eux
     */
    public SchemaTP()
    {
        // cr�ation des fils, qui ne savent pas � qui ils sont reli�es
        f0 = new Fil("net0000");
        f1 = new Fil("net0001");
        // Cr�ation des acc�s (reli�s � un fil)
        entree1 = new Entree("Entr�e 1",f0);
        entree2 = new Entree("Entr�e 2",f1);
        sortie = new Sortie("Sortie 1",f0);
    }
    
    /**
     * Affecte une valeur sur chacune des entr�es du sch�ma - Version � 2 entr�es
     * 
     * @param (int) la valeur du stimulus appliqu� sur la 1�re entr�e
     * @param (int) la valeur du stimulus appliqu� sur la 2�me entr�e
     */
    public void setStimuli(int val1,int val2) {
        entree1.setValeur(val1);
        entree2.setValeur(val2);
    }

    /**
     * permet de r�cup�rer (sous forme texte) les valeurs pr�sentes en entr�e 
     * 
     * @return (String) les valeurs pr�sentes en entr�e 
     */
    public String getEntreeString() {
        return entree1.toString()+" - "+entree2.toString();
    }
    
    /**
     * permet de r�cup�rer la valeur pr�sente en sortie du sch�ma - Version � 1 entr�e
     * 
     * @return (int) la valeur pr�sente en sortie
     */
    public int getSortie() {
        return sortie.getValeur();
    }

    /**
     * permet de r�cup�rer (sous forme texte) la valeur pr�sente en sortie 
     * 
     * @return (String) la valeur pr�sente en sortie
     */
    public String getSortieString() {
        return sortie.toString();
    }

    /**
     * permet de r�aliser un pas de simulation dans le sch�ma
     * 
     * @return (aucun)
     */
    public void calculeUnPas() {
        f0.propager();
        f1.propager();
    }

}

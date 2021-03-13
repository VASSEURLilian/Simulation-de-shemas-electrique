/**
 * La classe Schema implémente un schéma à simuler.
 * De l'extérieur, le schéma est inconnu : on sait seulement qu'il a des entrées
 * (ici 2 dans un premier temps) et des sorties (ici : 1). Ce qui intéresse 
 * l'utilisateur de ce schéma, c'est de :
 *      - pouvoir appliquer des stimuli sur les entrées
 *      - faire un pas de propagation
 *      - observer le résultat en sortie
 * 
 * A l'intérieur, le schéma gère les différents constituants d'un schéma. En les 
 * instanciant, il établit les relations entre eux. Cette version opère avec
 * des accès indfférenciés (pas d'utilisation des classes Entrée et Sortie. Cette
 * version permet la réalisation d'un schéma à 2 entrées et 1 sortie.
 * 
 * @author R. Gourdon, IUT de Nantes
 * @version Septembre 2010
 */
public class SchemaTP
{
    // les variables d'instance constituent le schéma
    private Entree entree1;
	private Entree entree2;
    private Sortie sortie;
    private Fil f0;
	private Fil f1;

    /**
     * Constructeur : il créée le schéma, c'est à dire les élements reliés entre eux
     */
    public SchemaTP()
    {
        // création des fils, qui ne savent pas à qui ils sont reliées
        f0 = new Fil("net0000");
        f1 = new Fil("net0001");
        // Création des accès (reliés à un fil)
        entree1 = new Entree("Entrée 1",f0);
        entree2 = new Entree("Entrée 2",f1);
        sortie = new Sortie("Sortie 1",f0);
    }
    
    /**
     * Affecte une valeur sur chacune des entrées du schéma - Version à 2 entrées
     * 
     * @param (int) la valeur du stimulus appliqué sur la 1ère entrée
     * @param (int) la valeur du stimulus appliqué sur la 2ème entrée
     */
    public void setStimuli(int val1,int val2) {
        entree1.setValeur(val1);
        entree2.setValeur(val2);
    }

    /**
     * permet de récupérer (sous forme texte) les valeurs présentes en entrée 
     * 
     * @return (String) les valeurs présentes en entrée 
     */
    public String getEntreeString() {
        return entree1.toString()+" - "+entree2.toString();
    }
    
    /**
     * permet de récupérer la valeur présente en sortie du schéma - Version à 1 entrée
     * 
     * @return (int) la valeur présente en sortie
     */
    public int getSortie() {
        return sortie.getValeur();
    }

    /**
     * permet de récupérer (sous forme texte) la valeur présente en sortie 
     * 
     * @return (String) la valeur présente en sortie
     */
    public String getSortieString() {
        return sortie.toString();
    }

    /**
     * permet de réaliser un pas de simulation dans le schéma
     * 
     * @return (aucun)
     */
    public void calculeUnPas() {
        f0.propager();
        f1.propager();
    }

}

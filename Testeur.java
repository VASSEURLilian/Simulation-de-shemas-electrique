import java.io.*;
    
/**
 * class Testeur : elle permet de tester le sch�ma
 * 
 * @author RG, IUT de Nantes
 * @version Septembre 2010
 */
public class Testeur
{

    /**
     * Methode main - seule et unique m�thode de la classe
     * C'est elle que l'on ex�cute pour tester le simulateur
     * 
     * @param  aucun
     * @return   aucun
     */

  public static void main(String[] args) throws IOException {  
      
        
        /********** Cr�ation du sch�ma ***********/
        SchemaTP sch =new SchemaTP();
        /************* Simulation proprement dite **********/
        boolean fini = false;
        while (!fini) {
            System.out.print("D�but d'un pas de simulation ");
            System.out.println(" (Etat actuel des entr�es : " + sch.getEntreeString() + ")");            
            // acquisition des stimuli qui sont appliqu�es sur les entr�es...
            int val_1 = lireValeurFil();    // permet de r�cup�rer une valeur au clavier
            int val_2 = lireValeurFil();
            // apr�s saisie au clavier, mettre � jour les entr�es du sch�ma
            sch.setStimuli(val_1,val_2);
            // effectuer un pas de simulation
            sch.calculeUnPas();
            // r�cup�rer l'�tat de la sortie du sch�ma et afficher le r�sultat
            System.out.print("La sortie du sch�ma vaut ");
            if (sch.getSortie() == Fil.X) System.out.println(" inconnu ");
            else System.out.println(sch.getSortie());
            // Terminaison de la boucle
            fini = finBoucle();
            }

        System.out.print(" -- Termine -- ");
        System.exit(0);
    }
    
    /**
     * Cette m�thode permet d'acqu�rir au clavier une valeur � mettre sur un fil
     * La valeur Fil.IDEM signifie "m�me valeur que pr�c�demment"
     * Nota : cette m�thode est statique car elle est appel�e par main qui est
     * elle-m�me statique
     * 
     * @param  aucun
     * @return valeur du fil
     */

    private static int lireValeurFil() throws IOException
    {   
        // pour acc�s clavier : TOUJOURS TERMIN�S PAR ENTREE
        BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
        
        // saisie d'une nouvelle valeur
        System.out.print(" - Nouvelle valeur (suivie de return) : ");
        String s = inr.readLine();
        int resultat = Fil.IDEM;
        if (s.length() >= 1) {
            switch (s.charAt(0)) {
                case (byte)'0':resultat =  Fil.ZERO;break;
                case (byte)'1':resultat =  Fil.UN;break;
                case (byte)'x':resultat =  Fil.X;break;
                case (byte)'X':resultat =  Fil.X;break;
                case '\r':resultat =  Fil.IDEM;break;
                default: resultat =  Fil.X;
                }
            }
        return resultat;
    }
    
    /**
     * Cette m�thode permet de demander � l'utilisateur s'il souhaite terminer
     * la simulation
     * Nota : cette m�thode est statique car elle est appel�e par main qui est
     * elle-m�me statique
     * 
     * @param  aucun
     * @return (boolean) VRAI si fin souhait�e
     */
    private static boolean finBoucle() throws IOException
    {
        BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nOn continue ? (n/N pour arr�ter - Autre pour continuer)");
        String s = inr.readLine();
        if (s.length() < 1) return false;
        if ((s.charAt(0))==(int)'n' || (s.charAt(0))==(int)'N') return true;
        else return false;
    }    
}

/**
 * Exemple d'utilisation de la programmation graphique
 * 
 * @author (Harold Mouch?re) 
 * @version (2)
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
// 
public class MonInterface extends Application implements EventHandler<ActionEvent>
{
        
        
        private RadioButton boutonradio[];
        private Button bouton[];
        private Label label1 = new Label();
        private Label label2 = new Label();
        private Label label3 = new Label();
        private Label label4 = new Label();
        private Label label5 = new Label();
        private Label label6 = new Label(); 
        private SchemaTP schema = new SchemaTP();
        int v1=2;
        int v2=2;
        
        /**
         * Démarrage de l'application
         */
        public void start(Stage primaryStage) {

        // choisir un titre
        primaryStage.setTitle("Simulateur de Circuits Logiques");
       
        // création de la zone de text
        label1.setText("Entrée 1: ");
        label2.setText("... ");
        label3.setText("Entrée 2: ");
        label4.setText("... ");
        label5.setText("Résulat en sortie: ");
        label6.setText("... ");
        
        boutonradio = new RadioButton[6];
        
        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        boutonradio[0] = new RadioButton("0");
        boutonradio[0].setOnAction(this);
        boutonradio[1] = new RadioButton("1");
        boutonradio[1].setOnAction(this);
        boutonradio[2] = new RadioButton("x");
        boutonradio[2].setOnAction(this);
        boutonradio[3] = new RadioButton("0");
        boutonradio[3].setOnAction(this);
        boutonradio[4] = new RadioButton("1");
        boutonradio[4].setOnAction(this);
        boutonradio[5] = new RadioButton("x");
        boutonradio[5].setOnAction(this);
        boutonradio[0].setToggleGroup(group1);
        boutonradio[1].setToggleGroup(group1);
        boutonradio[2].setToggleGroup(group1);
        boutonradio[3].setToggleGroup(group2);
        boutonradio[4].setToggleGroup(group2);
        boutonradio[5].setToggleGroup(group2);
        
        bouton = new Button[2];
        bouton[0] = new Button("pas");
        bouton[0].setOnAction(this);
        bouton[1] = new Button("RAZ");
        bouton[1].setOnAction(this);
        
        HBox contenant1 = new HBox(10);
        contenant1.getChildren().addAll(label1,boutonradio[0],boutonradio[1],boutonradio[2],label2);
        HBox contenant2 = new HBox(10);
        contenant2.getChildren().addAll(label3,boutonradio[3],boutonradio[4],boutonradio[5],label4);
        HBox contenant3 = new HBox(10);
        contenant3.getChildren().addAll(bouton[0],bouton[1],label5,label6);
        VBox contenant = new VBox();
        contenant.getChildren().addAll(contenant1, contenant2, contenant3);
        
        contenant1.setPadding(new Insets(10,15,10,15));
        contenant2.setPadding(new Insets(10,15,10,15));
        contenant3.setPadding(new Insets(10,5,10,5));
        contenant.setPadding(new Insets(10,15,10,15));
        
         
        primaryStage.setScene(new Scene(contenant, 300, 150));
       
        primaryStage.show();

    }
    /**
     * Traitement des actions (hérité de l'interface EventHandler<ActionEvent>)
     */
    public void handle(ActionEvent e) {
        if(e.getSource() == bouton[1])//bouton RAZ
        {
            //on remets les labels en inconnue
            label2.setText("...");
            label4.setText("...");
            label6.setText("...");
            //on desactive tous les boutons radios
            boutonradio[0].setSelected(false);
            boutonradio[1].setSelected(false);
            boutonradio[2].setSelected(false);
            boutonradio[3].setSelected(false);
            boutonradio[4].setSelected(false);
            boutonradio[5].setSelected(false);
            //on remet les variable de vameur a inconnue
            v1 = 2;
            v2 = 2;
        }
        if(boutonradio[0].isSelected() && bouton[0]==e.getSource())
        {
            v1=0;
            label2.setText("0");
        }
        if(boutonradio[1].isSelected() && bouton[0]==e.getSource())
        {
            v1=1;
            label2.setText("1");
        }
        if(boutonradio[2].isSelected() && bouton[0]==e.getSource())
        {
            v1=2;
            label2.setText("X");
        }
        if(boutonradio[3].isSelected() && bouton[0]==e.getSource())
        {
            v2=0;
            label4.setText("0");
        }
        if(boutonradio[4].isSelected() && bouton[0]==e.getSource())
        {
            v2=1;
            label4.setText("1");
        }
        if(boutonradio[5].isSelected() && bouton[0]==e.getSource())
        {
            v2=2;
            label4.setText("X");
        }
        if(bouton[0]==e.getSource() && (boutonradio[0].isSelected() || boutonradio[1].isSelected() || boutonradio[2].isSelected()) 
        && (boutonradio[3].isSelected() || boutonradio[4].isSelected() || boutonradio[5].isSelected())){
           schema.setStimuli(v1,v2);
           schema.calculeUnPas();
           if(schema.getSortie() ==2){
               label6.setText("X");
           }
           else{
           label6.setText("" + schema.getSortie());
           }
        }
        
    }
    /**
    * Arret de l'application
    */
        //@Override
    public void stop() 
    {// il faut quitter l'application lorsque la fenetre est fermée
          System.out.println("Fin!");
          System.exit(0);
    }
    public static void main(String[] args) {
        MonInterface.launch(args);
    }
   
}

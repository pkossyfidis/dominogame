/*
Η κλαση αυτη χρησιμοποιειται για να εμφανιζει στον παικτη το μενου του παιχνιδιου 
ωστε να μπορει να επιλεξει ποιο απο τα 2 παιχνιδια θα παιξει και στη συνεχεια καλει τις αναλογες μεθοδους 
για να αρχισει το παιχνιδι.
*/
package domino;
import Hungarian.*;
import javax.swing.JFrame;
import solo1.*;
import ola7.*;
/**
 *@author Ελευθεριος Δημητριου  Α.Ε.Μ:2891
 *@author Παναγιωτης Κοσσυφιδης Α.Ε.Μ:2928
 */
public class Domino {

    public static void main(String[] args) {
      
       /* UserInterface ui = new UserInterface();
        int choose = ui.Menu();
        if(choose==1){ 
        Player y= new Player();
        y.Start();
        }
        if(choose==2){
           int c;
           c=ui.Input();
           if(c==1){
           TilePrep x = new TilePrep();
           x.Game();
          }else if(c==2){
             TwoBots x=new TwoBots();
             x.Game2Bot();
           }else if(c==3){
               ThreeBots x = new ThreeBots();
               x.Game3Bot();
           }
        }
        if(choose==4){
            ui.GameOver();
            
        }
        if(choose==3){
            MainGame x = new MainGame();
           x.SetTiles();
           x.SetPbTiles();
           x.MaxTile();
           x.GameOla7();
        }*/
       
      /* Gui x = new Gui();
       x.setSize(500, 500);
       x.setVisible(true);*/
      
      Menu x = new Menu();
      x.setVisible(true);
      
     /* Test x = new Test();
      x.setVisible(true);*/
      
       
        
    }
    
}
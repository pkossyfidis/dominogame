/*
Στη κλαση αυτη πραγματοποιειται το μεγαλυτερο μερος του παιχνιδιου καθως σε αυτη την κλαση αρχικα μοιραζονται τα tiles
με τυχαια σειρα σε ενα πινακα.Στη συνεχεια υλοποιουνται μεθοδοι με την χρηση των οποιων επιτυγχανεται η σωστη λειτουργια
του παιχνιδιου.
*/
package solo1;
import domino.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;




/**
 *
 *@author Ελευθεριος Δημητριου  Α.Ε.Μ:2891
 *@author Παναγιωτης Κοσσυφιδης Α.Ε.Μ:2928
 */

public class Table {
    
    private ArrayList<Tiles> AllTiles;    
    private int k=0;
    private int flag=0;
    private boolean b=false;// Η μεταβλητη b χρησιμοποειται ωστε να ελεγχουμε αν ο χρηστης μπορεσε να παρει σωστα καποιο πλακιδιο
    String mystring1="Table: \n ",mystring2="Domino line: \n ";
    LinkedList<Tiles> List; 
    Tiles [][] table;
    
    public Table(){
        
        AllTiles = new ArrayList<>();
        table = new Tiles [4][7];
        List = new LinkedList<>();
        
    }    

    
    /*
    *Η μεθοδος αυτη αρχικοποιει το σετ των πλακιδιων χρησιμοποιωντας την κλαση Tiles.
    */
    public void SetTiles(){
       
        for(int i=0; i<=6;i++){
           
            for(int j=i;j<=6;j++){
                
                Tiles x = new Tiles(i,j);
                AllTiles.add(x);
                
            }
        }
    }
 
    
    /*
    *Στη μεθοδο αυτη τοποθετουμε με τυχαια σειρα τα πλακιδια με τη χρηση της μεθοδου random σε ενα ενα πινακα 4x7 . 
    */  
    public void FillTable(){
        int i=0,j=0 ,x,y;
        Random Randomtile = new Random();
        while(!AllTiles.isEmpty() &&  i<4 && j<7){   
            int z= Randomtile.nextInt(AllTiles.size());
            Tiles t =AllTiles.get(z);
            table[i][j]=t;
            AllTiles.remove(z);
            if(j<6){
                
                j++;
                
            }else{
               
                j=0;
                i++;
                
            }
        }
    }
    /*
    Η μεθοδος αυτη εμφανιζει τον πινακας που περιεχει τα πλακιδια.
    */
   public void DispTable(){
       String mystring=" ";

        UserInterface ui = new UserInterface();
        int x,y;
        for(int i=0; i<4; i++){
            
            for(int j=0; j<7; j++){
                x = table[i][j].getLeft();
                y = table[i][j].getRight();
                //ui.DisplayTable(table, i, j);
                mystring1 += Integer.toString(x)+"|"+Integer.toString(y)+" ";
                if(j==6){
                    mystring1 += "\n";
                }
                
            }
            
            ui.EmptySpace();
            
        }
       // ui.EmptySpace();
       Solo1gui t = new Solo1gui();
       t.output(mystring1,mystring2);
       t.setVisible(true);
       mystring1="Table:\n ";
       mystring2="Domino line: \n";
        
    }
    /*
    Η μεθοδος αυτη αποτελει το κυριο μερος του παιχνιδιου καθως σε αυτη ελεγχεται αρχικα αν το πλακιδιο που επιλεγει ο χρηστης
    υπαρχει στον πινακα(που περιεχει ολα τα πλακιδια) και δευτερον αν υπαρχει τοτε ελεγχεται αν μπορει να τοποθετηθει στην λιστα
    σωστα ωστε να διατηρειται η συνοχη των πλακιδιων.
    */
   public void SelectTile(){
        
        int left,right;
        int j1=6,j2=6,j3=6,j4=6;//Οι μεταβλητες αυτες δηλωνουν την καθε στηλη του πινακα
        int y1=1,y2=1;// Οι μεταβλητες αυτες δεχονται σαν 'ορισμα' τη γραμμη και τη στηλη του πλακιδιου το οποιο επελεξε ο χρηστης
        Tiles tile;
        Tiles invTile;//Αντιπροσωπευει το αντιθετο πλακιδιο απο αυτο που εδωσε ο χρηστης
        UserInterface ui = new UserInterface();
        while(List.size()<27){
        left = ui.SelectTileUi();        
        if(left==9){
            break;//Δινεται η δυνατοτητα στον παιχτη για τερματισμο του παιχνιδιου εαν δεν μπορει να συνχισει
        }
        right = ui.SelectTileUi2();
        tile = new Tiles(left,right); 
        invTile = new Tiles(right,left);
        
        if ( (table[0][j1].getLeft()==tile.getLeft()) && (table[0][j1].getRight()==tile.getRight())){
                   
            TileList(tile,invTile);
            if(b==true){//Αν b=true τοτε ο χρηστης πηρε σωστα το πλακιδιο 
                y1=0;//Το y1 παιρνει την πρωτη γραμμη 
                y2=j1;//Το y2 παιρνει την αναλογη στηλη
                if(j1!=0){
                    j1--;//Η εντολη αυτη χρησιμοποιειται ωστε να μειωθει η στηλη κατα ενα εφοσον ο χρηστης εχει επιλεξει το πλακιδιο απο τη συγκεκριμενη στηλη
                }        
            }
            ui.EmptySpace();
            DispList();
            DisTable(y1,y2);                

        }else if( (table[1][j2].getLeft()== tile.getLeft()) && (table[1][j2].getRight()==tile.getRight())){
                        
            TileList(tile,invTile);
            if(b==true){
               
                y1=1;
                y2=j2;
                if(j2!=0){
                    j2--;
                }
            }       
            ui.EmptySpace();
            DispList();
            DisTable(y1,y2);    
                        
        } else if ( (table[2][j3].getLeft()==tile.getLeft()) && (table[2][j3].getRight()==tile.getRight())){  
                    
            TileList(tile,invTile);
            if(b==true){
               
                y1=2;
                y2=j3;
                if(j3!=0){
                    j3--;
                }
            }
            ui.EmptySpace();
            DispList();
            DisTable(y1,y2);  
                        
        } else if ( (table[3][j4].getLeft()==tile.getLeft()) && (table[3][j4].getRight()==tile.getRight())){
                        
            TileList(tile,invTile);
            if(b==true){
               
                y1=3;
                y2=j4;
                if(j4!=0){
                    j4--;
                }
            }
            ui.EmptySpace();
            DispList();
            DisTable(y1,y2);   
                        
            }else{        
                ui.WrongTile();
            }
         
        }
        if(List.size()==27){
            ui.Win();
        }
    }
   /*
   Στη μεθοδο αυτη προσθετουμε τα πλακαδια που επιλεγει ο χρηστης απο τον πινακα σε μια λιστα με ελεγχους
   ετσι ωστε τα πλακιδια να ειναι τοποθετημενα με συνοχη(πχ. 5|6 6|2 2|4...).
   */
    public void TileList(Tiles t , Tiles t2){
        UserInterface ui = new UserInterface();
        if(flag==0){
           
            List.add(t);
            flag=1;
            b=true;
            
        }else if((t.getLeft()==List.getLast().getRight()) && (t.getRight()==List.getFirst().getLeft())){
            int cho = ui.Choice();
                       
            if(cho==0){
                
                List.addFirst(t);
                b=true;
                
            }else{
                
                List.add(t);
                b=true;
                
            }
        }else if((t.getLeft()==List.getFirst().getLeft()) && (t.getRight()==List.getLast().getRight())){
            int cho = ui.Choice2();
            
            
            if(cho==0){
                
                List.addFirst(t2);
                b=true;
                
            }else{
                
                List.add(t2);
                b=true;
                
            }
            
        }else if(t.getLeft()==List.getLast().getRight()){
            
            List.add(t);
            b=true;
            
        }else if(t.getRight()==List.getFirst().getLeft()){
            
            List.addFirst(t);
            b=true;
            
        }else if ((t.getRight()==List.getLast().getRight())){
            
            List.add(t2);
            b=true;
            
        } else if ((t.getLeft()==List.getFirst().getLeft())){
           
            List.addFirst(t2);
            b=true;
            
        }else{
            
            b=false;
            ui.WrongTile();
            
        }
    } 

    /*
    Η μεθοδος αυτη χρησιμοποιειται για να εμφανισουμε τον πινακα χωρις τα πλακιδια που εχει τοποθετησει ο χρηστης
    στην λιστα.
    Τα ορισματα y1 και y2 ειναι οι αντιστοιχες τιμες του πλακιδιου που θελουμε να του δωσουμε ακραιες  τιμες 
    για να μην εμφανιστει.
    */
    public void DisTable(int y1,int y2){
        
        Tiles k = new Tiles(10,10);//Δημιουργια νεου πλακιδιου με ακραιες τιμες.
        UserInterface ui = new UserInterface();
        int x,y;
        for(int i=0; i<4; i++){
            
            for(int j=0; j<7; j++){
               
                if(i!=y1 || j!=y2){
                    
                    if(table[i][j].getLeft()<10 && table[i][j].getRight()<10){
                        //ui.DisplayTable(table, i, j);
                        x=table[i][j].getLeft();
                        y=table[i][j].getRight();
                        mystring1 += Integer.toString(x)+"|"+Integer.toString(y)+" ";
                       /* if(j==6){
                        mystring += "\n";
                        }*/
                  
                    }
                }else{
                    
                    table[y1][y2]=k;
                    /*if(j==6){
                        mystring += "\n";
                    }*/
                    //mystring += "\n";
                     
                }
            }
            mystring1 += "\n";
            
            ui.EmptySpace();
            
        } 
        //ui.DisplayTable(mystring);
        Solo1gui t = new Solo1gui();
        t.output(mystring1,mystring2);
        t.setVisible(true);
        mystring1=" ";
        mystring2="Domino line: \n ";
    }      
    /*
    Στην μεθοδο αυτη εμφανιζουμε την λιστα που περιεχει τα πλακιδια που τοποθετησε ο χρηστης.
    */
    public void DispList(){
        UserInterface ui = new UserInterface();
       // ui.DominoLine();
        String mystring=" ";
        
        int left,right;
        for (int i=0;i<List.size();i++){  
           
            Tiles x = List.get(i);
            left = x.getLeft();
            right = x.getRight();
            //ui.DisplayList(x);
            mystring2 += Integer.toString(left)+"|"+Integer.toString(right)+" ";
        }
        ui.EmptySpace();
        Solo1gui t = new Solo1gui();
        t.output(mystring1,mystring2);
        t.setVisible(true);
        mystring1="Table: \n ";
    }
}
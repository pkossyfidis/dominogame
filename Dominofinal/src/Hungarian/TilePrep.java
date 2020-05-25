/*
Στη κλαση αυτη πραγματοποιειται το μεγαλυτερο μερος του παιχνιδου καθως υπαρχουν μεθοδοι οι οποιες υλοποιους τοσο το μοιρασμα των πλακιδιων
στον παιχτη και στο bot οσο και μεθοδοι οι οποιες ειναι υπευθυνες για την ομαλη λειτουργια του παιχνιδιου(γυρος,ποντοι κλπ).
*/
package Hungarian;
import domino.*;
import solo1.Tiles;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;


/**
 *@author Ελευθεριος Δημητριου  Α.Ε.Μ:2891
 *@author Παναγιωτης Κοσσυφιδης Α.Ε.Μ:2928
 */

public class TilePrep {
    
    private ArrayList<Tiles> AllTiles2; 
    public Tiles[] arrayP,arrayB;
    LinkedList<Tiles> DominoLine; 
    Tiles maxP = new Tiles(-1,-1) ;
    Tiles maxB = new Tiles(-1,-1) ;  
    String mystring1="Bot Tiles:",mystring2="Player Tiles:",mystring3="Domino line: ";
    
    public TilePrep(){
        AllTiles2 = new ArrayList<>();
        arrayP = new Tiles[12];
        arrayB = new Tiles[12];
        DominoLine = new LinkedList<>();    
    }
    /*
    Η μεθοδος αυτη αρχικοποιει το σετ των πλακιδιων χρησιμοποιωντας την κλαση Tiles.
    */
    public void SetTiles2(){
        for(int i=0;i<=6;i++){
            for(int j=i;j<=6;j++){               
                Tiles x = new Tiles(i,j);
                AllTiles2.add(x);
            }
        }
    }
    
    /*
    Η μεθοδος αυτη με τη χρηση της συναρτησης random μοιραζει τυχαια τα πλακιδια, αρχικα στον πινακα που αντιπροσωπευει τα tiles του παιχτη 
    και στη συνεχεια με τον ιδιο τροπο τα tiles του bot.
    */
    public void SetPbTiles(){
        int z;
        Random RandTile =  new Random();
        for(int i=0;i<=11;i++){
            z=RandTile.nextInt(AllTiles2.size());
            Tiles index =AllTiles2.get(z);
            arrayP[i]=index;
            AllTiles2.remove(z);
            
        }
        for(int i=0;i<=11;i++){
            z=RandTile.nextInt(AllTiles2.size());
            Tiles index =AllTiles2.get(z);
            arrayB[i]=index;
            AllTiles2.remove(z);
            
        }
    }
    /*
    Η μεθοδος αυτη εμφανιζει τα πλακιδια που εχει στη κατοχη του ο παιχτης.
    */
    public void DisTilesP(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispPlayerTiles();
        int x=0,y=0;
        for(int i=0;i<=11;i++){
            if(arrayP[i].getLeft()!=DontDisp.getLeft()){
                //ui.DispPtiles(arrayP, i);
                x = arrayP[i].getLeft();
                y = arrayP[i].getRight();
                mystring2 += Integer.toString(x)+"|"+Integer.toString(y)+" "; 
            }   
        }
        //System.out.print(" ");
       HungarianGui t = new HungarianGui();
       t.output(mystring1,mystring2,mystring3);
       t.setVisible(true);
       mystring1="BotTiles:\n ";
       mystring2="Player Tiles: \n";
       mystring3="Dominoline: \n";
    }
    /*
    Η μεθοδος αυτη εμφανιζει τα πλακιδια που εχει στη κατοχη του το bot.
    */
    public void DisTilesB(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispBotTiles();
        for(int i=0;i<=11;i++){
            if(arrayB[i].getLeft()!=DontDisp.getLeft()){
                //ui.DispBtiles(arrayB,i);
                mystring1 += "-|-"+" ";
            }
        }  
        //ui.EmptySpace();
       HungarianGui t = new HungarianGui();
       t.output(mystring1,mystring2,mystring3);
       t.setVisible(true);
       //mystring1="BotTiles:\n ";
       //mystring2="Player Tiles: \n";
       mystring3="Dominoline: \n";
    }
    /*
    Η μεθοδος αυτη βρισκει το μεγαλυτερο πλακιδιο που εχει ο παιχτης και το μεγαλυτερο πλακιδιο που εχει το bot.
    */   
    public void MaxTile(){
        int index=0;
            for (int i = 0; i < arrayB.length; i++) {
                if((arrayP[i].getLeft()>maxP.getLeft() && arrayP[i].getRight()>maxP.getRight()) && arrayP[i].getLeft()==arrayP[i].getRight()){

                    int side1 = arrayP[i].getLeft();
                    int side2 = arrayP[i].getRight();
                    maxP = new Tiles(side1,side2);    
                }

                if((arrayB[i].getLeft()>maxB.getLeft() && arrayB[i].getRight()>maxB.getRight())  && arrayB[i].getLeft()==arrayB[i].getRight()){

                    int side3 = arrayB[i].getLeft();
                    int side4 = arrayB[i].getRight();
                    maxB = new Tiles(side3,side4);  

                }          
            }

    }
    /*
    Στη μεθοδο αυτη πραγματοποιουνται ελεγχοι ωστε η εναλλαγη των γυρων και το μετρημα των ποντων να γινεται σωστα και υπαρχουν συθνηκες 
    που βοηθουν στην ομαλη λειτουργια του παιχνιδου οταν ειναι η σειρα του παικτη.
    */
     public void Game(){
        UserInterface ui = new UserInterface();
        int flag1=0,flag2=0;//
        int pointsplayer=0,pointsbot=0;
        boolean PlayerTurn=false;   
        while(pointsplayer<100 && pointsbot<100){
            int sump=0;//Ποντοι παικτη.
            int sumb=0;//ποντοι bot.
            SetTiles2();
            SetPbTiles();
            MaxTile();       
            if (maxP.getLeft()>maxB.getLeft() && maxP.getRight()>maxB.getRight()){
            PlayerTurn=true;
            }
        while((sump<12 && sumb<12)&& (CheckPlayer() || CheckBot())){ 
            //ui.DispBotTiles();
            ui.DispPointsP(pointsplayer);
            ui.DispPointsB(pointsbot);
        if(PlayerTurn==true){
            boolean flag3=CheckPlayer();
            flag2=1;//Χρησιμοποιειται για να μην μπει στο max του bot,οταν ο παικτης ξεκιναει πρωτος.
            //ui.PlayerTurn();
            DisTilesP();
            while(flag3){               
                int left=ui.GiveFirstTile();
                int right=ui.GiveSecTile();
                Tiles tileP =  new Tiles(left,right);
                Tiles cloneTile = new Tiles(right,left);
                int j=0;
                for (Tiles arrayP1 : arrayP) {
                    if((tileP.getLeft()==arrayP[j].getLeft())&&(tileP.getRight()==arrayP[j].getRight())){  
                        if(flag1==0){
                            DominoLine.add(tileP);
                            sump++;//Μετραει τα πλακιδια ετσι ωστε οταν γινουν 12 να γνωριζει οτι ο παικτης τοποθετησε ολα τα πλακιδια του.
                            DispDominoLine();
                            FakeTile(j,1);     
                            flag1++;
                        }else if((tileP.getLeft()==DominoLine.getLast().getRight()) && (tileP.getRight()==DominoLine.getFirst().getLeft())){
                             TilePlacement(tileP,0,j);
                             sumb++;                    
                        }else if((tileP.getLeft()==DominoLine.getFirst().getLeft()) && (tileP.getRight()==DominoLine.getLast().getRight())){
                             TilePlacement(cloneTile,1,j);
                             sumb++;  
                            
                        }else if(tileP.getLeft()==DominoLine.getLast().getRight()){
                            DominoLine.addLast(tileP);
                            sump++;
                            DispDominoLine();
                            FakeTile(j,1);
                        }else if(tileP.getRight()== DominoLine.getFirst().getLeft()){
                            DominoLine.addFirst(tileP);
                            sump++;
                            FakeTile(j,1);
                            DispDominoLine();
                        }else if(tileP.getLeft()== DominoLine.getFirst().getLeft()){
                            DominoLine.addFirst(cloneTile);
                            sump++;
                            FakeTile(j,1);
                            DispDominoLine();
                        }else if(tileP.getRight()==DominoLine.getLast().getRight()){
                            DominoLine.addLast(cloneTile);
                            sump++;
                            FakeTile(j,1);
                            DispDominoLine();
                        }else{
                            if(j==11){
                                ui.WrongTile();
                            }
                        }
                    }else{
                        j++;   
                    }
            }           
            DisTilesP();
            flag3=CheckPlayer();
          } 
            PlayerTurn=false;
        }else{
            flag1=1;////Χρησιμοποιειται για να μην μπει στο max του παικτη,οταν το bot ξεκιναει πρωτο.
            //ui.BotTurn();
            do{
                if(flag2==0){         
                    flag2=AddMaxBot(flag2); 
                    sumb++;
                }else{ 
                    flag2=1;    
                    sumb=BotTurn(sumb);
                    PlayerTurn=true;   
                    ui.EmptySpace();
                    DisTilesB();
                    DispDominoLine();
                    }
                }while(PlayerTurn!=true);     
        }     
    }
        if(sump==12 || (CheckBot()==false && CheckPlayer()==true)){
            pointsplayer += BotPoints(arrayB);//Δινω τους ποντους που εχουν απομεινει απο το bot.
        }else if(sumb==12 || (CheckBot()==true && CheckPlayer()==false)){      
            pointsbot += PlayerPoints(arrayP);//Δινω τους ποντους που εχουν απομεινει απο τον παικτη.
        }else if(CheckBot()==false && CheckPlayer()==false){
            pointsplayer += BotPoints(arrayB);
            pointsbot+=PlayerPoints(arrayP);
        } 
    }
}
    /*
     Η μεθοδος αυτη εμφανιζει τη λιστα που περιεχει τα πλακιδια που εχουν παιχτει.
     */    
     public void DispDominoLine(){
        //UserInterface ui = new UserInterface();
        //ui.DominoLine();
        int left,right;
        for (int i=0;i<DominoLine.size();i++){  
           
            Tiles y = DominoLine.get(i);
            //ui.DisplayList(y);
            left = y.getLeft();
            right = y.getRight();
            mystring3 += Integer.toString(left)+"|"+Integer.toString(right)+" "; 
            
        }
        HungarianGui t = new HungarianGui();
        t.output(mystring1, mystring2, mystring3);
        t.setVisible(true);

    }
    /*
     Η μεθοδος αυτη ελεγχει αν καποιο απο τα πλακιδια που εχει στη κατοχη του ο παικτης μπορει να προσθεθει στη λιστα.
     */ 
    public boolean CheckPlayer(){
        boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayP.length;i++){
                if(arrayP[i].getLeft()==DominoLine.getFirst().getLeft() || arrayP[i].getRight()==DominoLine.getFirst().getLeft()){
                    
                    flag=true;
                    
                }else if(arrayP[i].getLeft()==DominoLine.getLast().getRight() || arrayP[i].getRight()==DominoLine.getLast().getRight()){
                    
                    flag=true;
                }
            }
        }
        return flag;
    }
    
    /*
     Η μεθοδος αυτη ελεγχει αν καποιο απο τα πλακιδια που εχει στη κατοχη το μποτ  μπορει να προσθεθει στη λιστα.
     */ 
    public boolean CheckBot(){
       boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayB.length;i++){
                if(arrayB[i].getLeft()==DominoLine.getFirst().getLeft() || arrayB[i].getRight()==DominoLine.getFirst().getLeft()){
                    
                    flag=true;
                    
                }else if(arrayB[i].getLeft()==DominoLine.getLast().getRight() || arrayB[i].getRight()==DominoLine.getLast().getRight()){
                    
                    flag=true;
                }
            }
        }
        return flag; 
        
    }
    
    /*
    Η μεθοδος αυτη επιστρεφει τους ποντους που εχει μαζεψει ο παικτης.
    */
    public int  PlayerPoints(Tiles [] arrayP){
        int ppoints=0;
        for(int i=0;i<12;i++){
            if(arrayP[i].getLeft()!=-1 && arrayP[i].getRight()!=-1){
                ppoints = ppoints + arrayP[i].getLeft() + arrayP[i].getRight();
            }
            
        }
        return ppoints;
    }  
    
    /*
    Η μεθοδος αυτη επιστρεφει τους ποντους που εχει μαζεψει το bot.
    */
    public int  BotPoints(Tiles [] arrayB){
        int  bpoints=0;
        for(int i=0;i<12;i++){
            if(arrayB[i].getLeft()!=-1 && arrayB[i].getRight()!=-1){
                bpoints = bpoints + arrayB[i].getLeft() + arrayB[i].getRight();
            }
            
        }
        
        return bpoints;    
    }
    /*
    Η μεθοδος αυτη προσθετει το μεγαλυτερο στοιχειο του bot στη λιστα εφοσον ξεκιναει πρωτο.
    */
     public int AddMaxBot(int flag2){
        int index=0;
        DominoLine.addFirst(maxB);
        //DispDominoLine();
        for(int i=0;i<arrayB.length;i++){
            if(maxB.getLeft()==arrayB[i].getLeft() && maxB.getRight()==arrayB[i].getRight()){
                index=i; //Βρισει τη θεση του μεγαλυτερου πλακιδιου του bot.
            }   
        }
        FakeTile(index,0);//Εδω γινεται η αντικατασταση του μεγαλυτερου στοιχειου με ενα faketile.
        flag2=1; 
        return flag2;            
     }
     /*
     Στη μεθοδο αυτη γινεται η αντικατασταση επιλεγμενων πλακιδιων ειτε απο τον παικτη ειτε απο το bot , με ενα πλακιδιο που
     περιεχει ακραιες τιμες .
     */
     public void FakeTile(int pos,int Turn){
         Tiles Dont= new Tiles(-1,-1);
         if(Turn==1){
         arrayP[pos]=Dont;
         }else{
             
         arrayB[pos]=Dont;
         }
     }
     /*
     Η μεθοδος αυτη αποτελειται απο συνθηκες και εντολες ωστε να πραγματοποιειται σωστα ο γυρος του bot.
     */
     public int BotTurn(int sumb){
         int j=0;
         do{
            if(arrayB[j].getLeft()==DominoLine.getLast().getRight()){
                                int left=arrayB[j].getLeft();
                                int right=arrayB[j].getRight();
                                Tiles tileB = new Tiles(left,right);
                                DominoLine.addLast(tileB); 
                                sumb++;
                                FakeTile(j,0);
                                j=-1;//Για να ελεγχει απο την αρχη τα στοιχεια του πινακα .
                            }else if(arrayB[j].getRight()== DominoLine.getFirst().getLeft()){
                                int left=arrayB[j].getLeft();
                                int right=arrayB[j].getRight();
                                Tiles tileB = new Tiles(left,right);
                                DominoLine.addFirst(tileB);
                                sumb++;
                                FakeTile(j,0);
                                j=-1;
                            }else if(arrayB[j].getLeft()== DominoLine.getFirst().getLeft()){
                                int left=arrayB[j].getLeft();
                                int right=arrayB[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addFirst(tileB);
                                sumb++;
                                FakeTile(j,0);
                                j=-1;
                            }else if(arrayB[j].getRight()==DominoLine.getLast().getRight()){
                                int left=arrayB[j].getLeft();
                                int right=arrayB[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addLast(tileB);
                                sumb++;
                                FakeTile(j,0); 
                                j=-1;
                            } 
                        j++;          
                    }while(j<=11);
         return sumb;
     }
     /*
     Η μεθοδος για την εισαγωγη ενος πλακιδιου στη λιστα οταν αυτο μπορει να τοποθετηθει ειτε στην αρχη ειτε στο τελος της λιστας.
     */
     public void TilePlacement(Tiles tileP,int num,int j){
        UserInterface ui = new UserInterface();
        if(num==0){
          int cho=ui.Choice();
                            if(cho==0){
                                DominoLine.addFirst(tileP); 
                                
                                DispDominoLine();
                                FakeTile(j,1);
                            }else{
                                DominoLine.add(tileP);      
                                DispDominoLine();
                                FakeTile(j,1);
                            }
        }else{
            int cho=ui.Choice2();
                            if(cho==0){
                                DominoLine.addFirst(tileP);
                                
                                DispDominoLine();
                                FakeTile(j,1); 
                            }else{
                                DominoLine.add(tileP);
                                
                                DispDominoLine();
                                FakeTile(j,1);
                            }
        }
        
     }
}
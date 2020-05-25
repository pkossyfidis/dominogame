
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
public class TwoBots {
    private ArrayList<Tiles> AllTiles3; 
    public Tiles[] arrayP,arrayB1,arrayB2;
    LinkedList<Tiles> DominoLine; 
    int turn;
    Tiles maxP = new Tiles(-1,-1) ;
    Tiles maxB1 = new Tiles(-1,-1) ;  
    Tiles maxB2 = new Tiles(-1,-1) ;  
    String mystring1="Bot Tiles:",mystring2="Player Tiles:",mystring3="Domino line: ",mystring4="Bot2 Tiles:";
    int  bpoints=0;
    int ppoints =0;
    public TwoBots(){
        AllTiles3 = new ArrayList<>();
        arrayP = new Tiles[8];
        arrayB1 = new Tiles[8];
        arrayB2 = new Tiles[8];
        DominoLine = new LinkedList<>();    
    }
    
    
    
    /*
    Η μεθοδος αυτη αρχικοποιει το σετ των πλακιδιων χρησιμοποιωντας την κλαση Tiles.
    */
    public void SetTiles3(){
        for(int i=0;i<=6;i++){
            for(int j=i;j<=6;j++){               
                Tiles x = new Tiles(i,j);
                AllTiles3.add(x);
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
        for(int i=0;i<=7;i++){
            z=RandTile.nextInt(AllTiles3.size());
            Tiles index =AllTiles3.get(z);
            arrayP[i]=index;
            AllTiles3.remove(z);
            
        }
        for(int i=0;i<=7;i++){
            z=RandTile.nextInt(AllTiles3.size());
            Tiles index =AllTiles3.get(z);
            arrayB1[i]=index;
            AllTiles3.remove(z);
            
        }
        for(int i=0;i<=7;i++){
            z=RandTile.nextInt(AllTiles3.size());
            Tiles index =AllTiles3.get(z);
            arrayB2[i]=index;
            AllTiles3.remove(z);
            
        }
    }
    /*
    Η μεθοδος αυτη εμφανιζει τα πλακιδια που εχει στη κατοχη του ο παιχτης.
    */
    public void DisTilesP(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        //ui.DispPlayerTiles();
        int x=0,y=0;
        for(int i=0;i<=7;i++){
            if(arrayP[i].getLeft()!=DontDisp.getLeft()){
            x = arrayP[i].getLeft();
                y = arrayP[i].getRight();
                mystring2 += Integer.toString(x)+"|"+Integer.toString(y)+" "; 
            }   
        }
        //ui.EmptySpace();
       HungarianGui2 t = new HungarianGui2();
       t.output(mystring1, mystring4, mystring2,mystring3);
       t.setVisible(true);
       mystring1="BotTiles:\n ";
       mystring4="Bot2 Tiles:\n";
       mystring2="Player Tiles: \n";
       mystring3="Dominoline: \n";
    }
    /*
    Η μεθοδος αυτη εμφανιζει τα πλακιδια που εχει στη κατοχη του το bot.
    */
    public void DisTilesB1(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        //ui.DispBotTiles();
        for(int i=0;i<=7;i++){
            if(arrayB1[i].getLeft()!=DontDisp.getLeft()){
                //ui.DispBtiles(arrayB,i);
                mystring1 += "-|-"+" ";
            
            }
        }  
        //ui.EmptySpace();
        HungarianGui2 t = new HungarianGui2();
       t.output(mystring1,mystring4,mystring2,mystring3);
       t.setVisible(true);
       //mystring1="BotTiles:\n ";
       //mystring2="Player Tiles: \n";
       mystring3="Dominoline: \n";
    }
     public void DisTilesB2(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        //ui.DispBot2Tiles();
        for(int i=0;i<=7;i++){
            if(arrayB2[i].getLeft()!=DontDisp.getLeft()){
            mystring4 += "-|-"+" ";
            }
        }  
        //ui.EmptySpace();
         HungarianGui2 t = new HungarianGui2();
         t.output(mystring1,mystring4,mystring2,mystring3);
         t.setVisible(true);
         mystring3="Dominoline: \n";
    }
     
      /*
    Η μεθοδος αυτη βρισκει το μεγαλυτερο πλακιδιο που εχει ο παιχτης και το μεγαλυτερο πλακιδιο που εχει το bot.
    */   
    public void MaxTile(){
   
        for (int i = 0; i < arrayB1.length; i++) {
            if((arrayP[i].getLeft()>maxP.getLeft() && arrayP[i].getRight()>maxP.getRight()) && arrayP[i].getLeft()==arrayP[i].getRight()){
                
                int side1 = arrayP[i].getLeft();
                int side2 = arrayP[i].getRight();
                maxP = new Tiles(side1,side2);    
            }
            
            if((arrayB1[i].getLeft()>maxB1.getLeft() && arrayB1[i].getRight()>maxB1.getRight())  && arrayB1[i].getLeft()==arrayB1[i].getRight()){
                
                int side3 = arrayB1[i].getLeft();
                int side4 = arrayB1[i].getRight();
                maxB1 = new Tiles(side3,side4);  
                
            } 
            if((arrayB2[i].getLeft()>maxB2.getLeft() && arrayB2[i].getRight()>maxB2.getRight())  && arrayB2[i].getLeft()==arrayB2[i].getRight()){
                
                int side3 = arrayB2[i].getLeft();
                int side4 = arrayB2[i].getRight();
                maxB2 = new Tiles(side3,side4);  
                
            }          
        }
        
    }
    public void Game2Bot(){
        
        UserInterface ui = new UserInterface();
        int flagP=0,flagB1=0,flagB2=0;//
        int pointsplayer=0,pointsbot1=0,pointsbot2=0;
        int sumpoints;
        while(pointsplayer<100 && pointsbot1<100 && pointsbot2<100){
            int sump=0;//Tiles παικτη.
            int sumb1=0;//Tiles bot1.
            int sumb2=0;//Tiles bot2.
            SetTiles3();
            SetPbTiles();
            MaxTile();
            int fm=FindMax(maxP,maxB1,maxB2);
        while((sump<7 && sumb1<7 && sumb2<7)&& (CheckPlayer() && CheckBot1() && CheckBot2())){ 
            ui.DispPointsP(pointsplayer);
            ui.DispPointsB(pointsbot1);
            ui.DispPointsB2(pointsbot2);
            if(fm==0){
                boolean flag3=CheckPlayer();
                flagB1=1;//Χρησιμοποιειται για να μην μπει στο max του bot,οταν ο παικτης ξεκιναει πρωτος.
                flagB2=1;
                ui.PlayerTurn();
                DisTilesP();
                while(flag3){               
                    int left=ui.GiveFirstTile();
                    int right=ui.GiveSecTile();
                    Tiles tileP =  new Tiles(left,right);
                    Tiles cloneTile = new Tiles(right,left);
                    int j=0;
                    for (Tiles arrayP1 : arrayP) {
                        if((tileP.getLeft()==arrayP[j].getLeft())&&(tileP.getRight()==arrayP[j].getRight())){  
                            if(flagP==0){
                                DominoLine.add(tileP);
                                sump++;//Μετραει τα πλακιδια ετσι ωστε οταν γινουν 12 να γνωριζει οτι ο παικτης τοποθετησε ολα τα πλακιδια του.
                                DispDominoLine();
                                FakeTile(j,0);     
                                flagP++;
                            }else if((tileP.getLeft()==DominoLine.getLast().getRight()) && (tileP.getRight()==DominoLine.getFirst().getLeft())){
                                 TilePlacement(tileP,0,j);
                                 sumb1++;                    
                            }else if((tileP.getLeft()==DominoLine.getFirst().getLeft()) && (tileP.getRight()==DominoLine.getLast().getRight())){
                                 TilePlacement(cloneTile,1,j);
                                 sumb1++;  

                            }else if(tileP.getLeft()==DominoLine.getLast().getRight()){
                                DominoLine.addLast(tileP);
                                sump++;
                                DispDominoLine();
                                FakeTile(j,0);
                            }else if(tileP.getRight()== DominoLine.getFirst().getLeft()){
                                DominoLine.addFirst(tileP);
                                sump++;
                                FakeTile(j,0);
                                DispDominoLine();
                            }else if(tileP.getLeft()== DominoLine.getFirst().getLeft()){
                                DominoLine.addFirst(cloneTile);
                                sump++;
                                FakeTile(j,0);
                                DispDominoLine();
                            }else if(tileP.getRight()==DominoLine.getLast().getRight()){
                                DominoLine.addLast(cloneTile);
                                sump++;
                                FakeTile(j,0);
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
          fm=1;
        }else if(fm==1){
            flagP=1;////Χρησιμοποιειται για να μην μπει στο max του παικτη,οταν το bot ξεκιναει πρωτο.
            flagB2=1;
            ui.BotTurn();
            DisTilesB1();     
            do{
                if(flagB1==0){         
                    flagB1=AddMaxBot(flagB1); 
                    sumb1++;
                }else{ 
                    
                    flagB1=1;
                    sumb1=Bot1Turn(sumb1);
                    fm=2;   
                    ui.EmptySpace();
                    DisTilesB1();
                    DispDominoLine();

                    }
                }while(fm!=2);
            
        }else if(fm==2){
            flagP=1;////Χρησιμοποιειται για να μην μπει στο max του παικτη,οταν το bot ξεκιναει πρωτο.
            flagB1=1;
            ui.Bot2Turn();
            DisTilesB2();
            do{
                if(flagB2==0){         
                    flagB2=AddMaxBot(flagB2); 
                    sumb2++;
                }else{ 
                    flagB2=1;
                    sumb2=Bot2Turn(sumb2);
                    fm=0;   
                    ui.EmptySpace();
                    DisTilesB2();
                    DispDominoLine();
                    }
                }while(fm!=0);     
        }
            
    }
        if(sump==8 || ((CheckBot1()==false || CheckBot2()==false)&& (CheckPlayer()==true))){
            pointsplayer +=BotPoints(arrayB1) + BotPoints(arrayB2);//Δινω τους ποντους που εχουν απομεινει απο το bot.
        }else if(sumb1==8 || ((CheckBot1()==true )&& (CheckPlayer()==false || CheckBot2()==false))){      
            pointsbot1 += PlayerPoints(arrayP) + BotPoints(arrayB2);//Δινω τους ποντους που εχουν απομεινει απο τον παικτη.
        }else if(sumb2==8 || ((CheckBot2()==true)&&(CheckPlayer()==false || CheckBot1()==false))){      
            pointsbot2 += PlayerPoints(arrayP) + BotPoints(arrayB1);//Δινω τους ποντους που εχουν απομεινει απο τον παικτη.
        }else if(CheckBot1()==false && CheckPlayer()==false && CheckBot2()==false){
            
            sumpoints=(BotPoints(arrayB1)+BotPoints(arrayB2)+PlayerPoints(arrayP))/3;
            pointsplayer +=sumpoints;
            pointsbot1+=sumpoints;
            pointsbot2+=sumpoints;
        } 
    }
}
    
public int FindMax(Tiles maxB1,Tiles maxP,Tiles maxB2){
     if (maxP.getLeft()>maxB1.getLeft() && maxP.getRight()>maxB1.getRight() && maxP.getLeft()>maxB2.getLeft() && maxP.getRight()>maxB2.getRight()){
            turn=0;
            }
    if (maxB1.getLeft()>maxB2.getLeft() && maxB1.getRight()>maxB2.getRight() && maxB1.getLeft()>maxP.getLeft() && maxB1.getRight()>maxP.getRight()){
            turn=1;
            } 
    if (maxB2.getLeft()>maxB1.getLeft() && maxB2.getRight()>maxB1.getRight() && maxB2.getLeft()>maxP.getLeft() && maxB2.getRight()>maxP.getRight()){
            turn=2;
            } 
    return turn;
}
    /*
     Η μεθοδος αυτη εμφανιζει τη λιστα που περιεχει τα πλακιδια που εχουν παιχτει.
     */    
     public void DispDominoLine(){
        UserInterface ui = new UserInterface();
        //ui.DominoLine();
        int left,right;
        for (int i=0;i<DominoLine.size();i++){  
           
            Tiles y = DominoLine.get(i);
            //ui.DisplayList(y);
            left = y.getLeft();
            right = y.getRight();
            mystring3 += Integer.toString(left)+"|"+Integer.toString(right)+" "; 
        }
       // ui.EmptySpace();
       HungarianGui2 t = new HungarianGui2();
        t.output(mystring1,mystring4, mystring2, mystring3);
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
     Στη μεθοδο αυτη γινεται η αντικατασταση επιλεγμενων πλακιδιων ειτε απο τον παικτη ειτε απο το bot , με ενα πλακιδιο που
     περιεχει ακραιες τιμες .
     */
     public void FakeTile(int pos,int Turn){
         Tiles Dont= new Tiles(-1,-1);
         if(Turn==0){  
            arrayP[pos]=Dont;
         }else if(Turn==1){     
            arrayB1[pos]=Dont;
         }else if(Turn==2){
            arrayB2[pos]=Dont;
         }
     }
     
     public boolean CheckBot1(){
       boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayB1.length;i++){
                if(arrayB1[i].getLeft()==DominoLine.getFirst().getLeft() || arrayB1[i].getRight()==DominoLine.getFirst().getLeft()){
                    
                    flag=true;
                    
                }else if(arrayB1[i].getLeft()==DominoLine.getLast().getRight() || arrayB1[i].getRight()==DominoLine.getLast().getRight()){
                    
                    flag=true;
                }
            }
        }
        return flag; 
        
    }
     public boolean CheckBot2(){
       boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayB2.length;i++){
                if(arrayB2[i].getLeft()==DominoLine.getFirst().getLeft() || arrayB2[i].getRight()==DominoLine.getFirst().getLeft()){
                    
                    flag=true;
                    
                }else if(arrayB2[i].getLeft()==DominoLine.getLast().getRight() || arrayB2[i].getRight()==DominoLine.getLast().getRight()){
                    
                    flag=true;
                }
            }
        }
        return flag; 
        
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
                                FakeTile(j,0);
                            }else{
                                DominoLine.add(tileP);      
                                DispDominoLine();
                                FakeTile(j,0);
                            }
        }else{
            int cho=ui.Choice2();
                            if(cho==0){
                                DominoLine.addFirst(tileP);
                                
                                DispDominoLine();
                                FakeTile(j,0); 
                            }else{
                                DominoLine.add(tileP);
                                
                                DispDominoLine();
                                FakeTile(j,0);
                            }
        }
        
     }
     /*
    Η μεθοδος αυτη προσθετει το μεγαλυτερο στοιχειο του bot στη λιστα εφοσον ξεκιναει πρωτο.
    */
     public int AddMaxBot(int flag2){
        int index=0;
        DominoLine.addFirst(maxB1);
        //DispDominoLine();
        for(int i=0;i<arrayB1.length;i++){
            if(maxB1.getLeft()==arrayB1[i].getLeft() && maxB1.getRight()==arrayB1[i].getRight()){
                index=i; //Βρισει τη θεση του μεγαλυτερου πλακιδιου του bot.
            }   
        }
        FakeTile(index,0);//Εδω γινεται η αντικατασταση του μεγαλυτερου στοιχειου με ενα faketile.
        flag2=1; 
        return flag2;            
     }
      /*
     Η μεθοδος αυτη αποτελειται απο συνθηκες και εντολες ωστε να πραγματοποιειται σωστα ο γυρος του bot.
     */
     public int Bot1Turn(int sumb){
         int j=0;
         do{
            if(arrayB1[j].getLeft()==DominoLine.getLast().getRight()){
                int left=arrayB1[j].getLeft();
                int right=arrayB1[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                sumb++;
                FakeTile(j,1);
                j=-1;//Για να ελεγχει απο την αρχη τα στοιχεια του πινακα .
              
            }else if(arrayB1[j].getRight()== DominoLine.getFirst().getLeft()){
                int left=arrayB1[j].getLeft();
                int right=arrayB1[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addFirst(tileB);
                sumb++;
                FakeTile(j,1);
                j=-1;
            }else if(arrayB1[j].getLeft()== DominoLine.getFirst().getLeft()){
                                int left=arrayB1[j].getLeft();
                                int right=arrayB1[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addFirst(tileB);
                                sumb++;
                                FakeTile(j,1);
                                j=-1;
                            }else if(arrayB1[j].getRight()==DominoLine.getLast().getRight()){
                                int left=arrayB1[j].getLeft();
                                int right=arrayB1[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addLast(tileB);
                                sumb++;
                                FakeTile(j,1); 
                                j=-1;
                            } 
                        j++;  
                    }while(j<7);
         return sumb;
     }
     public int Bot2Turn(int sumb){
         int j=0;
         do{
            if(arrayB2[j].getLeft()==DominoLine.getLast().getRight()){
                                int left=arrayB2[j].getLeft();
                                int right=arrayB2[j].getRight();
                                Tiles tileB = new Tiles(left,right);
                                DominoLine.addLast(tileB); 
                                sumb++;
                                FakeTile(j,2);
                                j=-1;//Για να ελεγχει απο την αρχη τα στοιχεια του πινακα .
                            }else if(arrayB2[j].getRight()== DominoLine.getFirst().getLeft()){
                                int left=arrayB2[j].getLeft();
                                int right=arrayB2[j].getRight();
                                Tiles tileB = new Tiles(left,right);
                                DominoLine.addFirst(tileB);
                                sumb++;
                                FakeTile(j,2);
                                j=-1;
                            }else if(arrayB2[j].getLeft()== DominoLine.getFirst().getLeft()){
                                int left=arrayB2[j].getLeft();
                                int right=arrayB2[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addFirst(tileB);
                                sumb++;
                                FakeTile(j,2);
                                j=-1;
                            }else if(arrayB2[j].getRight()==DominoLine.getLast().getRight()){
                                int left=arrayB2[j].getLeft();
                                int right=arrayB2[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addLast(tileB);
                                sumb++;
                                FakeTile(j,2); 
                                j=-1;
                            } 
                        j++;          
                    }while(j<7);
         return sumb;
     }
      /*
    Η μεθοδος αυτη επιστρεφει τους ποντους που εχει μαζεψει το bot.
    */
    public int  BotPoints(Tiles [] arrayB){
        bpoints=0;
        for(int i=0;i<7;i++){
            if(arrayB[i].getLeft()!=-1 && arrayB[i].getRight()!=-1){
                bpoints = bpoints + arrayB[i].getLeft() + arrayB[i].getRight();
            }
            
        }   
        return bpoints;    
    }
    public int  PlayerPoints(Tiles [] arrayP){
        ppoints=0;
        for(int i=0;i<7;i++){
            if(arrayP[i].getLeft()!=-1 && arrayP[i].getRight()!=-1){
                ppoints = ppoints + arrayP[i].getLeft() + arrayP[i].getRight();
            }
            
        }
        return ppoints;
    }  
    
    
    
}
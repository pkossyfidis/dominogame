package ola7;

import solo1.Tiles;
import domino.UserInterface;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author ΠΑΝΑΓΙΩΤΗΣ ΚΟΣΣΥΦΙΔΗΣ
 * @author ΕΛΕΥΘΕΡΙΟΣ ΔΗΜΗΤΡΙΟΥ 2891
 */
    
public class Bots2Ola7 {


    private ArrayList<Tiles> AllTiles;
    public Tiles[] arrayP,arrayB1,arrayB2,stuck;
    LinkedList<Tiles> DominoLine; 
    Tiles maxP = new Tiles(-1,-1) ;
    Tiles maxB1 = new Tiles(-1,-1) ;
    Tiles maxB2 =  new Tiles(-1,-1);
    int  b1points=0,b2points=0;
    int ppoints =0;
    int turn;
    int pointerofStack=0;
    int pointerB1=5,pointerB2=5;
    public Bots2Ola7(){
        AllTiles = new ArrayList<>();
        arrayP = new Tiles[17];
        arrayB1 = new Tiles[17];
        arrayB2=  new Tiles[17];
        stuck = new Tiles[12];
        DominoLine = new LinkedList<>();    
    }
    
    public void SetTiles(){
        for(int i=0;i<=6;i++){
            for(int j=i;j<=6;j++){               
                Tiles x = new Tiles(i,j);
                AllTiles.add(x);
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
        for(int i=0;i<=4;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            arrayP[i]=index;
            AllTiles.remove(z);    
        }
        
        for(int i=0;i<=4;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            arrayB1[i]=index;
            AllTiles.remove(z);
            
        }
        for(int i=0;i<=4;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            arrayB2[i]=index;
            AllTiles.remove(z);
            
        }
        
        for(int i=5;i<=16;i++){
            Tiles x= new Tiles(-1,-1);
            arrayP[i]=x;
            arrayB1[i]=x;
            arrayB2[i]=x;
        }
        for(int i=0;i<=11;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            stuck[i]=index;
            AllTiles.remove(z);
        }
    }
    
     /*
    Η μεθοδος αυτη εμφανιζει τα πλακιδια που εχει στη κατοχη του ο παιχτης.
    */
    public void DisTilesP(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispPlayerTiles();
        for(int i=0;i<=16;i++){
            if(arrayP[i].getLeft()!=DontDisp.getLeft()){
            ui.DispPtiles(arrayP, i);
            }   
        }
        ui.EmptySpace();
    }
    /*
    Η μεθοδος αυτη εμφανιζει τα πλακιδια που εχει στη κατοχη του το bot.
    */
    public void DisTilesB(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispBotTiles();
        for(int i=0;i<=16;i++){
            if(arrayB1[i].getLeft()!=DontDisp.getLeft()){
            ui.DispBtiles(arrayB1,i);
            }
        }  
        ui.EmptySpace();
    }
    public void DisTilesB2(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispBot2Tiles();
        for(int i=0;i<=16;i++){
            if(arrayB2[i].getLeft()!=DontDisp.getLeft()){
            ui.DispBtiles(arrayB2,i);
            }
        }  
        ui.EmptySpace();
    }
     /*
    Η μεθοδος αυτη βρισκει το μεγαλυτερο πλακιδιο που εχει ο παιχτης και το μεγαλυτερο πλακιδιο που εχει το bot.
    */   
    public void MaxTile(){
    int index=0;
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
     /*
    Στη μεθοδο αυτη πραγματοποιουνται ελεγχοι ωστε η εναλλαγη των γυρων και το μετρημα των ποντων να γινεται σωστα και υπαρχουν συθνηκες 
    που βοηθουν στην ομαλη λειτουργια του παιχνιδου οταν ειναι η σειρα του παικτη.
    */
     public void Game2Bots(){
        UserInterface ui = new UserInterface();
        int flagP=0,flagB1=0,flagB2=0;
        int flag1=0,flag2=0;//
        int option=0;//Μπορει να λαβει μονο τιμες 0,1,2 ωστε να ενεργοποιηθει η καταλληλη επιλογη στο userinterface.
        int pointsplayer=0,pointsbot1=0,pointsbot2=0;
        boolean PlayerTurn=false; 
        int tilenump=5,tilenumb1=5,tilenumb2=5;
        while(pointsplayer<100 && pointsbot1<100 && pointsbot2<100){
            int pointer=5;
            pointerB1=5;
            pointerofStack=0;
            tilenump=5;//Αριθμος πλακιδιων παιχτη.
            tilenumb1=5;//Άριθμος πλακιδιων μποτ.
            SetTiles();
            SetPbTiles();
            MaxTile();       
            int fm=FindMax(maxP,maxB1,maxB2);
        while((tilenump!=0 && tilenumb1!=0 && tilenumb2!=0)&& (CheckPlayer() || CheckBot1() || CheckBot2())){ 
            ui.DispBotTiles();
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
                int answer=ui.DoYouWantTile();
                if(pointerofStack==10){
                    ui.NoMoreTiles();
                }
                if(answer==0 && pointerofStack!=10){
                   if(pointerofStack != 1){ 
                        arrayP[pointer]=stuck[pointerofStack];
                        pointer++;
                        pointerofStack++;
                        tilenump++;
                   }
                   DisTilesP();
                }
                int left=ui.GiveFirstTile();
                int right=ui.GiveSecTile();
                Tiles tileP =  new Tiles(left,right);
                Tiles cloneTile = new Tiles(right,left);
                int j=0;
                
                if(tileP.getLeft()+tileP.getRight()==7){
                    int z=0;
                    for(int i=0;i<arrayP.length;i++){
                        if(tileP.getLeft()==arrayP[i].getLeft() && tileP.getRight()==arrayP[i].getRight()){
                            z=i;
                        }
                    }
                   if(flag1==0){
                       flag1++;
                       DominoLine.add(tileP);
                       DispDominoLine();
                       FakeTile(z,1);  
                       tilenump++;
                       tilenump--;
                   }else{
                     int choice=ui.Choice();
                     if(choice==0){
                        DominoLine.addFirst(tileP);
                        tilenump--;
                        FakeTile(z,1);
                        DispDominoLine();
                     }else if(choice==1){
                        DominoLine.addLast(tileP);
                        tilenump--;
                        FakeTile(z,1);
                        DispDominoLine(); 
                     }
                   }
                }
                else{
                    for (Tiles arrayP1 : arrayP) {
                        if((tileP.getLeft()==arrayP[j].getLeft())&&(tileP.getRight()==arrayP[j].getRight())){  
                            if(flag1==0){
                                DominoLine.add(tileP);
                                tilenump--;//Μετραει τα πλακιδια ετσι ωστε οταν γινουν 12 να γνωριζει οτι ο παικτης τοποθετησε ολα τα πλακιδια του.
                                DispDominoLine();
                                FakeTile(j,1);     
                                flag1++;
                            }else if((tileP.getLeft()+DominoLine.getLast().getRight()==7) && (tileP.getRight()+DominoLine.getFirst().getLeft()==7)){
                                 TilePlacement(tileP,0,j);
                                 tilenump--;                   
                            }else if((tileP.getLeft()+DominoLine.getFirst().getLeft()==7) && (tileP.getRight()+DominoLine.getLast().getRight()==7)){
                                 TilePlacement(cloneTile,1,j);
                                 tilenumb1++;  

                            }else if(tileP.getLeft()+DominoLine.getLast().getRight()==7){
                                DominoLine.addLast(tileP);
                                tilenump--;
                                DispDominoLine();
                                FakeTile(j,1);
                            }else if(tileP.getRight()+DominoLine.getFirst().getLeft()==7){
                                DominoLine.addFirst(tileP);
                                tilenump--;
                                FakeTile(j,1);
                                DispDominoLine();
                            }else if(tileP.getLeft()+ DominoLine.getFirst().getLeft()==7){
                                DominoLine.addFirst(cloneTile);
                                tilenump--;
                                FakeTile(j,1);
                                DispDominoLine();
                            }else if(tileP.getRight()+DominoLine.getLast().getRight()==7){
                                DominoLine.addLast(cloneTile);
                                tilenump--;
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
                }   
                DisTilesP();
                flag3=CheckPlayer();
                if(flag3==false){
                    answer=ui.DoYouWantTile();
                   if(answer==0 && pointerofStack!=10){
                   if(pointerofStack != 1){ 
                        arrayP[pointer]=stuck[pointerofStack];
                        pointer++;
                        pointerofStack++;
                        tilenump++;
                   }
                   DisTilesP();
                    }
                }
            fm=1;
        }        
    }else if(fm==1){
            flagB2=1;
            flagP=1;////Χρησιμοποιειται για να μην μπει στο max του παικτη,οταν το bot ξεκιναει πρωτο.
            ui.BotTurn();
            do{              
                if(flagB1==0){         
                    flag2=AddMaxBot(flagB1); 
                    tilenumb1--;
                }else{ 
                    flagB1=1;    
                    tilenumb1+=Bot1Turn(tilenumb1);
                    fm=2;   
                    ui.EmptySpace();
                    DisTilesB();
                    DispDominoLine();
                    }
                }while(fm!=2);
            
    }else if(fm==2){
            flagB1=1;
            flagP=1;////Χρησιμοποιειται για να μην μπει στο max του παικτη,οταν το bot ξεκιναει πρωτο.
            ui.Bot2Turn();
            do{              
                if(flagB2==0){         
                    flag2=AddMaxBot(flagB2); 
                    tilenumb1--;
                }else{ 
                    flagB2=1;    
                    tilenumb1+=Bot2Turn(tilenumb1);
                    fm=0;   
                    ui.EmptySpace();
                    DisTilesB();
                    DispDominoLine();
                    }
                }while(fm!=0); 
            
        }  
        }  
        if(tilenump==0 ){
            pointsplayer += BotPoints(arrayB1); //Δινω τους ποντους που εχουν απομεινει απο το bot.
        }else if(tilenumb1==0){
            pointsbot1 += PlayerPoints(arrayP); 
        } else if(BotPoints(arrayB1)>PlayerPoints(arrayP)){
            pointsplayer += BotPoints(arrayB1)- PlayerPoints(arrayP);  
        }else if(BotPoints(arrayB1)<PlayerPoints(arrayP)){      
            pointsbot1 += PlayerPoints(arrayP)- BotPoints(arrayB1);//Δινω τους ποντους που εχουν απομεινει απο τον παικτη.  
        }else if(BotPoints(arrayB1)==PlayerPoints(arrayP)){
            pointsplayer += BotPoints(arrayB1)- PlayerPoints(arrayP);
            pointsbot1+=PlayerPoints(arrayP)- BotPoints(arrayB1);          
        }
    }
    if(pointsbot1==100){
        option=0;
        ui.Results(option);
    }else if(pointsplayer==100){
        option=1;
        ui.Results(option);
    }else{
        option=2;
        ui.Results(option);
    }
        
       
}
      /*
     Η μεθοδος αυτη εμφανιζει τη λιστα που περιεχει τα πλακιδια που εχουν παιχτει.
     */    
     public void DispDominoLine(){
        UserInterface ui = new UserInterface();
        ui.DominoLine();
        for (int i=0;i<DominoLine.size();i++){  
           
            Tiles y = DominoLine.get(i);
            ui.DisplayList(y);
            
        }
        System.out.println(" ");
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
     Η μεθοδος αυτη ελεγχει αν καποιο απο τα πλακιδια που εχει στη κατοχη του ο παικτης μπορει να προσθεθει στη λιστα.
     */ 
    public boolean CheckPlayer(){
        boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayP.length;i++){
                if(arrayP[i].getLeft()+DominoLine.getFirst().getLeft()==7 || arrayP[i].getRight()+DominoLine.getFirst().getLeft()==7){
                    
                    flag=true;
                    
                }else if(arrayP[i].getLeft()+DominoLine.getLast().getRight()==7 || arrayP[i].getRight()+DominoLine.getLast().getRight()==7){
                    
                    flag=true;
                    
                }else if(arrayP[i].getLeft()+arrayP[i].getRight()==7){
                    flag=true;
                }
            }
        }
        return flag;
    }
    
    /*
     Η μεθοδος αυτη ελεγχει αν καποιο απο τα πλακιδια που εχει στη κατοχη το μποτ  μπορει να προσθεθει στη λιστα.
     */ 
    public boolean CheckBot1(){
       boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayB1.length;i++){
                if(arrayB1[i].getLeft()+DominoLine.getFirst().getLeft()==7 || arrayB1[i].getRight()+DominoLine.getFirst().getLeft()==7){
                    
                    flag=true;
                    
                }else if(arrayB1[i].getLeft()+DominoLine.getLast().getRight()==7 || arrayB1[i].getRight()+DominoLine.getLast().getRight()==7){
                    
                    flag=true;
                }else if(arrayB1[i].getLeft()+arrayB1[i].getRight()==7){
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
                if(arrayB2[i].getLeft()+DominoLine.getFirst().getLeft()==7 || arrayB2[i].getRight()+DominoLine.getFirst().getLeft()==7){
                    
                    flag=true;
                    
                }else if(arrayB2[i].getLeft()+DominoLine.getLast().getRight()==7 || arrayB2[i].getRight()+DominoLine.getLast().getRight()==7){
                    
                    flag=true;
                }else if(arrayB2[i].getLeft()+arrayB2[i].getRight()==7){
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
        
        for(int i=0;i<12;i++){
            if(arrayB[i].getLeft()!=-1 && arrayB[i].getRight()!=-1){
                b1points = b1points + arrayB[i].getLeft() + arrayB[i].getRight();
            }
            
        }
        
        return b1points;    
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
     Στη μεθοδο αυτη γινεται η αντικατασταση επιλεγμενων πλακιδιων ειτε απο τον παικτη ειτε απο το bot , με ενα πλακιδιο που
     περιεχει ακραιες τιμες .
     */
     public void FakeTile(int pos,int Turn){
         Tiles Dont= new Tiles(-1,-1);
         if(Turn==1){
         arrayP[pos]=Dont;
         }else{
             
         arrayB1[pos]=Dont;
         }
     }
     /*
     Η μεθοδος αυτη αποτελειται απο συνθηκες και εντολες ωστε να πραγματοποιειται σωστα ο γυρος του bot.
     */
     public int Bot1Turn(int tilenumb){
         int j=0;
         do{     
            if(arrayB1[j].getLeft()+DominoLine.getLast().getRight()==7){
                int left=arrayB1[j].getLeft();
                int right=arrayB1[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;//Για να ελεγχει απο την αρχη τα στοιχεια του πινακα .
            }else if(arrayB1[j].getRight()+DominoLine.getFirst().getLeft()==7){
                int left=arrayB1[j].getLeft();
                int right=arrayB1[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB1[j].getLeft()+ DominoLine.getFirst().getLeft()==7){
                int left=arrayB1[j].getLeft();
                int right=arrayB1[j].getRight();
                Tiles tileB = new Tiles(right,left);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB1[j].getRight()+DominoLine.getLast().getRight()==7){
                int left=arrayB1[j].getLeft();
                                int right=arrayB1[j].getRight();
                Tiles tileB = new Tiles(right,left);
                 DominoLine.addLast(tileB);
                tilenumb--;
                FakeTile(j,0); 
                j=-1;
            }
            else if(arrayB1[j].getLeft()+arrayB1[j].getRight()==7){
                int left=arrayB1[j].getLeft();
                int right=arrayB1[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }
            j++;
            if(j==4 && pointerofStack!=10){
                   arrayB1[pointerB1]=stuck[pointerofStack];
                   pointerB1++;
                   pointerofStack++;
                   DisTilesP();
                   tilenumb++;
            }
            }while(j<=4);
         return tilenumb;
     }
     public int Bot2Turn(int tilenumb){
         int j=0;
         do{     
            if(arrayB2[j].getLeft()+DominoLine.getLast().getRight()==7){
                int left=arrayB2[j].getLeft();
                int right=arrayB2[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;//Για να ελεγχει απο την αρχη τα στοιχεια του πινακα .
            }else if(arrayB2[j].getRight()+DominoLine.getFirst().getLeft()==7){
                int left=arrayB2[j].getLeft();
                int right=arrayB2[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB2[j].getLeft()+ DominoLine.getFirst().getLeft()==7){
                int left=arrayB2[j].getLeft();
                int right=arrayB2[j].getRight();
                Tiles tileB = new Tiles(right,left);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB2[j].getRight()+DominoLine.getLast().getRight()==7){
                int left=arrayB2[j].getLeft();
                int right=arrayB2[j].getRight();
                Tiles tileB = new Tiles(right,left);
                 DominoLine.addLast(tileB);
                tilenumb--;
                FakeTile(j,0); 
                j=-1;
            }
            else if(arrayB2[j].getLeft()+arrayB2[j].getRight()==7){
                int left=arrayB2[j].getLeft();
                int right=arrayB2[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }
            j++;
            if(j==4 && pointerofStack!=10){
                   arrayB2[pointerB2]=stuck[pointerofStack];
                   pointerB2++;
                   pointerofStack++;
                   DisTilesP();
                   tilenumb++;
            }
            }while(j<=4);
         return tilenumb;
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
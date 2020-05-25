package ola7;
import solo1.Tiles;
import domino.UserInterface;
import solo1.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;
/**
 *
 * @author ΠΑΝΑΓΙΩΤΗΣ ΚΟΣΣΥΦΙΔΗΣ
 * @author ΕΛΕΥΘΕΡΙΟΣ ΔΗΜΗΤΡΙΟΥ 2891
 */
public class MainGame {
    
    private ArrayList<Tiles> AllTiles;
    public Tiles[] arrayP,arrayB,stuck;
    LinkedList<Tiles> DominoLine; 
    Tiles maxP = new Tiles(-1,-1) ;
    Tiles maxB = new Tiles(-1,-1) ;  
    int  bpoints=0;
    int ppoints =0;
    int pointerofStack=0;
    int pointerB=7;
    public MainGame(){
        AllTiles = new ArrayList<>();
        arrayP = new Tiles[21];
        arrayB = new Tiles[21];
        stuck = new Tiles[14];
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
        for(int i=0;i<=6;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            arrayP[i]=index;
            AllTiles.remove(z);    
        }
        
        for(int i=0;i<=6;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            arrayB[i]=index;
            AllTiles.remove(z);
            
        }
        for(int i=7;i<=20;i++){
            Tiles x= new Tiles(-1,-1);
            arrayP[i]=x;
            arrayB[i]=x;
        }
        for(int i=0;i<=13;i++){
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
        for(int i=0;i<=20;i++){
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
        for(int i=0;i<=20;i++){
            if(arrayB[i].getLeft()!=DontDisp.getLeft()){
            ui.DispBtiles(arrayB,i);
            }
        }  
        ui.EmptySpace();
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
     public void GameOla7(){
        UserInterface ui = new UserInterface();
        int flag1=0,flag2=0;//
        int option=0;//Μπορει να λαβει μονο τιμες 0,1,2 ωστε να ενεργοποιηθει η καταλληλη επιλογη στο userinterface.
        int pointsplayer=0,pointsbot=0;
        boolean PlayerTurn=false; 
        int tilenump=7,tilenumb=7;
        while(pointsplayer<100 && pointsbot<100){
            int pointer=7;
            pointerB=7;
            pointerofStack=0;
            tilenump=7;//Αριθμος πλακιδιων παιχτη.
            tilenumb=7;//Άριθμος πλακιδιων μποτ.
            SetTiles();
            SetPbTiles();
            MaxTile();       
            if (maxP.getLeft()>maxB.getLeft() && maxP.getRight()>maxB.getRight()){
            PlayerTurn=true;
            }
        while((tilenump!=0 && tilenumb!=0)&& (CheckPlayer() || CheckBot())){ 
            ui.DispBotTiles();
            ui.DispPointsP(pointsplayer);
            ui.DispPointsB(pointsbot);
        if(PlayerTurn==true){
            boolean flag3=CheckPlayer();
            flag2=1;//Χρησιμοποιειται για να μην μπει στο max του bot,οταν ο παικτης ξεκιναει πρωτος.
            ui.PlayerTurn();
            DisTilesP();
            while(flag3){
                int answer=ui.DoYouWantTile();
                if(pointerofStack==12){
                    ui.NoMoreTiles();
                }
                if(answer==0 && pointerofStack!=12){
                   if(pointerofStack != 1){ 
                        arrayP[pointer]=stuck[pointerofStack];
                        pointer++;
                        pointerofStack--;
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
                                 tilenumb++;  

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
                        if(answer==0 && pointerofStack!=12){
                            if(pointerofStack != 1){ 
                                arrayP[pointer]=stuck[pointerofStack];
                                pointer++;
                                pointerofStack--;
                                tilenump++;
                            }
                         DisTilesP();
                        }
                }
          } 
            PlayerTurn=false;
        }else{
            flag1=1;////Χρησιμοποιειται για να μην μπει στο max του παικτη,οταν το bot ξεκιναει πρωτο.
            ui.BotTurn();
            do{              
                if(flag2==0){         
                    flag2=AddMaxBot(flag2); 
                    tilenumb--;
                }else{ 
                    flag2=1;    
                    tilenumb+=BotTurn(tilenumb);
                    PlayerTurn=true;   
                    ui.EmptySpace();
                    DisTilesB();
                    DispDominoLine();
                    }
                }while(PlayerTurn!=true);     
        }  
        }  
        if(tilenump==0 ){
            pointsplayer += BotPoints(arrayB); //Δινω τους ποντους που εχουν απομεινει απο το bot.
        }else if(tilenumb==0){
            pointsbot += PlayerPoints(arrayP); 
        } else if(BotPoints(arrayB)>PlayerPoints(arrayP)){
            pointsplayer += BotPoints(arrayB)- PlayerPoints(arrayP);  
        }else if(BotPoints(arrayB)<PlayerPoints(arrayP)){      
            pointsbot += PlayerPoints(arrayP)- BotPoints(arrayB);//Δινω τους ποντους που εχουν απομεινει απο τον παικτη.  
        }else if(BotPoints(arrayB)==PlayerPoints(arrayP)){
            pointsplayer += BotPoints(arrayB)- PlayerPoints(arrayP);
            pointsbot+=PlayerPoints(arrayP)- BotPoints(arrayB);          
        }
    }
    if(pointsbot==100){
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
    public boolean CheckBot(){
       boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayB.length;i++){
                if(arrayB[i].getLeft()+DominoLine.getFirst().getLeft()==7 || arrayB[i].getRight()+DominoLine.getFirst().getLeft()==7){
                    
                    flag=true;
                    
                }else if(arrayB[i].getLeft()+DominoLine.getLast().getRight()==7 || arrayB[i].getRight()+DominoLine.getLast().getRight()==7){
                    
                    flag=true;
                }else if(arrayB[i].getLeft()+arrayB[i].getRight()==7){
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
     public int BotTurn(int tilenumb){
         int j=0;
         do{     
            if(arrayB[j].getLeft()+DominoLine.getLast().getRight()==7){
                int left=arrayB[j].getLeft();
                int right=arrayB[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;//Για να ελεγχει απο την αρχη τα στοιχεια του πινακα .
            }else if(arrayB[j].getRight()+DominoLine.getFirst().getLeft()==7){
                int left=arrayB[j].getLeft();
                int right=arrayB[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB[j].getLeft()+ DominoLine.getFirst().getLeft()==7){
                int left=arrayB[j].getLeft();
                int right=arrayB[j].getRight();
                Tiles tileB = new Tiles(right,left);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB[j].getRight()+DominoLine.getLast().getRight()==7){
                int left=arrayB[j].getLeft();
                                int right=arrayB[j].getRight();
                Tiles tileB = new Tiles(right,left);
                 DominoLine.addLast(tileB);
                tilenumb--;
                FakeTile(j,0); 
                j=-1;
            }
            else if(arrayB[j].getLeft()+arrayB[j].getRight()==7){
                int left=arrayB[j].getLeft();
                int right=arrayB[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }
            j++;
            if(j==6 && pointerofStack!=12){
                   arrayB[pointerB]=stuck[pointerofStack];
                   pointerB++;
                   pointerofStack++;
                   DisTilesP();
                   tilenumb++;
            }
            }while(j<=6);
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
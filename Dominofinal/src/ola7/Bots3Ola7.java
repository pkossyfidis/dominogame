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
    
public class Bots3Ola7 {


    private ArrayList<Tiles> AllTiles;
    public Tiles[] arrayP,arrayB1,arrayB2,arrayB3,stuck;
    LinkedList<Tiles> DominoLine; 
    Tiles maxP = new Tiles(-1,-1) ;
    Tiles maxB1 = new Tiles(-1,-1) ;
    Tiles maxB2 =  new Tiles(-1,-1);
    Tiles maxB3 =  new Tiles(-1,-1);
    int  b1points=0,b2points=0,b3points=0;
    int ppoints =0;
    int turn;
    int pointerofStack=0;
    int pointerB1=5,pointerB2=5,pointerB3;
    public Bots3Ola7(){
        AllTiles = new ArrayList<>();
        arrayP = new Tiles[10];
        arrayB1 = new Tiles[10];
        arrayB2=  new Tiles[10];
        arrayB3 = new Tiles[10];
        stuck = new Tiles[7];
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
    Ç ìåèïäïò áõôç ìå ôç ÷ñçóç ôçò óõíáñôçóçò random ìïéñáæåé ôõ÷áéá ôá ðëáêéäéá, áñ÷éêá óôïí ðéíáêá ðïõ áíôéðñïóùðåõåé ôá tiles ôïõ ðáé÷ôç 
    êáé óôç óõíå÷åéá ìå ôïí éäéï ôñïðï ôá tiles ôïõ bot.
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
        for(int i=0;i<=4;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            arrayB3[i]=index;
            AllTiles.remove(z);
            
        }
        
        for(int i=5;i<=9;i++){
            Tiles x= new Tiles(-1,-1);
            arrayP[i]=x;
            arrayB1[i]=x;
            arrayB2[i]=x;
            arrayB3[i]=x;
        }
        for(int i=0;i<=6;i++){
            z=RandTile.nextInt(AllTiles.size());
            Tiles index =AllTiles.get(z);
            stuck[i]=index;
            AllTiles.remove(z);
        }
    }
    
     /*
    Ç ìåèïäïò áõôç åìöáíéæåé ôá ðëáêéäéá ðïõ å÷åé óôç êáôï÷ç ôïõ ï ðáé÷ôçò.
    */
    public void DisTilesP(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispPlayerTiles();
        for(int i=0;i<=9;i++){
            if(arrayP[i].getLeft()!=DontDisp.getLeft()){
            ui.DispPtiles(arrayP, i);
            }   
        }
        ui.EmptySpace();
    }
    /*
    Ç ìåèïäïò áõôç åìöáíéæåé ôá ðëáêéäéá ðïõ å÷åé óôç êáôï÷ç ôïõ ôï bot.
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
    public void DisTilesB3(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispBot3Tiles();
        for(int i=0;i<=16;i++){
            if(arrayB3[i].getLeft()!=DontDisp.getLeft()){
            ui.DispBtiles(arrayB3,i);
            }
        }  
        ui.EmptySpace();
    }
     /*
    Ç ìåèïäïò áõôç âñéóêåé ôï ìåãáëõôåñï ðëáêéäéï ðïõ å÷åé ï ðáé÷ôçò êáé ôï ìåãáëõôåñï ðëáêéäéï ðïõ å÷åé ôï bot.
    */   
    public void MaxTile(){
    int index=0;
        for (int i = 0; i < arrayB1.length; i++) {
            if((arrayP[i].getLeft()>maxP.getLeft() && arrayP[i].getRight()>maxP.getRight()) ){
                
                int side1 = arrayP[i].getLeft();
                int side2 = arrayP[i].getRight();
                maxP = new Tiles(side1,side2);    
            }
            
            if((arrayB1[i].getLeft()>maxB1.getLeft() && arrayB1[i].getRight()>maxB1.getRight())  ){
                
                int side3 = arrayB1[i].getLeft();
                int side4 = arrayB1[i].getRight();
                maxB1 = new Tiles(side3,side4);  
                
            } 
            if((arrayB2[i].getLeft()>maxB2.getLeft() && arrayB2[i].getRight()>maxB2.getRight())  ){
                
                int side3 = arrayB2[i].getLeft();
                int side4 = arrayB2[i].getRight();
                maxB2 = new Tiles(side3,side4);  
                
            }
            if((arrayB3[i].getLeft()>maxB3.getLeft() && arrayB3[i].getRight()>maxB3.getRight()) ){
                
                int side3 = arrayB3[i].getLeft();
                int side4 = arrayB3[i].getRight();
                maxB3 = new Tiles(side3,side4);
            }
        }

    }
     /*
    Óôç ìåèïäï áõôç ðñáãìáôïðïéïõíôáé åëåã÷ïé ùóôå ç åíáëëáãç ôùí ãõñùí êáé ôï ìåôñçìá ôùí ðïíôùí íá ãéíåôáé óùóôá êáé õðáñ÷ïõí óõèíçêåò 
    ðïõ âïçèïõí óôçí ïìáëç ëåéôïõñãéá ôïõ ðáé÷íéäïõ ïôáí åéíáé ç óåéñá ôïõ ðáéêôç.
    */
     public void Game2Bots(){
        UserInterface ui = new UserInterface();
        int flagP=0,flagB1=0,flagB2=0,flagB3=0;
        int flag1=0,flag2=0,flag4=0;//
        int option=0;//Ìðïñåé íá ëáâåé ìïíï ôéìåò 0,1,2 ùóôå íá åíåñãïðïéçèåé ç êáôáëëçëç åðéëïãç óôï userinterface.
        int pointsplayer=0,pointsbot1=0,pointsbot2=0,pointsbot3=0;
        boolean PlayerTurn=false; 
        int tilenump=5,tilenumb1=5,tilenumb2=5,tilenumb3;
        while(pointsplayer<100 && pointsbot1<100 && pointsbot2<100 && pointsbot3<100){
            int pointer=5;
            pointerB1=5;
            pointerB2=5;
            pointerB3=5;//-------------------------------------------------------------------------------------->
            pointerofStack=0;
            tilenump=5;//Áñéèìïò ðëáêéäéùí ðáé÷ôç.
            tilenumb1=5;//¢ñéèìïò ðëáêéäéùí ìðïô.
            tilenumb2=5;
            tilenumb3=5;
            SetTiles();
            SetPbTiles();
            MaxTile();       
            int fm=FindMax(maxP,maxB1,maxB2,maxB3);
        while((tilenump!=0 && tilenumb1!=0 && tilenumb2!=0 && tilenumb3!=0)&& (CheckPlayer() || CheckBot1() || CheckBot2() || CheckBot3())){ 
            ui.DispBotTiles();
            ui.DispPointsP(pointsplayer);
            ui.DispPointsB(pointsbot1);
            ui.DispPointsB2(pointsbot2);
            ui.DispPointsB3(pointsbot3);
        if(fm==0){
            boolean flag3=CheckPlayer();
            flagB1=1;//×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ bot,ïôáí ï ðáéêôçò îåêéíáåé ðñùôïò.
            flagB2=1;
            flagB3=1;
            ui.PlayerTurn();
            DisTilesP();
            while(flag3){
                int answer=ui.DoYouWantTile();
                if(pointerofStack==10){
                    ui.NoMoreTiles();
                }
                if(answer==0 && pointerofStack!=5){
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
                                tilenump--;//Ìåôñáåé ôá ðëáêéäéá åôóé ùóôå ïôáí ãéíïõí 12 íá ãíùñéæåé ïôé ï ðáéêôçò ôïðïèåôçóå ïëá ôá ðëáêéäéá ôïõ.
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
                   if(answer==0 && pointerofStack!=5){
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
            flagP=1;////×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ ðáéêôç,ïôáí ôï bot îåêéíáåé ðñùôï.
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
            flagB3=1;
            flagP=1;////×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ ðáéêôç,ïôáí ôï bot îåêéíáåé ðñùôï.
            ui.Bot2Turn();
            do{              
                if(flagB2==0){         
                    flag2=AddMaxBot(flagB2); 
                    tilenumb2--;
                }else{ 
                    flagB2=1;    
                    tilenumb2+=Bot2Turn(tilenumb2);
                    fm=3;   
                    ui.EmptySpace();
                    DisTilesB();
                    DispDominoLine();
                    }
                }while(fm!=3); 
            
        }else if(fm==3){
            flagB1=1;
            flagP=1;////×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ ðáéêôç,ïôáí ôï bot îåêéíáåé ðñùôï.
            ui.Bot2Turn();
            do{              
                if(flagB3==0){         
                    flag4=AddMaxBot(flagB3); 
                    tilenumb3--;
                }else{ 
                    flagB3=1;    
                    tilenumb3+=Bot3Turn(tilenumb3);
                    fm=0;   
                    ui.EmptySpace();
                    DisTilesB();
                    DispDominoLine();
                    }
                }while(fm!=0); 
        }
        
        
        }  
        if(tilenump==0 ){
            pointsplayer += BotPoints(arrayB1) + BotPoints(arrayB2) + BotPoints(arrayB3); //Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôï bot.
        }else if(tilenumb1==0){
            pointsbot1 += PlayerPoints(arrayP) + BotPoints(arrayB2) + BotPoints(arrayB3); 
        }else if(tilenumb2==0){
            pointsbot2 += PlayerPoints(arrayP) + BotPoints(arrayB1) + BotPoints(arrayB3);
        }else if(tilenumb3==0){
            pointsbot3 += PlayerPoints(arrayP) + BotPoints(arrayB1) + BotPoints(arrayB2);
        }else if(BotPoints(arrayB1)>PlayerPoints(arrayP) && PlayerPoints(arrayP)< BotPoints(arrayB2) && PlayerPoints(arrayP)< BotPoints(arrayB3)){
            pointsplayer += (BotPoints(arrayB1) + BotPoints(arrayB2) + BotPoints(arrayB3))- PlayerPoints(arrayP);  
        }else if(BotPoints(arrayB1)<PlayerPoints(arrayP) && BotPoints(arrayB1)< BotPoints(arrayB2) && BotPoints(arrayB1)< BotPoints(arrayB3)){      
            pointsbot1 += (PlayerPoints(arrayP) + BotPoints(arrayB2) + BotPoints(arrayB3))- BotPoints(arrayB1);//Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôïí ðáéêôç.  
        }else if(BotPoints(arrayB2)<PlayerPoints(arrayP) && BotPoints(arrayB2)< BotPoints(arrayB3) && BotPoints(arrayB2)< BotPoints(arrayB1)){      
            pointsbot1 += (PlayerPoints(arrayP) + BotPoints(arrayB1) + BotPoints(arrayB3))- BotPoints(arrayB2);//Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôïí ðáéêôç.  
        }else if(BotPoints(arrayB3)<PlayerPoints(arrayP) && BotPoints(arrayB3)< BotPoints(arrayB2) && BotPoints(arrayB3)< BotPoints(arrayB1)){      
            pointsbot1 += (PlayerPoints(arrayP) + BotPoints(arrayB2) + BotPoints(arrayB1))- BotPoints(arrayB3);//Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôïí ðáéêôç.  
        }else if((BotPoints(arrayB1)==PlayerPoints(arrayP))==(BotPoints(arrayB2)==BotPoints(arrayB3))){
            int allpoints=0;
            allpoints = (PlayerPoints(arrayP) + BotPoints(arrayB1) + BotPoints(arrayB2) + BotPoints(arrayB3))/4;
            pointsplayer += allpoints;
            pointsbot1 += allpoints;
            pointsbot2 += allpoints;
            pointsbot3 += allpoints;
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
     Ç ìåèïäïò áõôç åìöáíéæåé ôç ëéóôá ðïõ ðåñéå÷åé ôá ðëáêéäéá ðïõ å÷ïõí ðáé÷ôåé.
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
     
    public int FindMax(Tiles maxB1,Tiles maxP,Tiles maxB2,Tiles maxB3){
        if (maxP.getLeft()>maxB1.getLeft() && maxP.getRight()>maxB1.getRight() && maxP.getLeft()>maxB2.getLeft() && maxP.getRight()>maxB2.getRight() && maxP.getLeft()>maxB3.getLeft() && maxP.getRight()>maxB3.getRight()){
            turn=0;
        }
        if (maxB1.getLeft()>maxB2.getLeft() && maxB1.getRight()>maxB2.getRight() && maxB1.getLeft()>maxP.getLeft() && maxB1.getRight()>maxP.getRight() && maxB1.getLeft()>maxB3.getLeft() && maxB1.getRight()>maxB3.getRight()){
            turn=1;
        } 
        if (maxB2.getLeft()>maxB1.getLeft() && maxB2.getRight()>maxB1.getRight() && maxB2.getLeft()>maxP.getLeft() && maxB2.getRight()>maxP.getRight() && maxB2.getLeft()>maxB3.getLeft() && maxB2.getRight()>maxB3.getRight()){
            turn=2;
        }
        if (maxB3.getLeft()>maxP.getLeft() && maxB3.getRight()>maxP.getRight() && maxB3.getLeft()>maxB1.getLeft() && maxB3.getRight()>maxB1.getRight() && maxB3.getLeft()>maxB2.getLeft() && maxB3.getRight()>maxB2.getRight()){
            turn =3;
        }
        return turn;
    }
    
    /*
     Ç ìåèïäïò áõôç åëåã÷åé áí êáðïéï áðï ôá ðëáêéäéá ðïõ å÷åé óôç êáôï÷ç ôïõ ï ðáéêôçò ìðïñåé íá ðñïóèåèåé óôç ëéóôá.
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
     Ç ìåèïäïò áõôç åëåã÷åé áí êáðïéï áðï ôá ðëáêéäéá ðïõ å÷åé óôç êáôï÷ç ôï ìðïô  ìðïñåé íá ðñïóèåèåé óôç ëéóôá.
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
    
    public boolean CheckBot3(){
       boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayB3.length;i++){
                if(arrayB3[i].getLeft()+DominoLine.getFirst().getLeft()==7 || arrayB3[i].getRight()+DominoLine.getFirst().getLeft()==7){
                    
                    flag=true;
                    
                }else if(arrayB3[i].getLeft()+DominoLine.getLast().getRight()==7 || arrayB3[i].getRight()+DominoLine.getLast().getRight()==7){
                    
                    flag=true;
                }else if(arrayB3[i].getLeft()+arrayB3[i].getRight()==7){
                    flag=true;
                }
            }
        }
        return flag; 
        
    }
    
    
    
    /*
    Ç ìåèïäïò áõôç åðéóôñåöåé ôïõò ðïíôïõò ðïõ å÷åé ìáæåøåé ï ðáéêôçò.
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
    Ç ìåèïäïò áõôç åðéóôñåöåé ôïõò ðïíôïõò ðïõ å÷åé ìáæåøåé ôï bot.
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
    Ç ìåèïäïò áõôç ðñïóèåôåé ôï ìåãáëõôåñï óôïé÷åéï ôïõ bot óôç ëéóôá åöïóïí îåêéíáåé ðñùôï.
    */
     public int AddMaxBot(int flag2){
        int index=0;
        DominoLine.addFirst(maxB1);
        //DispDominoLine();
        for(int i=0;i<arrayB1.length;i++){
            if(maxB1.getLeft()==arrayB1[i].getLeft() && maxB1.getRight()==arrayB1[i].getRight()){
                index=i; //Âñéóåé ôç èåóç ôïõ ìåãáëõôåñïõ ðëáêéäéïõ ôïõ bot.
            }   
        }
        FakeTile(index,0);//Åäù ãéíåôáé ç áíôéêáôáóôáóç ôïõ ìåãáëõôåñïõ óôïé÷åéïõ ìå åíá faketile.
        flag2=1; 
        return flag2;            
     }
     /*
     Óôç ìåèïäï áõôç ãéíåôáé ç áíôéêáôáóôáóç åðéëåãìåíùí ðëáêéäéùí åéôå áðï ôïí ðáéêôç åéôå áðï ôï bot , ìå åíá ðëáêéäéï ðïõ
     ðåñéå÷åé áêñáéåò ôéìåò .
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
     Ç ìåèïäïò áõôç áðïôåëåéôáé áðï óõíèçêåò êáé åíôïëåò ùóôå íá ðñáãìáôïðïéåéôáé óùóôá ï ãõñïò ôïõ bot.
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
                j=-1;//Ãéá íá åëåã÷åé áðï ôçí áñ÷ç ôá óôïé÷åéá ôïõ ðéíáêá .
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
            if(j==4 && pointerofStack!=5){
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
                j=-1;//Ãéá íá åëåã÷åé áðï ôçí áñ÷ç ôá óôïé÷åéá ôïõ ðéíáêá .
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
            if(j==4 && pointerofStack!=5){
                   arrayB2[pointerB2]=stuck[pointerofStack];
                   pointerB2++;
                   pointerofStack++;
                   DisTilesP();
                   tilenumb++;
            }
            }while(j<=4);
         return tilenumb;
     }
     
     public int Bot3Turn(int tilenumb){
         int j=0;
         do{     
            if(arrayB2[j].getLeft()+DominoLine.getLast().getRight()==7){
                int left=arrayB3[j].getLeft();
                int right=arrayB3[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;//Ãéá íá åëåã÷åé áðï ôçí áñ÷ç ôá óôïé÷åéá ôïõ ðéíáêá .
            }else if(arrayB3[j].getRight()+DominoLine.getFirst().getLeft()==7){
                int left=arrayB3[j].getLeft();
                int right=arrayB3[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB3[j].getLeft()+ DominoLine.getFirst().getLeft()==7){
                int left=arrayB3[j].getLeft();
                int right=arrayB3[j].getRight();
                Tiles tileB = new Tiles(right,left);
                DominoLine.addFirst(tileB);
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }else if(arrayB3[j].getRight()+DominoLine.getLast().getRight()==7){
                int left=arrayB3[j].getLeft();
                int right=arrayB3[j].getRight();
                Tiles tileB = new Tiles(right,left);
                 DominoLine.addLast(tileB);
                tilenumb--;
                FakeTile(j,0); 
                j=-1;
            }
            else if(arrayB3[j].getLeft()+arrayB3[j].getRight()==7){
                int left=arrayB3[j].getLeft();
                int right=arrayB3[j].getRight();
                Tiles tileB = new Tiles(left,right);
                DominoLine.addLast(tileB); 
                tilenumb--;
                FakeTile(j,0);
                j=-1;
            }
            j++;
            if(j==4 && pointerofStack!=5){
                   arrayB3[pointerB3]=stuck[pointerofStack];
                   pointerB3++;
                   pointerofStack++;
                   DisTilesP();
                   tilenumb++;
            }
            }while(j<=4);
         return tilenumb;
     }
     /*
     Ç ìåèïäïò ãéá ôçí åéóáãùãç åíïò ðëáêéäéïõ óôç ëéóôá ïôáí áõôï ìðïñåé íá ôïðïèåôçèåé åéôå óôçí áñ÷ç åéôå óôï ôåëïò ôçò ëéóôáò.
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
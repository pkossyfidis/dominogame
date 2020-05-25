package Hungarian;

import domino.*;
import solo1.Tiles;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;

/**
 *
 * @author Kossyfidis
 */
public class ThreeBots {
    private ArrayList<Tiles> AllTiles3; 
    public Tiles[] arrayP,arrayB1,arrayB2,arrayB3;
    LinkedList<Tiles> DominoLine; 
    int turn;
    String mystring1="Bot 1 Tiles:",mystring2="Bot 2 Tiles:",mystring3="Bot 3 Tiles:",mystring4="Player Tiles:",mystring5="Domino line: ";
    Tiles maxP = new Tiles(-1,-1) ;
    Tiles maxB1 = new Tiles(-1,-1) ;  
    Tiles maxB2 = new Tiles(-1,-1) ;  
    Tiles maxB3 = new Tiles(-1,-1);
    int  bpoints=0;
    int ppoints =0;
    public ThreeBots(){
        AllTiles3 = new ArrayList<>();
        arrayP = new Tiles[6];
        arrayB1 = new Tiles[6];
        arrayB2 = new Tiles[6];
        arrayB3 = new Tiles[6];
        DominoLine = new LinkedList<>();    
    }
    
    
    
    /*
    Ç ìåèïäïò áõôç áñ÷éêïðïéåé ôï óåô ôùí ðëáêéäéùí ÷ñçóéìïðïéùíôáò ôçí êëáóç Tiles.
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
    Ç ìåèïäïò áõôç ìå ôç ÷ñçóç ôçò óõíáñôçóçò random ìïéñáæåé ôõ÷áéá ôá ðëáêéäéá, áñ÷éêá óôïí ðéíáêá ðïõ áíôéðñïóùðåõåé ôá tiles ôïõ ðáé÷ôç 
    êáé óôç óõíå÷åéá ìå ôïí éäéï ôñïðï ôá tiles ôïõ bot.
    */
    public void SetPbTiles(){
        int z;
        Random RandTile =  new Random();
        for(int i=0;i<6;i++){
            z=RandTile.nextInt(AllTiles3.size());
            Tiles index =AllTiles3.get(z);
            arrayP[i]=index;
            AllTiles3.remove(z);
            
        }
        for(int i=0;i<6;i++){
            z=RandTile.nextInt(AllTiles3.size());
            Tiles index =AllTiles3.get(z);
            arrayB1[i]=index;
            AllTiles3.remove(z);
            
        }
        for(int i=0;i<6;i++){
            z=RandTile.nextInt(AllTiles3.size());
            Tiles index =AllTiles3.get(z);
            arrayB2[i]=index;
            AllTiles3.remove(z);
            
        }
        for(int i=0;i<6;i++){
            z=RandTile.nextInt(AllTiles3.size());
            Tiles index =AllTiles3.get(z);
            arrayB3[i]=index;
            AllTiles3.remove(z);
            
        }
        
    }
    /*
    Ç ìåèïäïò áõôç åìöáíéæåé ôá ðëáêéäéá ðïõ å÷åé óôç êáôï÷ç ôïõ ï ðáé÷ôçò.
    */
    public void DisTilesP(){
        Tiles DontDisp =  new Tiles(-1,-1);
        int x=0,y=0;
        for(int i=0;i<=5;i++){
            if(arrayP[i].getLeft()!=DontDisp.getLeft()){
                x = arrayP[i].getLeft();
                y = arrayP[i].getRight();
                mystring4 += Integer.toString(x)+"|"+Integer.toString(y)+" "; 
            }
                
        }
       HungarianGui3 t = new HungarianGui3();
       t.output(mystring1,mystring2,mystring3,mystring4,mystring5);
       t.setVisible(true);
       mystring1="Bot 1 Tiles:\n ";
       mystring2="Bot 2 Tiles: \n";
       mystring3="Bot 3 Tiles: \n";
       mystring4="PlayerTiles: \n";
       mystring5="Dominoline: \n";
       
    }
    /*
    Ç ìåèïäïò áõôç åìöáíéæåé ôá ðëáêéäéá ðïõ å÷åé óôç êáôï÷ç ôïõ ôï bot.
    */
    public void DisTilesB1(){
        Tiles DontDisp =  new Tiles(-1,-1);
        for(int i=0;i<=5;i++){
            if(arrayB1[i].getLeft()!=DontDisp.getLeft()){
                mystring1 += "-|-"+" ";
            }
        }  
       HungarianGui3 t = new HungarianGui3();
       t.output(mystring1,mystring2,mystring3,mystring4,mystring5);
       t.setVisible(true);
       mystring5="Dominoline: \n";
  
    }
     public void DisTilesB2(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispBotTiles();
        for(int i=0;i<=5;i++){
            if(arrayB2[i].getLeft()!=DontDisp.getLeft()){
                mystring2 += "-|-"+" ";
            }
        }  
       HungarianGui3 t = new HungarianGui3();
       t.output(mystring1,mystring2,mystring3,mystring4,mystring5);
       t.setVisible(true);
       mystring5="Dominoline: \n";
    }
      public void DisTilesB3(){
        Tiles DontDisp =  new Tiles(-1,-1);
        UserInterface ui=new UserInterface();
        ui.DispBotTiles();
        for(int i=0;i<=5;i++){
            if(arrayB3[i].getLeft()!=DontDisp.getLeft()){
                mystring3 += "-|-"+" ";
            }
        }  
       HungarianGui3 t = new HungarianGui3();
       t.output(mystring1,mystring2,mystring3,mystring4,mystring5);
       t.setVisible(true);
       mystring5="Dominoline: \n";
    }
     
      /*
    Ç ìåèïäïò áõôç âñéóêåé ôï ìåãáëõôåñï ðëáêéäéï ðïõ å÷åé ï ðáé÷ôçò êáé ôï ìåãáëõôåñï ðëáêéäéï ðïõ å÷åé ôï bot.
    */   
    public void MaxTile(){
    int index=0;
        for (int i=0; i <arrayP.length; i++) {
            if((arrayP[i].getLeft()>maxP.getLeft() && arrayP[i].getRight()>maxP.getRight()) && arrayP[i].getLeft()==arrayP[i].getRight()){
                
                int side1 = arrayP[i].getLeft();
                int side2 = arrayP[i].getRight();
                maxP = new Tiles(side1,side2);    
            }
            
            if((arrayB1[i].getLeft()>maxB1.getLeft() && arrayB1[i].getRight()>maxB1.getRight())){
                
                int side3 = arrayB1[i].getLeft();
                int side4 = arrayB1[i].getRight();
                maxB1 = new Tiles(side3,side4);  
                
            } 
            if((arrayB2[i].getLeft()>maxB2.getLeft() && arrayB2[i].getRight()>maxB2.getRight())  && arrayB2[i].getLeft()==arrayB2[i].getRight()){
                
                int side3 = arrayB2[i].getLeft();
                int side4 = arrayB2[i].getRight();
                maxB2 = new Tiles(side3,side4);  
                
            }
            if((arrayB3[i].getLeft()>maxB3.getLeft() && arrayB3[i].getRight()>maxB3.getRight())  && arrayB3[i].getLeft()==arrayB3[i].getRight()){
                
                int side3 = arrayB2[i].getLeft();
                int side4 = arrayB2[i].getRight();
                maxB3 = new Tiles(side3,side4);  
                
            } 
        }
    }
    public void Game3Bot(){
        UserInterface ui = new UserInterface();
        int flagP=0,flagB1=0,flagB2=0,flagB3=0;
        int pointsplayer=0,pointsbot1=0,pointsbot2=0,pointsbot3=0;  
        while(pointsplayer<100 && pointsbot1<100 && pointsbot2<100 && pointsbot3<100){
            int sump=0;//Tiles ðáéêôç.
            int sumb1=0;//Tiles bot1.
            int sumb2=0;//Tiles bot2.
            int sumb3=0;//Tiles bot3.
            SetTiles3();
            SetPbTiles();
            MaxTile();
            int fm=FindMax(maxP,maxB1,maxB2,maxB3);
        while((sump<7 && sumb1<7 && sumb2<7 && sumb3<7) && (CheckPlayer() && CheckBot1() && CheckBot2())){   
            ui.DispPointsP(pointsplayer);
            ui.DispPointsB(pointsbot1);
            ui.DispPointsB2(pointsbot2);
            ui.DispPointsB(pointsbot3);
            if(fm==0){
                boolean flag3=CheckPlayer();
                flagB1=1;//×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ bot,ïôáí ï ðáéêôçò îåêéíáåé ðñùôïò.
                flagB2=1;
                flagB3=1;
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
                                sump++;//Ìåôñáåé ôá ðëáêéäéá åôóé ùóôå ïôáí ãéíïõí 12 íá ãíùñéæåé ïôé ï ðáéêôçò ôïðïèåôçóå ïëá ôá ðëáêéäéá ôïõ.
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
            flagP=1;////×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ ðáéêôç,ïôáí ôï bot îåêéíáåé ðñùôï.
            flagB2=1;
            DisTilesB1();       
            do{
                if(flagB1==0){         
                    flagB1=AddMaxBot(arrayB1,flagB1,maxB1); 
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
            flagP=1;////×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ ðáéêôç,ïôáí ôï bot îåêéíáåé ðñùôï.
            flagB1=1;
            ui.Bot2Turn();
            DisTilesB2();
            do{
                if(flagB2==0){         
                    flagB2=AddMaxBot(arrayB2,flagB2,maxB2); 
                    sumb2++;
                }else{ 
                    flagB2=1;
                    sumb2=Bot2Turn(sumb2);
                    fm=3;   
                    ui.EmptySpace();
                    DisTilesB2();
                    DispDominoLine();
                    }
                }while(fm!=3);     
        }else if(fm==3){
            flagP=1;////×ñçóéìïðïéåéôáé ãéá íá ìçí ìðåé óôï max ôïõ ðáéêôç,ïôáí ôï bot îåêéíáåé ðñùôï.
            flagB1=1;
            DisTilesB2();
            do{
                if(flagB3==0){         
                    flagB3=AddMaxBot( arrayB3,flagB3,maxB3); 
                    sumb1++;
                }else{ 
                    flagB3=1;
                    sumb3=Bot2Turn(sumb3);
                    fm=0;   
                    ui.EmptySpace();
                    DisTilesB2();
                    DispDominoLine();
                    }
                }while(fm!=0);     
        }
            
    }   
 
        if(sump==5 || ((CheckBot1()==false || CheckBot2()==false || CheckBot3()== false) && CheckPlayer()==true)){
            pointsplayer +=BotPoints(arrayB1) + BotPoints(arrayB2) + BotPoints(arrayB3);//Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôï bot.
        }else if(sumb1==5 || (CheckBot1()==true && (CheckPlayer()==false || CheckBot2()==false || CheckBot3()== false))){      
            pointsbot1 += PlayerPoints(arrayP) + BotPoints(arrayB2) + BotPoints(arrayB3);//Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôïí ðáéêôç.
        }else if(sumb2==5 || (CheckBot2()==true &&(CheckPlayer()==false || CheckBot1()==false || CheckBot3()== false))){      
            pointsbot2 += PlayerPoints(arrayP) + BotPoints(arrayB1)+ BotPoints(arrayB3);//Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôïí ðáéêôç.
        }else if(sumb2==5 || (CheckBot3()==true && (CheckPlayer()==false || CheckBot1()==false || CheckBot2()== false))){      
            pointsbot3 += PlayerPoints(arrayP) + BotPoints(arrayB1) + BotPoints(arrayB2);//Äéíù ôïõò ðïíôïõò ðïõ å÷ïõí áðïìåéíåé áðï ôïí ðáéêôç.
        }else if(CheckBot1()==false && CheckPlayer()==false && CheckBot2()==false && CheckBot3()== false){
            int sumpoints=0;
            sumpoints=(BotPoints(arrayB1)+BotPoints(arrayB2)+PlayerPoints(arrayP))/4;
            pointsplayer +=sumpoints;
            pointsbot1+=sumpoints;
            pointsbot2+=sumpoints;
            pointsbot3 += sumpoints;
        } 
    }
}
    
public int FindMax(Tiles maxB1,Tiles maxP,Tiles maxB2,Tiles maxB3){
     if (maxP.getLeft()>maxB1.getLeft() && maxP.getLeft()>maxB2.getLeft() && maxP.getLeft()>maxB3.getLeft()){
            turn=0;
            }
    if (maxB1.getLeft()>maxB2.getLeft() && maxB1.getLeft()>maxP.getLeft() && maxB1.getLeft()>maxB3.getLeft()){
            turn=1;
            } 
    if (maxB2.getLeft()>maxB1.getLeft() && maxB2.getLeft()>maxP.getLeft() && maxB2.getLeft()>maxB3.getLeft()){
            turn=2;
            }
    if (maxB3.getLeft()>maxB1.getLeft() && maxB3.getLeft()>maxP.getLeft() && maxB3.getLeft()>maxB2.getLeft() ){
            turn=3;
            } 
    
    return turn;
}
    /*
     Ç ìåèïäïò áõôç åìöáíéæåé ôç ëéóôá ðïõ ðåñéå÷åé ôá ðëáêéäéá ðïõ å÷ïõí ðáé÷ôåé.
     */    
     public void DispDominoLine(){
        int left,right;
        for (int i=0;i<DominoLine.size();i++){  
            Tiles y = DominoLine.get(i);
            left=y.getLeft();
            right=y.getRight();
            mystring5 += Integer.toString(left)+"|"+Integer.toString(right)+" "; 
                
        }
        HungarianGui3 t = new HungarianGui3();
        t.output(mystring1, mystring2, mystring3,mystring4,mystring5);
        t.setVisible(true);
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
     Óôç ìåèïäï áõôç ãéíåôáé ç áíôéêáôáóôáóç åðéëåãìåíùí ðëáêéäéùí åéôå áðï ôïí ðáéêôç åéôå áðï ôï bot , ìå åíá ðëáêéäéï ðïõ
     ðåñéå÷åé áêñáéåò ôéìåò .
     */
     public void FakeTile(int pos,int Turn){
         Tiles Dont= new Tiles(-1,-1);
         if(Turn==0){  
            arrayP[pos]=Dont;
         }else if(Turn==1){     
            arrayB1[pos]=Dont;
         }else if(Turn==2){
            arrayB2[pos]=Dont;
         }else if(Turn==3){
             arrayB3[pos]=Dont;
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
     public boolean CheckBot3(){
       boolean flag = false;
        if(DominoLine.isEmpty()){
            return true;
        }else{
            for(int i=0;i<arrayB3.length;i++){
                if(arrayB3[i].getLeft()==DominoLine.getFirst().getLeft() || arrayB3[i].getRight()==DominoLine.getFirst().getLeft()){
                    
                    flag=true;
                    
                }else if(arrayB3[i].getLeft()==DominoLine.getLast().getRight() || arrayB3[i].getRight()==DominoLine.getLast().getRight()){
                    
                    flag=true;
                }
            }
        }
        return flag; 
        
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
    Ç ìåèïäïò áõôç ðñïóèåôåé ôï ìåãáëõôåñï óôïé÷åéï ôïõ bot óôç ëéóôá åöïóïí îåêéíáåé ðñùôï.
    */
     public int AddMaxBot(Tiles [] arrayB,int flag2 ,Tiles maxB){
        int index=0;
        DominoLine.addFirst(maxB);
        //DispDominoLine();
        for(int i=0;i<arrayB.length;i++){
            if(maxB.getLeft()==arrayB[i].getLeft() && maxB.getRight()==arrayB[i].getRight()){
                index=i; //Âñéóåé ôç èåóç ôïõ ìåãáëõôåñïõ ðëáêéäéïõ ôïõ bot.
            }   
        }
        FakeTile(index,0);//Åäù ãéíåôáé ç áíôéêáôáóôáóç ôïõ ìåãáëõôåñïõ óôïé÷åéïõ ìå åíá faketile.
        flag2=1; 
        return flag2;            
     }
      /*
     Ç ìåèïäïò áõôç áðïôåëåéôáé áðï óõíèçêåò êáé åíôïëåò ùóôå íá ðñáãìáôïðïéåéôáé óùóôá ï ãõñïò ôïõ bot.
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
                j=-1;//Ãéá íá åëåã÷åé áðï ôçí áñ÷ç ôá óôïé÷åéá ôïõ ðéíáêá . 
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
                    }while(j<6);
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
                                j=-1;//Ãéá íá åëåã÷åé áðï ôçí áñ÷ç ôá óôïé÷åéá ôïõ ðéíáêá .
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
                    }while(j<6);
         return sumb;
     }
     public int Bot3Turn(int sumb){
         int j=0;
         do{
            if(arrayB3[j].getLeft()==DominoLine.getLast().getRight()){
                                int left=arrayB3[j].getLeft();
                                int right=arrayB3[j].getRight();
                                Tiles tileB = new Tiles(left,right);
                                DominoLine.addLast(tileB); 
                                sumb++;
                                FakeTile(j,3);
                                j=-1;//Ãéá íá åëåã÷åé áðï ôçí áñ÷ç ôá óôïé÷åéá ôïõ ðéíáêá .
                            }else if(arrayB3[j].getRight()== DominoLine.getFirst().getLeft()){
                                int left=arrayB3[j].getLeft();
                                int right=arrayB3[j].getRight();
                                Tiles tileB = new Tiles(left,right);
                                DominoLine.addFirst(tileB);
                                sumb++;
                                FakeTile(j,3);
                                j=-1;
                            }else if(arrayB3[j].getLeft()== DominoLine.getFirst().getLeft()){
                                int left=arrayB3[j].getLeft();
                                int right=arrayB3[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addFirst(tileB);
                                sumb++;
                                FakeTile(j,3);
                                j=-1;
                            }else if(arrayB3[j].getRight()==DominoLine.getLast().getRight()){
                                int left=arrayB3[j].getLeft();
                                int right=arrayB3[j].getRight();
                                Tiles tileB = new Tiles(right,left);
                                DominoLine.addLast(tileB);
                                sumb++;
                                FakeTile(j,3); 
                                j=-1;
                            } 
                        j++;          
                    }while(j<6);
         return sumb;
     }
      /*
    Ç ìåèïäïò áõôç åðéóôñåöåé ôïõò ðïíôïõò ðïõ å÷åé ìáæåøåé ôï bot.
    */
    public int  BotPoints(Tiles [] arrayB){
        
        for(int i=0;i<6;i++){
            if(arrayB[i].getLeft()!=-1 && arrayB[i].getRight()!=-1){
                bpoints = bpoints + arrayB[i].getLeft() + arrayB[i].getRight();
            }
            
        }
        
        return bpoints;    
    }
    public int  PlayerPoints(Tiles [] arrayP){
        int ppoints=0;
        for(int i=0;i<6;i++){
            if(arrayP[i].getLeft()!=-1 && arrayP[i].getRight()!=-1){
                ppoints = ppoints + arrayP[i].getLeft() + arrayP[i].getRight();
            }
            
        }
        return ppoints;
    }  
    
    
    
}
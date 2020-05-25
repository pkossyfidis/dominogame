/*
Η κλαση αυτη περιεχει ολα τα μηνυματα καθως και τις απαραιτητες εισοδους του χρηστη.
*/

package domino;
import solo1.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 *@author Ελευθεριος Δημητριου  Α.Ε.Μ:2891
 *@author Παναγιωτης Κοσσυφιδης Α.Ε.Μ:2928
 * 
 */
public class UserInterface {
    
   public boolean flag;
    
    public void GreekOrEng(boolean f){
        flag=f;
    }
   
    public int Menu(){
        if(flag==true){
            System.out.println("Welcome to Domino! ");
            System.out.println("-----------------");
            System.out.println("Which game would you like to play? ");
            System.out.println("For solo-1 type <1>. ");
            System.out.println("For Hungarian Domino type <2>.");
            System.out.println("For Ola 7 type <3>.");
            System.out.println("Exit type <4>. ");
            System.out.println(" ");
        }else{
            System.out.println("Καλως Ηρθατε στο Ντομινο ");
            System.out.println("-----------------");
            System.out.println("Ποιο Παιχνιδι θα θελατε να παιξετε? ");
            System.out.println("Για το solo-1 πατηστε <1>. ");
            System.out.println("Για το Hungarian Domino πατηστε <2>.");
            System.out.println("Για το Ola 7 πατηστε <3>.");
            System.out.println("Για εξοδο πατηστε <4>. ");
            System.out.println(" ");
        }
        int choose=Input();
        return choose;
    }
    
    public int Input(){
       
        int num;
        Scanner input1 = new Scanner(System.in);
        num = input1.nextInt();
        return num;
        
        
        
    }
    
   public void Player(){
       if(flag==true){
           System.out.println("Playing solo-1");
           System.out.println("__________________");
       }else{
           System.out.println("Παιζεις το solo-1");
       System.out.println("__________________");
       };
   }
    
    public void GameOver(){
        if(flag==true){
            JOptionPane.showMessageDialog(null,"Game Over");
        }else{
            JOptionPane.showMessageDialog(null,"Τελος παιχνιδιου");
        }    
    }
    public int SelectTileUi(){
        
        String left;
        int toint=0;
        if(flag==true){
            left = JOptionPane.showInputDialog("Please select either one of the last tiles of each row :"+"\n"+
                   "__________________"+"\n"+
                   "For Exit press 9"+"\n"+
                    "OR"+"\n"+
                    "Give the left side of the Tile: ");
            toint = Integer.parseInt(left);
        }else{
            left = JOptionPane.showInputDialog("Παρακαλω επιλεξτε ενα πλακιδιο απο τα τελευταια της καθε γραμμης:"+"\n"+
                   "__________________"+"\n"+
                   "Για εξοδο πατηστε 9"+"\n"+
                    "Η"+"\n"+
                    "Δωστε τον αριθμο που βρισκεται στην αριστερη πλευρα του πλακιδιου: ");
            toint = Integer.parseInt(left);
        }
        return toint;
    }
    
    public int SelectTileUi2(){
        int right=0;
        String mystring;
        if(flag==true){
            mystring = JOptionPane.showInputDialog("Give the right side of the Tile: ");
        }else{
            mystring = JOptionPane.showInputDialog("Δωστε τον αριθμο που βρισκετε στην δεξια πλευρα του πλακιδιου: ");
        }
        right = Integer.parseInt(mystring);
        return right;
    }
    
    public void WrongTile(){
        if(flag==true){
            JOptionPane.showMessageDialog(null,"!!!WRONG TILE!!! ");
        }else{
            JOptionPane.showMessageDialog(null,"!!!ΛΑΘΟΣ ΠΛΑΚΙΔΙΟ!!! ");
        }
        
    }
    
    public void Win(){
        if(flag==true){
            JOptionPane.showMessageDialog(null,"Congratulations you won!!");
        }else{
            JOptionPane.showMessageDialog(null,"Συγχαρητηρια κερδισατε !!!");
        }
    }
    
    public int Choice(){
        int cho=0;
        String mystring;
        if(flag==true){
            mystring = JOptionPane.showInputDialog("Where would you like to place the tile? "+"\n"+
                                                   "Type <0> for left side or type <1> for right side");
            cho=Integer.parseInt(mystring);
        }else{
            mystring = JOptionPane.showInputDialog("Που θα θελατε να τοποθετησετε το πλακιδιο?  "+"\n"+
                                                   "Γραψτε <0> για αριστερα η γραψτε  <1> για δεξια ");
            cho=Integer.parseInt(mystring);
        }
        return cho;
    }
    
    public int Choice2(){
        int cho=0;
        String mystring;
        if(flag==true){
            mystring = JOptionPane.showInputDialog("Where would you like to place the tile? "+"\n"+
                                                   "Type <0> for left side or type <1> for right side");
            cho=Integer.parseInt(mystring);
        }else{
            mystring = JOptionPane.showInputDialog("Που θα θελατε να τοποθετησετε το πλακιδιο?  "+"\n"+
                                                   "Γραψτε <0> για αριστερα η γραψτε  <1> για δεξια ");
            cho=Integer.parseInt(mystring);
        }
        return cho;
        
    }
    
    public void DisplayTable(){
        if(flag==true){
            System.out.println(" ");
            System.out.println("Tiles on table :"); 
        }else{
            System.out.println(" ");
            System.out.println("Τα πλακιδια του πινακα :");
        }
        
    }
    
    public void DisplayTable(String mystring){
        if(flag==true){
            JOptionPane.showMessageDialog(null,"Tiles on table : "+"\n"+mystring);
        }else{
            JOptionPane.showMessageDialog(null,"Τα πλακιδια του πινακα : "+"\n"+mystring);
        }
    }
    
    public void EmptySpace(){
        System.out.println(" ");
    }
    
    public void DisplayList(Tiles x ){
        System.out.print(x.getLeft()+"|"+x.getRight()+" ");
    }
    
    public void DominoLine(){
        if(flag==true){
            JOptionPane.showMessageDialog(null,"Domino Line :");
        }else{
            JOptionPane.showMessageDialog(null,"Γραμμη Ντομινο :");
        }
    }
    
    public void DispPlayerTiles(){
        if(flag==true){
            System.out.print("Player Tiles: ");
        }else{
            System.out.println("Πλακιδια του παικτη:");
        }
    }
    public void DispPtiles(Tiles [] array1,int i){
        System.out.print(array1[i].getLeft() +"|"+ array1[i].getRight()+" ");
    }
    public void DispBotTiles(){
        if(flag==true){
            System.out.print("Bot Tiles: ");
        }else{
            System.out.println("Πλακιδια του μποτ:");
        }
        
    }
    public void DispBtiles(Tiles [] array2,int i){
        System.out.print("-" +"|"+ "-"+" ");
    }
    
    public void DispPointsP(int pointsp){
        if(flag==true){
            System.out.println("");
            System.out.print("Player points :" + pointsp);
            System.out.println(" ");
        }else{
            System.out.println("");
            System.out.print("Ποντοι του παικτη :" + pointsp);
            System.out.println(" ");
        }
    }
    public void DispPointsB(int pointsb){
        if(flag==true){
            System.out.println("Bot points : "+pointsb);
            System.out.println(" ");
        }else{
            System.out.println("Ποντοι του μποτ : "+pointsb);
            System.out.println(" ");
        }
        
    }

    public void PlayerTurn(){
        if(flag==true){
            System.out.println(" ");
            System.out.println("Player Turn");
        }else{
            System.out.println(" ");
            System.out.println("Σειρα του παικτη");
        }
    }
    public void BotTurn(){
        if(flag==true){
            System.out.println(" ");
            System.out.println("Bot  turn:");
        }else{
            System.out.println(" ");
            System.out.println("Σειρα του μποτ:");
        }
    }
    public int GiveFirstTile(){
        int right=0;
        String mystring;
        if(flag==true){
            mystring = JOptionPane.showInputDialog("Give the leftt side of the Tile: ");
        }else{
            mystring = JOptionPane.showInputDialog("Δωστε τον αριθμο που βρισκετε στην αριστερη πλευρα του πλακιδιου: ");
        }
        right = Integer.parseInt(mystring);
        return right;
    }
    public int GiveSecTile(){
        int right=0;
        String mystring;
        if(flag==true){
            mystring = JOptionPane.showInputDialog("Give the right side of the Tile: ");
        }else{
            mystring = JOptionPane.showInputDialog("Δωστε τον αριθμο που βρισκετε στην δεξια πλευρα του πλακιδιου: ");
        }
        right = Integer.parseInt(mystring);
        return right;
    }
    
    public void Bot2Turn(){
        if(flag==true){
            System.out.println("Bot 2 turn:");
        }else{
            System.out.println("Σειρα 2ου μποτ:");
        }
        
    }
    
    public void Bot3Turn(){
        if(flag==true){
            System.out.println("Bot 3 turn:");
        }else{
            System.out.println("Σειρα 3ου μποτ:");
        }
    }
    
    public void DispPointsB2(int x){
        if(flag==true){
            System.out.println("Bot 2 points :" + x);
            System.out.println(" ");
        }else{
            System.out.println("Ποντοι 2ου μποτ :" + x);
            System.out.println(" ");
        }
    }
    public void DispPointsB3(int x){
        if(flag==true){
            System.out.println("Bot 3 points :" + x);
            System.out.println(" ");
        }else{
            System.out.println("Ποντοι 3ου μποτ :" + x);
            System.out.println(" ");
        }
    }
    public int DoYouWantTile(){
        int answer=1;
        String mystring="";
        if(flag==true){
            mystring = JOptionPane.showInputDialog(null,"Do you want a new tile?"+"\n"+
                                                          "Press YES or NO");
        }else{
            mystring = JOptionPane.showInputDialog(null,"Θελεις καινουριο πλακιδιο?"+"\n"+
                                                          "Πατησε YES η NO");
        }
        if("yes".equals(mystring)){
            answer=0;
        }else if("no".equals(mystring)){
            answer=1;
        }
        return answer;
    }
    public void NoMoreTiles(){
        if(flag==true){
            JOptionPane.showMessageDialog(null,"No more Tiles on stack!");
        }else{
            JOptionPane.showMessageDialog(null,"Δεν υπαρχουν αλλα πλακιδια στην στοιβα");
        }
    }
    public void Results(int x){
        if(flag==true){
            if(x==0){
                System.out.println("The winner is the bot");
            }else if(x==1){
                System.out.println("The winner is the player ");
            }else{
                System.out.println("Its a draw");
            }
        }else{
            if(x==0){
                System.out.println("O νικητης ειναι το Bot");
            }else if(x==1){
                System.out.println("O νικητης ειναι ο Παικτης ");
            }else{
                System.out.println("Ισοπαλια");
            }
        }
    }
    public void DispBot2Tiles(){
        if(flag==true){
            System.out.print("Bot 2 Tiles:");
        }else{
            System.out.println("Πλακιδια 2ου μποτ");
        }
    }
    public void DispBot3Tiles(){
        if(flag==true){
            System.out.print("Bot 3 Tiles:");
        }else{
            System.out.println("Πλακιδια 3ου μποτ");
        }
    }
}

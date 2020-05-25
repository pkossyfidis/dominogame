/*
Στην κλαση αυτη γινεται η δηλωση των πλακιδιων.
*/
package solo1;
/**
 *@author Ελευθεριος Δημητριου  Α.Ε.Μ:2891
 *@author Παναγιωτης Κοσσυφιδης Α.Ε.Μ:2928
 */



public class Tiles {
   
    private int left;
    private int right;
   
    public Tiles(int num1, int num2){
       
       left = num1;
       right = num2;
    }
    public int getLeft(){
       
       return left;   
    }
    public int getRight(){
       
       return right;
    }  
   
}
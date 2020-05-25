/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author ΠΑΝΑΓΙΩΤΗΣ ΚΟΣΣΥΦΙΔΗΣ 2928
 * @author ΕΛΕΥΘΕΡΙΟΣ ΔΗΜΗΤΡΙΟΥ 2891
 */
public class Solo1gui extends JFrame {
    
    JTextArea txt;
    JTextArea txt2;
    public Solo1gui(){
        super("DOMINO");
        setLayout(new FlowLayout());
        setSize(500,250);
        setLocation(580,160);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        txt2 = new JTextArea(2,25);
        txt = new JTextArea(" ");
        txt2.setEditable(false);
        txt.setEditable(false);
        
        add(txt);
        add(txt2);
    }
    
    
    public void output(String mystring,String mystring2){ 
        txt.append(mystring);
        txt2.append(mystring2);
    }   
        
    
        
        
    
}

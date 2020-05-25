/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;

/**
 *
 * @author ΠΑΝΑΓΙΩΤΗΣ ΚΟΣΣΥΦΙΔΗΣ 2928
 * @author ΕΛΕΥΘΕΡΙΟΣ ΔΗΜΗΤΡΙΟΥ 2891
 */
public class HungarianGui extends JFrame {
    
    JTextArea txt;
    JTextArea txt2;
    JTextArea txt3;
    public HungarianGui(){
        super("Hungarian");
        setLayout(new FlowLayout());
        setSize(1000,500);
        setLocation(580,160);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        txt2 = new JTextArea(2,25);
        txt = new JTextArea(2,25);
        txt3 = new JTextArea(2,25);
        txt2.setEditable(false);
        txt.setEditable(false);
        txt3.setEditable(false);
        
        add(txt);
        add(txt2);
        add(txt3);
    }
    
    
    public void output(String botstring,String playerstring,String dlinestring){ 
        txt.append(botstring);
        txt2.append(playerstring);
        txt3.append(dlinestring);
    }   
        
    
        
        
    
}

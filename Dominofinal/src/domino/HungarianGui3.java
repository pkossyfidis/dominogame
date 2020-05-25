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
public class HungarianGui3 extends JFrame {
    
    JTextArea txt;
    JTextArea txt2;
    JTextArea txt3;
    JTextArea txt4;
    JTextArea txt5;
    public HungarianGui3(){
        super("Hungarian");
        setLayout(new FlowLayout());
        setSize(1000,500);
        setLocation(580,160);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        txt = new JTextArea(2,25);
        txt2 = new JTextArea(2,25);
        txt3 = new JTextArea(2,25);
        txt4 = new JTextArea(2,25);
        txt5 = new JTextArea(2,25);
        
        txt.setEditable(false);
        txt2.setEditable(false);
        txt3.setEditable(false);
        txt4.setEditable(false);
        txt5.setEditable(false);        
        
        add(txt);
        add(txt2);
        add(txt3);
        add(txt4);
        add(txt5);
    }
    
    
    public void output(String botstring1,String botstring2,String botstring3,String playerstring,String dlinestring){ 
        txt.append(botstring1);
        txt2.append(botstring2);
        txt3.append(botstring3);
        txt4.append(playerstring);
        txt5.append(dlinestring);
    }   
        
    
        
        
    
}

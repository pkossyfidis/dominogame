package domino;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;

/**
 *@author Ελευθεριος Δημητριου  Α.Ε.Μ:2891
 *@author Παναγιωτης Κοσσυφιδης Α.Ε.Μ:2928
 */
public class HungarianGui2 extends JFrame{
        
    JTextArea txt;
    JTextArea txt2;
    JTextArea txt3;
    JTextArea txt4;
    public HungarianGui2(){
        super("DOMINO");
        setLayout(new FlowLayout());
        setSize(1000,500);
        setLocation(580,160);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        txt2 = new JTextArea(2,25);
        txt = new JTextArea(2,25);
        txt3 = new JTextArea(2,25);
        txt4 =new JTextArea(2,25);
        txt2.setEditable(false);
        txt.setEditable(false);
        txt3.setEditable(false);
        txt4.setEditable(false);
        
        
        add(txt);
        add(txt4);
        add(txt2);
        add(txt3);
    }
    
    
    public void output(String botstring,String bot2string,String playerstring,String dlinestring){ 
        txt.append(botstring);
        txt4.append(bot2string);
        txt2.append(playerstring);
        txt3.append(dlinestring);
    }
}
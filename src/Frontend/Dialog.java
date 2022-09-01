/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

/**
 *
 * @author buennig
 */
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class Dialog extends JDialog{
    public Dialog(){
        super();
        JPanel panel=new JPanel();
        panel.add(new JLabel("Hello dialog"));
        this.getContentPane().add(panel);
    }
    
    public Dialog(String title,String text, boolean modal){
        super((JFrame)null,title, modal);
        this.setSize(300,200);
        JPanel panel=new JPanel();
        panel.add(new JLabel(text));
        this.getContentPane().add(panel);
    }
}


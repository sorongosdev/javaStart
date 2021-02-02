package calculator;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Tester extends KeyAdapter{
    public static void main(String[] args) {    
        
        JFrame f = new JFrame();
        f.setSize(300,200);     
        f.setLayout( null );

        class key implements KeyListener{
            
            public void keyPressed(KeyEvent e) {

                System.out.println( e );
            }

            public void keyReleased(KeyEvent e){ }          
            public void keyTyped(KeyEvent e) { }            
                        
        }       
        
        f.setVisible(true);
        f.addKeyListener(new key());
        
    }       
}

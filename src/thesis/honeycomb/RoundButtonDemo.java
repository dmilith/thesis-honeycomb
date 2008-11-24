/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author vara
 */
public class RoundButtonDemo {

    public RoundButtonDemo(){
    }
    public static void main(String [] a){
	
	SwingUtilities.invokeLater(new Runnable() {

	    @Override
	    public void run() {
		
		JFrame f = new JFrame("Demo sremo");		
		Checkerboard cb = new Checkerboard();
		cb.add(new RoundButton("Round Button"));
		cb.add(new JButton("Normal Button"));
		f.add(cb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 300);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	    }
	});	
    }
    
    private static class Checkerboard extends JPanel {
        
        static final int CHECKER_SIZE = 60;
	
	@Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.magenta);
            for (int stripeX = 0; stripeX < getWidth(); stripeX += CHECKER_SIZE) {
                for (int y = 0, row = 0; y < getHeight(); y += CHECKER_SIZE/2, ++row) {
                    int x = (row % 2 == 0) ? stripeX : (stripeX + CHECKER_SIZE/2);
                    g.fillRect(x, y, CHECKER_SIZE/2, CHECKER_SIZE/2);
                }
            }
        }
    }
}
package thesis.honeycomb;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author Grzegorz (vara) Warywoda
 */
public class RoundButton extends JButton implements MouseListener{

    private RoundRectangle2D visibleRec;
    
    public RoundButton(String label){
	
	super(label); 
      setFocusPainted(false);
      setBorderPainted(false);
      //setPreferredSize(new Dimension(100,35));
      setOpaque(false);
      addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g){	
      Graphics2D g2 = (Graphics2D)g.create();
      visibleRec = new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20);
      g2.setClip(visibleRec);
      super.paintComponent(g2);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      RoundRectangle2D megaSimpleBorder = new RoundRectangle2D.Double(0,0,getWidth()-1,getHeight()-1,20,20);
      g2.setStroke(new BasicStroke(1.8f));
      g2.draw(megaSimpleBorder);
      g2.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
package thesis.honeycomb;

/**
 *
 * @authors hannibal & dmilith
 */

import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
/**
 *
 * @author hannibal & vara
 */
public class HoneyComb extends JPanel implements MouseListener {
//test
    public final int MAX_X = 800;
    public final int MAX_Y = 800;

    private int mouseX=0, mouseY=0;
    private double odl=0, odl2=0;
    private int bmin_poprzedni=0;
    private int bmin_aktualny=0;
    private int clic=0;
    private int a, x, y, v1, v2, w1, w2;
    private double h;
    private Vector <Integer> bx=new Vector <Integer>();
    private Vector <Integer> by=new Vector <Integer>();
    private int b;
    private RoundButton but = new RoundButton("Quit HoneyComb");
    private RoundButton but2 = new RoundButton("Help HoneyComb");

    public HoneyComb() {
        super();
        this.addMouseListener( this );
        this.setLayout(new FlowLayout());
        but.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( "Quit!" );
                System.exit( 0 );
            }
        } );
        but2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( "Help!" );
            }
        } );
        
        this.setSize( new Dimension( MAX_X, MAX_Y) );
        this.setVisible( true );
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HoneyComb();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        bmin_poprzedni=bmin_aktualny;
        System.out.println(bmin_poprzedni);
        clic=1;
        mouseX=e.getX(); mouseY=e.getY();
        odl=Math.sqrt(Math.pow((mouseX-bx.get(0)),2)+Math.pow((mouseY-by.get(0)),2));

        for (int ii=1; ii<b; ii++) {
            odl2=Math.sqrt(Math.pow((mouseX-bx.get(ii)),2)+Math.pow((mouseY-by.get(ii)),2));
            if (odl2<odl) {
                odl=odl2;
                bmin_aktualny=ii;
            }
        }
        repaint();
   }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    private void rysuj (Graphics g, int xx, int yy) {
                bx.add(b, xx);
                by.add(b, yy);
                b=b+1;

                v1=xx+(a/2);
                w1=yy-(int)h;

                v2=xx-(a/2);
                w2=yy-(int)h;

                g.drawLine(v1,w1,v2,w2);

                v1=v2;
                w1=w2;
                v2=xx-a;
                w2=yy;
                g.drawLine(v1,w1,v2,w2);

                v1=v2;
                w1=w2;
                v2=xx-(a/2);
                w2=yy+(int)h;
                g.drawLine(v1,w1,v2,w2);

                v1=v2;
                w1=w2;
                v2=xx+(a/2);
                w2=yy+(int)h;
                g.drawLine(v1,w1,v2,w2);

                v1=v2;
                w1=w2;
                v2=xx+a;
                w2=yy;
                g.drawLine(v1,w1,v2,w2);

                v1=v2;
                w1=w2;
                v2=xx+(a/2);
                w2=yy-(int)h;
                g.drawLine(v1,w1,v2,w2);
        }

     @Override
     public void paint(Graphics g)
        {
            if (clic==0)
            {
                b=0;
                a=40;
                x=MAX_X/2; y=MAX_Y/2;
                h=Math.sqrt(3)*(a/2);

                rysuj(g,x,y);


                for (int j=1;j<=1;j++)
                    {
                        y=y-(2*(int)h);
                        rysuj(g,x,y);

                        for(int i1=0; i1<j;i1++)
                        {
                            y=y+(int)h;
                            x=x+(3*a/2);
                            rysuj(g,x,y);
                        }

                        for(int i1=0; i1<j;i1++)
                        {
                            y=y+(2*(int)h);
                            rysuj(g,x,y);
                        }

                        for(int i1=0; i1<j;i1++)
                        {
                            y=y+(int)h;
                            x=x-(3*a/2);
                            rysuj(g,x,y);
                        }

                        for(int i1=0; i1<j;i1++)
                        {
                            y=y-(int)h;
                            x=x-(3*a/2);
                            rysuj(g,x,y);
                        }

                        for(int i1=0; i1<j;i1++)
                        {
                            y=y-(2*(int)h);
                            rysuj(g,x,y);
                        }

                        for(int i1=0; i1<j-1;i1++)
                        {
                            y=y-(int)h;
                            x=x+(3*a/2);
                            rysuj(g,x,y);
                        }
                    }
            }
            else
            {
                g.setColor(Color.gray);
                rysuj(g,bx.get(bmin_poprzedni),by.get(bmin_poprzedni));

                g.setColor(Color.red);
                rysuj(g,bx.get(bmin_aktualny),by.get(bmin_aktualny));
            }

    }

}


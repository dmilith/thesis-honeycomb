package thesis.honeycomb.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;

/**
 * Created on 2008-11-25, 11:32:47
 * @author vara
 */

public class HoneyCombCanvas extends JComponent{

    private Dimension size = null;
    private Vector<HoneyComb>structure;

    public HoneyCombCanvas(Dimension size){
        this.size = size;
        setBounds(0,0,size.width,size.height);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                                                  Color.BLUE, Color.DARK_GRAY));
        init();
    }

    private void init(){

        HoneyComb.Verbose.setEnable(false);
        HoneyComb.setBase(60);
        
        structure = new Vector<HoneyComb>(7,25);
    }

    public void createStructureHoneyComb(){

        double x = getWidth()/2;
        double y = getHeight()/2;        

        HoneyComb firstHC = new HoneyComb(x,y);
        firstHC.setBorderColor(Color.RED);
        firstHC.setFillShape(true);
        structure.add(firstHC);//1

        for (int j=1;j<=2;j++){

            y=y-(2*HoneyComb.getHeight());
            structure.add(new HoneyComb(x,y));//2, second round 9 ...

            for(int i1=0; i1<j;i1++){
                y=y+HoneyComb.getHeight();
                x=x+(3*HoneyComb.getHalfBase());
                structure.add(new HoneyComb(x,y));//3, s.r. 10 and 10i1+1
            }

            for(int i1=0; i1<j;i1++){
                y=y+(2*HoneyComb.getHeight());
                structure.add(new HoneyComb(x,y));//4 s.r 11 and 11i1+1
            }

            for(int i1=0; i1<j;i1++){
                y=y+HoneyComb.getHeight();
                x=x-(3*HoneyComb.getHalfBase());
                structure.add(new HoneyComb(x,y));//5
            }

            for(int i1=0; i1<j;i1++){
                y=y-HoneyComb.getHeight();
                x=x-(3*HoneyComb.getHalfBase());
                structure.add(new HoneyComb(x,y));//6
            }

            for(int i1=0; i1<j;i1++){
                y=y-(2*HoneyComb.getHeight());
                structure.add(new HoneyComb(x,y));//7
            }
/*
            for(int i1=0; i1<j-1;i1++)
            {
                y=y-HoneyComb.getHeight();
                x=x+(3*HoneyComb.getHalfBase());
                structure.add(new HoneyComb(x,y));//8
            }*/
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        if(size==null || getWidth()!=size.getWidth() || getHeight()!=size.getHeight()){
            structure.clear();
            createStructureHoneyComb();
        }
        for (HoneyComb honeyComb : structure) { 
            
            g2.setColor(honeyComb.getBorderColor());
            if(honeyComb.isFillShape()){
                g2.fill(honeyComb.getGenPath());
            }else
                g2.draw(honeyComb.getGenPath());
        }
        g2.dispose();
    }


}

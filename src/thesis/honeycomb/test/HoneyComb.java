/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb.test;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

/**
 * Created on 2008-11-25, 16:47:09
 * @author vara
 */
class HoneyComb implements MouseListener{

    //side of triangle or radius, the same for each  HoneyComb object
    private static int base = 10;
    private static double halfBase = base/2;
    private static double height = HCConstants.sin60*base;

    private Point.Double center = null;
    private GeneralPath genPath;

    private Color borderColor = Color.BLACK;
    private boolean fillShape = false;

    private String id;

    public HoneyComb(double centerX,double centerY){
        center = new Point.Double(centerX,centerY);
        createPath();
    }

    public GeneralPath setCenter(int centerX,int centerY){
        getCenter().setLocation(centerX,centerY);
        return createPath();
    }
    private GeneralPath createPath(){

        Verbose.out("Center point "+getCenter());

        if(getGenPath() == null)
            genPath = new GeneralPath(GeneralPath.WIND_NON_ZERO,12);
        
        double v1 = getCenter().getX()+getHalfBase();
        double w1 = getCenter().getY()-getHeight();
        double v2 = getCenter().getX()-getHalfBase();
        double w2 = w1;

        getGenPath().moveTo(v1,w1);
        getGenPath().lineTo(v2, w2);
        Verbose.out("1 point ["+v1+","+w1+","+v2+","+w2+"]");

        v1=v2;  w1=w2;
        v2=getCenter().getX()-getBase();
        w2=getCenter().getY();
        getGenPath().lineTo(v1,w1);
        getGenPath().lineTo(v2, w2);
        Verbose.out("2 point ["+v1+","+w1+","+v2+","+w2+"]");

        v1=v2;  w1=w2;
        v2=getCenter().getX()-getHalfBase();
        w2=getCenter().getY()+getHeight();
        getGenPath().lineTo(v1,w1);
        getGenPath().lineTo(v2, w2);
        Verbose.out("3 point ["+v1+","+w1+","+v2+","+w2+"]");

        v1=v2;  w1=w2;
        v2=getCenter().getX()+getHalfBase();
        w2=getCenter().getY()+getHeight();
        getGenPath().lineTo(v1,w1);
        getGenPath().lineTo(v2, w2);
        Verbose.out("4 point ["+v1+","+w1+","+v2+","+w2+"]");

        v1=v2;  w1=w2;
        v2=getCenter().getX()+getBase();
        w2=getCenter().getY();
        getGenPath().lineTo(v1,w1);
        getGenPath().lineTo(v2, w2);
        Verbose.out("5 point ["+v1+","+w1+","+v2+","+w2+"]");

        v1=v2;  w1=w2;
        v2=getCenter().getX()+getHalfBase();
        w2=getCenter().getY()-getHeight();
        getGenPath().lineTo(v1,w1);
        getGenPath().lineTo(v2, w2);
        Verbose.out("6 point ["+v1+","+w1+","+v2+","+w2+"]");

        getGenPath().closePath();
        return getGenPath();
    }
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    /**
     * @return the genPath
     */
    public GeneralPath getGenPath() {
        return genPath;
    }

    /**
     * @return the center
     */
    public Point.Double getCenter() {
        return center;
    }

    /**
     * @return the base
     */
    public static int getBase() {
        return base;
    }

    /**
     * @return the halfBase
     */
    public static double getHalfBase() {
        return halfBase;
    }

    /**
     * @return the height
     */
    public static double getHeight() {
        return height;
    }

    /**
     * @param aBase the base to set
     */
    public static void setBase(int aBase) {
        base = aBase;
        halfBase = base/2;
        height = HCConstants.sin60*base;
    }

    /**
     * @return the fillShape
     */
    public boolean isFillShape() {
        return fillShape;
    }

    /**
     * @param fillShape the fillShape to set
     */
    public void setFillShape(boolean fillShape) {
        this.fillShape = fillShape;
    }

    /**
     * @return the borderColor
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * @param borderColor the borderColor to set
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    static class Verbose{
        private static boolean isVerbose = false;
        private static void out(String str){
            if(isVerbose)
                System.out.println(str);
        }
        public static void setEnable(boolean val){
            isVerbose = val;
        }
    }
}
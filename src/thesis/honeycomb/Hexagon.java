package thesis.honeycomb;

import com.trolltech.qt.svg.QSvgWidget;

/**
 *
 * @author Daniel <dmilith> Dettlaff
 * Created on Nov 25, 2008, 5:55:42 PM
 */

public class Hexagon extends QSvgWidget {

  private final int a = 34;
  private final double h = a * (Math.sqrt(3) / 2);
  private final double l = 2 * h;
 
  private double vX, vY;

  Hexagon( double _vectorX, double _vectorY ) {
    super( "classpath:images/hexagon.svg" );
    this.setMaximumSize( a, a);
    vX = _vectorX - a;
    vY = _vectorY - h;
    int x = 250;
    int y = 250;
    // TODO, FIXME here will be calculated real values of x and y on screen
    
    this.move( x, y );
  }

  public double vX() {
    return vX;
  }

  public void setVX(double vX) {
    this.vX = vX;
  }

  public double vY() {
    return vY;
  }

  public void setVY(double vY) {
    this.vY = vY;
  }

}

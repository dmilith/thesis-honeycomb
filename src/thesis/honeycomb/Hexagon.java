package thesis.honeycomb;

import com.trolltech.qt.svg.QSvgWidget;

/**
 *
 * @author Daniel <dmilith> Dettlaff
 * Created on Nov 25, 2008, 5:55:42 PM
 */

public class Hexagon extends QSvgWidget {

  public final int a = 31; // for 34 b will be 27
  public final double h = a * (Math.sqrt(3) / 2);
 
  private double vX, vY;

  Hexagon( double _vectorX, double _vectorY ) {
    super( "classpath:images/hexagon.svg" );
    this.setMaximumSize( a*2, 28*2);
    this.setGeometry(0, 0, a*2, 28*2);
    this.setWindowOpacity(0.2);
    double centerX = 250;
    double centerY = 250;
    double pX = centerX + _vectorX * 3/2 * a;
    double pY = centerY - _vectorX * h;
    double dX = pX - _vectorY * 3/2 * a;
    double dY = pY - _vectorY * h;
   
    this.move( (int)dX, (int)dY );
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

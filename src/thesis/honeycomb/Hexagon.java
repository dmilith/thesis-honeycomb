package thesis.honeycomb;

import com.trolltech.qt.svg.QSvgWidget;

/**
 *
 * @author Daniel <dmilith> Dettlaff
 * Created on Nov 25, 2008, 5:55:42 PM
 */

public class Hexagon extends QSvgWidget {

  private final double a = 34;
  private final double h = a * (Math.sqrt(3) / 2);
  private final double l = 2 * h;
 
  private double vX, vY;

  Hexagon( double _vectorX, double _vectorY ) {
    super( "classpath:images/hexagon.svg" );
    this.setMaximumWidth((int)a);
    this.setMaximumHeight((int)a);
    this.setMaximumSize((int)a, (int)a);
    vX = _vectorX - a;
    vY = _vectorY - h;
  }

  Hexagon( double _x, double _y, String _file_name ) {
    super( "classpath:images/" + _file_name );
    this.setFixedSize((int)a, (int)a);
    vX = _x - a;
    vY = _y - h;
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

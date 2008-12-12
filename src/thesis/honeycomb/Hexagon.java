package thesis.honeycomb;

import com.trolltech.qt.svg.QSvgWidget;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;
import java.util.Vector;

/**
 *
 * @author Daniel <dmilith> Dettlaff
 * Created on Nov 25, 2008, 5:55:42 PM
 */

public class Hexagon extends QSvgWidget {

  public final int a = 32;
  public final double h = a * (Math.sqrt(3) / 2.08);
  public double centerX = 350;
  public double centerY = 450;

  private double dX, dY;
  private double vX, vY;

  Hexagon( double _vectorX, double _vectorY ) {
    super( "classpath:images/hexagon.svg" );
    vX = _vectorX;
    vY = _vectorY;
    setMaximumSize( a*2, 28*2);
    setGeometry(0, 0, a*2, 28*2);
    double pX = centerX + _vectorX * 3/2 * a;
    double pY = centerY - _vectorX * h;
    dX = pX - _vectorY * 3/2 * a;
    dY = pY - _vectorY * h;
    move( (int)dX, (int)dY );
  }

  Hexagon( double _vectorX, double _vectorY, String _filename ) {
    super( "classpath:images/" + _filename );
    vX = _vectorX;
    vY = _vectorY;
    setMaximumSize( a*2, 28*2);
    setGeometry(0, 0, a*2, 28*2);
    double pX = centerX + _vectorX * 3/2 * a;
    double pY = centerY - _vectorX * h;
    dX = pX - _vectorY * 3/2 * a;
    dY = pY - _vectorY * h;
    move( (int)dX, (int)dY );
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

  public QPolygonF getOneHoneyCombFrame() {
    double x = dX;
    double y = dY;
    Vector<QPointF> points = new Vector<QPointF>();
    points.addElement( new QPointF( (int)( x + h/2 ) , (int)(y - h) ) ); // w1
    points.addElement( new QPointF( (int)(x + a    ) , (int)(y    ) ) ); // w2
    points.addElement( new QPointF( (int)(x + h/2  ) , (int)(y + h) ) ); // w3
    points.addElement( new QPointF( (int)(x - h/2  ) , (int)(y + h) ) ); // w4
    points.addElement( new QPointF( (int)(x - a    ) , (int)(y    ) ) ); // w5
    points.addElement( new QPointF( (int)(x - h/2  ) , (int)(y - h) ) ); // w6
    QPolygonF hexagon = new QPolygonF();
    for ( int i = 0; i < 6; i++ ) {
      hexagon.add( points.get(i) );
    }
    return hexagon;
  }


}

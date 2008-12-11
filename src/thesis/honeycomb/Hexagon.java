package thesis.honeycomb;

import java.util.Vector;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.opengl.QGLWidget;
import com.trolltech.qt.svg.QSvgRenderer;

/**
 *
 * @author Daniel <dmilith> Dettlaff
 * Created on Nov 25, 2008, 5:55:42 PM
 */

public class Hexagon {

  private final double a = 34;
  private final double h = a * (Math.sqrt(3) / 2);
 
  private QSvgRenderer hexagon;
  private double x, y;

  Hexagon( double _x, double _y, QGLWidget _parent ) {
    super();
    hexagon = new QSvgRenderer( "classpath:images/hexagon.svg", _parent );
    x = _x - a;
    y = _y - h;
  }

  Hexagon( double _x, double _y, QGLWidget _parent, String _file_name ) {
    super();
    hexagon = new QSvgRenderer( "classpath:images/" + _file_name, _parent );
    x = _x - a;
    y = _y - h;
  }

  public QSvgRenderer getHexagon() {
    return hexagon;
  }

  public void setHexagon(QSvgRenderer hexagon) {
    this.hexagon = hexagon;
  }

  public double x() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double y() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

}

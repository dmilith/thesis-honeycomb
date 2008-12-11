/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.svg.QSvgRenderer;
import com.trolltech.qt.opengl.QGLWidget;
import com.trolltech.qt.core.*;

/**
 *
 * @author dmilith
 */
public class HexagonGenerator extends QGLWidget {

  private QPainter painter;
  private QSvgRenderer svgImg;
  private Hexagon myHex;

  HexagonGenerator() {
    super();
    this.show();
    myHex = new Hexagon( 0, 0, this );
    svgImg = myHex.getHexagon();
  }

  @Override
  public void paintEvent( QPaintEvent event ) {
    painter = new QPainter();
    painter.begin( this );
    paint( painter );
    painter.end();
  }

  public void paint( QPainter painter ) {
    svgImg.render( painter, new QRectF(100, 100, 34, 34 ) );
  }

  public static void main(String[] args) {
    QApplication.initialize(args);
    new HexagonGenerator();
    QApplication.exec();
  }

}

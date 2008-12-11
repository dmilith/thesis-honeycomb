/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.svg.QSvgWidget;
import com.trolltech.qt.opengl.QGLWidget;
import com.trolltech.qt.core.*;
import com.trolltech.qt.svg.QSvgRenderer;

/**
 *
 * @author dmilith
 */
public class HexagonGenerator extends QGLWidget {

  private QPainter painter;
  private Hexagon myHex;
  private int mouseX, mouseY, choosenObject = 0;

  private final int plusX = 250, plusY = 250;

  HexagonGenerator() {
    super();
    myHex = new Hexagon( 0, 0 );
    myHex.setParent(this);
    this.setGeometry(0, 0, plusX*2, plusY*2);
    this.show();
  }

  @Override
  public void paintEvent( QPaintEvent event ) {
    painter = new QPainter();
    painter.begin( this );
    paint( painter );
    painter.end();
  }

  public void paint( QPainter painter ) {
    myHex.render(painter, new QPoint(0,0));
  }

  public static void main(String[] args) {
    QApplication.initialize(args);
    new HexagonGenerator();
    QApplication.exec();
  }

  @Override
  public void mousePressEvent( QMouseEvent event ) {
    if ( event.button().equals( event.button().LeftButton ) ) {
      System.out.println( "Pozycja myszki w oknie: x:" + event.pos().x() + " - y:" + event.pos().y() );
      mouseX = event.pos().x();
      mouseY = event.pos().y();
      repaint();
    } else if ( event.button().equals( event.button().RightButton ) ) {
      for ( int i = 0; i < 1; i++ ) {
        if ( ( myHex.underMouse() ) && ( event.button().equals( event.button().RightButton )) ) {
          System.out.println( "Kliknąłeś na obiekt numer :" + i + "\nWybrano obiekt.");
          choosenObject = i;
        }
      }
    } else if ( event.button().equals( event.button().MidButton ) ) {
      System.out.println( "Wciśnięto środkowy przycisk myszy");
    }
  }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.opengl.QGLWidget;
import com.trolltech.qt.core.*;
import java.util.Vector;

/**
 *
 * @author dmilith
 */
public class HexagonGenerator extends QGLWidget {

  private QPainter painter;
  private Vector<Hexagon> myHexes;
  private int mouseX, mouseY, choosenObject = 0;

  private final int plusX = 250, plusY = 250;

  HexagonGenerator() {
    super();
    myHexes = new Vector<Hexagon>();
    myHexes.addElement( new Hexagon(  0,  0 ) );
    myHexes.addElement( new Hexagon(  1,  0 ) );
    myHexes.addElement( new Hexagon( -1,  0 ) );
    myHexes.addElement( new Hexagon(  0,  1 ) );
    myHexes.addElement( new Hexagon(  0, -1 ) );

    myHexes.addElement( new Hexagon(  1,  1 ) );
    myHexes.addElement( new Hexagon( -1, -1 ) );
    myHexes.addElement( new Hexagon(  2,  2 ) );
    myHexes.addElement( new Hexagon(  2,  1 ) );
    myHexes.addElement( new Hexagon(  3,  1 ) );

    for (int p = 0; p < myHexes.size(); p++ )
      myHexes.elementAt(p).setParent(this);
    this.setGeometry(600, 0, plusX*3, plusY*3);
    this.show();
  }

  @Override
  public void paintEvent( QPaintEvent event ) {
    painter = new QPainter();
    painter.begin( this );
    painter.setBackgroundMode( Qt.BGMode.TransparentMode );
    painter.setBackground( new QBrush( QColor.transparent, Qt.BrushStyle.SolidPattern ) );
    painter.setPen( Qt.PenStyle.SolidLine );
    painter.setPen( QColor.red );
    //painter.fillRect( 0, 0, WIDTH, HEIGHT, new QBrush( QColor.black, Qt.BrushStyle.SolidPattern ));
    painter.setClipping( true );
    painter.setRenderHint( QPainter.RenderHint.Antialiasing );
    painter.setRenderHint( QPainter.RenderHint.TextAntialiasing );
    paint( painter );
    painter.end();
  }

  public void paint( QPainter painter ) {
    for (int p = 0; p < myHexes.size(); p++ ) {
      myHexes.elementAt(p).render(painter, new QPoint( myHexes.elementAt(p).x(), myHexes.elementAt(p).y() ));
    }
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
      for (int p = 0; p < myHexes.size(); p++ ) {
        if ( ( myHexes.elementAt(p).underMouse() ) && ( event.button().equals( event.button().RightButton )) ) {
          System.out.println( "Kliknąłeś na obiekt numer :" + p + "\nWybrano obiekt.");
          choosenObject = p;
        }
      }
    } else if ( event.button().equals( event.button().MidButton ) ) {
      System.out.println( "Wciśnięto środkowy przycisk myszy");
    }
    //repaint();
  }

}

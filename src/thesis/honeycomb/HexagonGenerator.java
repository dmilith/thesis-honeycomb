/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;
import java.util.Vector;
import java.util.Date;

/**
 *
 * @author dmilith
 */
public class HexagonGenerator extends QMainWindow {

  private QPolygonF actualPolygon;
  private QGraphicsView scene;
  private QPainter painter;
  private Vector<Hexagon> myHexes;
  private int mouseX, mouseY, choosenObject = 0;

  private final int plusX = 250, plusY = 250;

  HexagonGenerator() {
    super();
    myHexes = new Vector<Hexagon>();
      Date time_start = new Date();
      for (int y = 0; y < 8; y++) {
        for (int x = 0; x < 8; x++) {
          myHexes.addElement( new Hexagon(  x,  y ) );
        }
    Date time_end = new Date();
    System.out.println( time_end.getTime() - time_start.getTime() );
    }
    for (int p = 0; p < myHexes.size(); p++ )
      myHexes.elementAt(p).setParent(this);
    this.setGeometry(600, 0, plusX*3, plusY*3);
    this.show();
  }

  @Override
  public void paintEvent( QPaintEvent event ) {
    painter = new QPainter();
    scene = new QGraphicsView(this);

    scene.setSceneRect(0, 0, plusX*3, plusX*3);
    scene.setCacheMode(QGraphicsView.CacheModeFlag.CacheBackground);
    painter.begin( this );

    painter.setBackgroundMode( Qt.BGMode.OpaqueMode );
  //  painter.fillRect( 0, 0, 500, 500, new QBrush( QColor.black, Qt.BrushStyle.SolidPattern ));
    painter.setRenderHint( QPainter.RenderHint.Antialiasing );
    painter.setOpacity(0.5);

    paint( painter );
    scene.render(painter);
    painter.end();
  }

  public void paint( QPainter painter ) {
    Date time_start = new Date();
    for (int p = 0; p < myHexes.size(); p++ ) {
      myHexes.elementAt(p).render(painter, new QPoint( myHexes.elementAt(p).x(), myHexes.elementAt(p).y() ));
    }
    Date time_end = new Date();
    System.out.print("Paint: ");
    System.out.println( time_end.getTime() - time_start.getTime() );
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
    } else if ( event.button().equals( event.button().RightButton ) ) {
      for (int p = 0; p < myHexes.size(); p++ ) {
        if ( ( myHexes.elementAt(p).underMouse() ) && ( event.button().equals( event.button().RightButton )) ) {
          System.out.println( "Kliknąłeś na obiekt numer :" + p + "\nWybrano obiekt.");
         // myHexes.remove( p );
          myHexes.addElement( new Hexagon( myHexes.elementAt(p).vX(), myHexes.elementAt(p).vY(), "hexagon-green.svg" ) );
        //  myHexes.elementAt(p).setParent(this);
          repaint();
        }
      }
    } else if ( event.button().equals( event.button().MidButton ) ) {
      System.out.println( "Wciśnięto środkowy przycisk myszy");
    }
  }

}

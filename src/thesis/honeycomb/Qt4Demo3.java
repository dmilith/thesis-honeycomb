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

public class Qt4Demo3 extends QGLWidget {

  private final int OBJECT_COUNT = 50;
  
  private QPainter painter;
  private int mouseX, mouseY, choosedObject = 0;
  private final int WIDTH = 800, HEIGHT = 600;
  private QMovie movie;
  private QFont font;
  private Vector<QLabel> placeContainer;
//  private Vector<QPixmap> pixmapContainer;
  private QSvgRenderer svgImg, transImg;

  Qt4Demo3() {
    super();
    placeContainer = new Vector<QLabel>();

    // this isn't required but may be useful
    QTextCodec.setCodecForCStrings( QTextCodec.codecForName( "UTF-8" ) );

    // movie
    QLabel label = new QLabel( this );
    movie = new QMovie( "classpath:images/fire.gif" );
    label.setMovie( movie );
    label.move( 100, 100 );
    movie.setSpeed( 40 );
    movie.setCacheMode( QMovie.CacheMode.CacheAll );
    movie.start();

  //  svgImg = new QSvgRenderer( "classpath:images/tux.svg", this );
  //  transImg = new QSvgRenderer( "classpath:images/box.svg", this );

    // adding labels to container
    for ( int i = 0; i < OBJECT_COUNT; i++ )
      placeContainer.add( i, new QLabel( this ) );

    font = new QFont( "Times", 28 );
    setWindowTitle( "Thesis HoneyComb" );
    setWindowOpacity( 0.3 );
    setGeometry( 0, 0, WIDTH, HEIGHT );
    setMaximumHeight( HEIGHT );
    setMaximumWidth( WIDTH );
    setMinimumHeight( HEIGHT );
    setMinimumWidth( WIDTH );
    show();
  }

  @Override
  public void paintEvent( QPaintEvent event ) {
    painter = new QPainter();
    painter.begin( this );
    paint( painter );
    painter.end();
  }


  private final int a = 32;
  private final int h = (int)( a * (Math.sqrt(3) / 2) );
  private final int l = 2 * h;
  int X = WIDTH/2;
  int Y = HEIGHT/2;

  public QPolygon getOneHoneyCombFrame( int x, int y ) {
    x += WIDTH/2;
    y += HEIGHT/2;
            
    // wierzchołek 1
    Vector<QPoint> points = new Vector<QPoint>();
    points.addElement( new QPoint( x + h/2 , y - h ) ); // w1
    points.addElement( new QPoint( x + a   , y     ) ); // w2
    points.addElement( new QPoint( x + h/2 , y + h ) ); // w3
    points.addElement( new QPoint( x - h/2 , y + h ) ); // w4
    points.addElement( new QPoint( x - a   , y     ) ); // w5
    points.addElement( new QPoint( x - h/2 , y - h ) ); // w6
    QPolygon hexagon = new QPolygon();
    for ( int i = 0; i < 6; i++ ) {
      hexagon.add( points.get(i) );
    }
    return hexagon;
  }
                                              
  public Vector<QPolygon> getRing( int ringNumber ) {
    int x = 0;
    int y = 0;
    int maxElements = 6 * ringNumber;
    Vector<QPolygon> elements = new Vector<QPolygon>();

    // wierzchołki..
    Vector<QPoint> ringPoints = new Vector<QPoint>();
    ringPoints.addElement( new QPoint( x + 3*a/2 , y - (int)(a * Math.sqrt(3)/2) ) ); // w1
    ringPoints.addElement( new QPoint( x + 3*a/2 , y + (int)(a * Math.sqrt(3)/2) ) ); // w2
    ringPoints.addElement( new QPoint( x         , y + 2*h                      )); // w3
    ringPoints.addElement( new QPoint( x - 3*a/2 , y + (int)(a * Math.sqrt(3)/2) ) ); // w4
    ringPoints.addElement( new QPoint( x - 3*a/2 , y - (int)(a * Math.sqrt(3)/2) ) ); // w5
    ringPoints.addElement( new QPoint( x         , y - 2*h                      ) ); // w6
    QPolygon hexagon = new QPolygon();
    for ( int i = 0; i < ringPoints.size(); i++ ) {
      hexagon = ( getOneHoneyCombFrame( ringPoints.elementAt(i).x() , ringPoints.elementAt(i).y() ) );
      elements.add(hexagon);
    }
    return elements;
  }


  public void paint( QPainter painter ) {
  //  painter.drawPoint( new QPoint( mouseX, mouseY ));
    placeContainer.elementAt( choosedObject ).move( mouseX, mouseY );
    painter.setBackgroundMode( Qt.BGMode.OpaqueMode );
    painter.setBackground( new QBrush( QColor.yellow, Qt.BrushStyle.SolidPattern ) );
    painter.setPen( Qt.PenStyle.SolidLine );
    painter.setPen( QColor.yellow );
    painter.fillRect( 0, 0, WIDTH, HEIGHT, new QBrush( QColor.black, Qt.BrushStyle.SolidPattern ));
  //  painter.setClipping( true );
  //  painter.setRenderHint( QPainter.RenderHint.Antialiasing );
  //  painter.setRenderHint( QPainter.RenderHint.TextAntialiasing );
   // painter.setFont( font );

    // root polygon
    painter.setPen( QColor.red );
    painter.drawPolygon( getOneHoneyCombFrame(0, 0), Qt.FillRule.WindingFill );
    painter.setPen( QColor.yellow );

     Vector<QPolygon> ring = getRing( 1 );
    for ( int z = 0; z< ring.size(); z++ ) {
      painter.drawPolygon(ring.elementAt(z));
    }
  }

  @Override
  public void mousePressEvent( QMouseEvent event ) {
    if ( event.button().equals( event.button().LeftButton ) ) {
      System.out.println( "Wciśnięto lewy przycisk myszy");
      System.out.println( "Pozycja myszki w oknie: x:" + event.pos().x() + " - y:" + event.pos().y() );
      mouseX = event.pos().x();
      mouseY = event.pos().y();
      repaint();
    } else if ( event.button().equals( event.button().RightButton ) ) {
      System.out.println( "Wciśnięto prawy przycisk myszy");
      for ( int i = 0; i < OBJECT_COUNT; i++ ) {
        if ( ( placeContainer.elementAt(i).underMouse() ) && ( event.button().equals( event.button().RightButton )) ) {
          System.out.println( "Kliknąłeś na obiekt numer :" + i + "\nWybrano obiekt.");
          choosedObject = i;
        }
      }
    } else if ( event.button().equals( event.button().MidButton ) ) {
      System.out.println( "Wciśnięto środkowy przycisk myszy");
    } 
  }

  public static void main( String args[] ) {
    QApplication.initialize( args );
    new Qt4Demo3();
    QApplication.exec();
  }

}

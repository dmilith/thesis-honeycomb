package thesis.honeycomb;

import java.util.Vector;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.opengl.QGLWidget;

/**
 *
 * @author Daniel <dmilith> Dettlaff
 * Created on Nov 25, 2008, 5:55:42 PM
 */

public class Qt4Demo extends QGLWidget {

  private QPainter painter;
  private int mouseX, mouseY, choosedObject = 0;
  private final int WIDTH = 800, HEIGHT = 600;
  private QMovie movie;
  private QFont font;
  private Vector<QLabel> placeContainer;
  private Vector<QPixmap> pixmapContainer;

  Qt4Demo() {
    super();
    placeContainer = new Vector<QLabel>();
    pixmapContainer = new Vector<QPixmap>();

    // this isn't required but may be useful
    QTextCodec.setCodecForCStrings( QTextCodec.codecForName( "UTF-8" ) );

    pixmapContainer.add( 0, new QPixmap("images/alco.jpg") );
    pixmapContainer.add( 1, new QPixmap("images/fire.gif") );

    for ( int i = 0; i < 10; i++ )
      placeContainer.add( i, new QLabel( this ) );

    for ( int i = 0; i < placeContainer.size(); i++ ) {
      placeContainer.elementAt(i).setPixmap( pixmapContainer.elementAt(0) );
      placeContainer.elementAt(i).move( 100*i, 200 );
      placeContainer.elementAt(i).setMouseTracking( true );
    }

   /*
    QLabel label = new QLabel( this );
    movie = new QMovie( "images/fire.gif" );
    label.setMovie( movie );
    label.move( 100, 100 );
    movie.setSpeed( 40 );
    movie.setCacheMode( QMovie.CacheMode.CacheAll );
    movie.start();
    */

    font = new QFont( "Times", 17 );
    setWindowTitle( "Thesis HoneyComb" );
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

    painter.setBackgroundMode( Qt.BGMode.OpaqueMode );
    painter.setBackground( new QBrush( QColor.yellow, Qt.BrushStyle.SolidPattern ) );
    painter.setPen( Qt.PenStyle.SolidLine );
    painter.setPen( QColor.red );
    painter.fillRect( 0, 0, WIDTH, HEIGHT, new QBrush( QColor.black, Qt.BrushStyle.SolidPattern ));
    painter.setClipping( true );
    painter.setRenderHint( QPainter.RenderHint.Antialiasing );
    painter.setRenderHint( QPainter.RenderHint.TextAntialiasing );
    painter.setFont( font );
    //  will cause SIGSEGV here:  painter.drawPixmap( 50, 50, myImage );
    painter.drawText( 600, 50, "Cześć załogo z utf8" );
    painter.drawLine( 100, 100, 620, 550 );
    painter.drawLine( 100, 100, 690, 460 );
    painter.drawLine( 690, 460, 620, 550 );
    paint( painter );
    
    painter.end();
  }

  public void paint( QPainter painter ) {
    painter.drawPoint( new QPoint( mouseX, mouseY ));
    placeContainer.elementAt( choosedObject ).move( mouseX, mouseY );
  }

  @Override
  public void mousePressEvent( QMouseEvent event ) {
    if ( event.button().equals( event.button().LeftButton ) ) {
      System.out.println( "Wciśnięto lewy przycisk myszy");
      System.out.println( "Pozycja myszki w oknie: x:" + event.pos().x() + " - y:" + event.pos().y() );
      mouseX = event.pos().x();
      mouseY = event.pos().y();
    } else if ( event.button().equals( event.button().RightButton ) ) {
      System.out.println( "Wciśnięto prawy przycisk myszy");
    } else if ( event.button().equals( event.button().MidButton ) ) {
      System.out.println( "Wciśnięto środkowy przycisk myszy");
    } 

    // 10 bo mamy 10 elementów..
    for ( int i = 0; i < 10; i++ ) {
      if ( ( placeContainer.elementAt(i).underMouse() ) && ( event.button().equals( event.button().RightButton )) ) {
        System.out.println( "Kliknąłeś na obiekt numer :" + i + "\nWybrano obiekt.");
        choosedObject = i;
      } 
    }

    repaint();
  }

  public static void main( String args[] ) {
    QApplication.initialize( args );
      Qt4Demo z = new Qt4Demo();
    QApplication.exec();
  }

}

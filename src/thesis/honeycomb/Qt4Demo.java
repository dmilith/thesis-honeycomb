package thesis.honeycomb;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.opengl.QGLWidget;

/**
 *
 * @author Daniel <dmilith> Dettlaff
 * Created on Nov 25, 2008, 5:55:42 PM
 */

public class Qt4Demo extends QGLWidget {

  static QPixmap myImage;
  static final int WIDTH = 800, HEIGHT = 600;

  Qt4Demo() {
    // this isn't required but may be useful
    QTextCodec.setCodecForCStrings( QTextCodec.codecForName( "UTF-8" ) );

    myImage = new QPixmap();
    myImage.load( "DoctorSaid.jpg" );
    
    setWindowTitle( "Thesis HoneyComb" );
    setGeometry( 0, 0, WIDTH, HEIGHT );
    show();
  }

  @Override
  public void paintEvent( QPaintEvent event ) {
    QPainter painter = new QPainter();
    painter.begin( this );

    painter.setBackgroundMode( Qt.BGMode.OpaqueMode );
    painter.setBackground( new QBrush( QColor.yellow, Qt.BrushStyle.SolidPattern ) );
    painter.setPen( Qt.PenStyle.SolidLine );
    painter.setPen( QColor.red );
    painter.fillRect( 0, 0, WIDTH, HEIGHT, new QBrush( QColor.black, Qt.BrushStyle.SolidPattern ));
    painter.setClipping( true );
    painter.setRenderHint( QPainter.RenderHint.Antialiasing );
    painter.setRenderHint( QPainter.RenderHint.TextAntialiasing );
    QFont font = new QFont( "Times", 17 );
    painter.setFont( font );
    painter.drawImage( 50, 50, myImage.toImage(), 0 );
    painter.drawText( 600, 50, "Cześć załogo z utf8" );
    painter.drawLine( 100, 100, 620, 550 );
    painter.drawLine( 100, 100, 690, 460 );
    painter.drawLine( 690, 460, 620, 550 );

    painter.end();
  }

  public static void main( String args[] ) {
    QApplication.initialize( args );

    new Qt4Demo();

    QApplication.exec(); 
  }

}

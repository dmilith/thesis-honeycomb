/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb;

import com.trolltech.qt.gui.*;

/**
 *
 * @author dmilith
 */
public class Qt4Demo2 extends QMainWindow {

  public void nameHere() {
    System.out.println("Kliknięty");
  }

/*
  loop = new GameLoop();

  Thread thread = new Thread(loop);
  loop.moveToThread(thread);
  */

  public static void main( String[] args ) {
    QApplication.initialize(args);
      Qt4Demo2 widget = new Qt4Demo2();
      QLineEdit edit = new QLineEdit( "Loren ipsum" );
      edit.setParent( widget );
      QPushButton button = new QPushButton();
      button.pressed.connect( widget, "nameHere()" );
      button.setParent( widget );
      edit.textChanged.connect( System.out, "println(String)" );
      edit.textChanged.connect( edit, "setWindowTitle(String)" );
      widget.show();
    QApplication.exec();
  }
  
}

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
public class Qt4Demo2 {

  public static void main( String[] args ) {
    QApplication.initialize(args);
    QLineEdit edit = new QLineEdit( "Loren ipsum" );
    edit.show();
    edit.textChanged.connect( System.out, "println(String)" );
    edit.textChanged.connect( edit, "setWindowTitle(String)" );
    QApplication.exec();
  }
  
}

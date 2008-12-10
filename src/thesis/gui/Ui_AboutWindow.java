/********************************************************************************
** Form generated from reading ui file 'about.jui'
**
** Created: Wed Dec 10 23:00:13 2008
**      by: Qt User Interface Compiler version 4.4.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package thesis.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_AboutWindow
{
    public QLabel label;
    public QLabel label_2;
    public QLabel label_3;
    public QLabel version_label;
    public QLabel label_4;
    public QLabel label_5;

    public Ui_AboutWindow() { super(); }

    public void setupUi(QWidget AboutWindow)
    {
        AboutWindow.setObjectName("AboutWindow");
        AboutWindow.resize(new QSize(268, 242).expandedTo(AboutWindow.minimumSizeHint()));
        AboutWindow.setMinimumSize(new QSize(268, 242));
        AboutWindow.setMaximumSize(new QSize(268, 242));
        AboutWindow.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        label = new QLabel(AboutWindow);
        label.setObjectName("label");
        label.setGeometry(new QRect(25, 30, 221, 41));
        QFont font = new QFont();
        font.setFamily("Lucida Sans");
        font.setPointSize(23);
        font.setBold(true);
        font.setWeight(75);
        label.setFont(font);
        label_2 = new QLabel(AboutWindow);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(60, 80, 151, 18));
        label_3 = new QLabel(AboutWindow);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(80, 105, 41, 18));
        QFont font1 = new QFont();
        font1.setPointSize(9);
        label_3.setFont(font1);
        version_label = new QLabel(AboutWindow);
        version_label.setObjectName("version_label");
        version_label.setGeometry(new QRect(130, 105, 36, 18));
        QFont font2 = new QFont();
        font2.setPointSize(9);
        version_label.setFont(font2);
        label_4 = new QLabel(AboutWindow);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(45, 165, 191, 26));
        label_5 = new QLabel(AboutWindow);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(35, 190, 226, 18));
        retranslateUi(AboutWindow);

        AboutWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget AboutWindow)
    {
        AboutWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("AboutWindow", "About HoneyComb"));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("AboutWindow", "HoneyComb"));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("AboutWindow", "Plaster Miodu na Ostro"));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("AboutWindow", "wersja"));
        version_label.setText(com.trolltech.qt.core.QCoreApplication.translate("AboutWindow", "0.0.0"));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("AboutWindow", "Autor: Daniel (dmilith) Dettlaff"));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("AboutWindow", "Program na licencji: GPLv2 i LGPL"));
    } // retranslateUi

}


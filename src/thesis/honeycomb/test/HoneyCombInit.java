/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thesis.honeycomb.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Created on 2008-11-25, 11:36:24
 * @author vara
 */
public class HoneyCombInit extends JFrame{

    private final Dimension windowInitSize = new Dimension(800, 600);

    public HoneyCombInit(){

        init();

        setSize(windowInitSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        
        setVisible(true);        
    }

    private void init(){
        Container content = getContentPane();
        HoneyCombCanvas canvas = new HoneyCombCanvas(windowInitSize);
        //Do something in canvas ...
        
        
        content.add(canvas,BorderLayout.CENTER);
    }
    public static void main(String ... arg){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new HoneyCombInit();
            }
        });
    }
}

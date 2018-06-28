package Publisher.View;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;

/**
 * Write a description of class Factral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factral extends JFrame
{
    private static MainApp canvas;
    private Koch canvas2;
    public Factral(){
        //canvas = new MainApp();
        //add(canvas);
        canvas2 = new Koch();
        add(canvas2);
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) { 
        Factral factral = new Factral();
        
    } 
}

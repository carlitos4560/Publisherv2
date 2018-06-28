package Publisher.View;

import Publisher.Controller.*;
import Publisher.Library.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Write a description of class Canvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainApp extends Canvas {
    private BufferedImage canvas;
    private LineBresemhan line;
    //private Color c;
    private double xp1=300;
    private double yp1=300;
    private double xp2=10;
    private double yp2=300;
    private double sin60=Math.sin(3.14/3.);
    private int nivel_de_recursividad=6;
    
    public MainApp()
    {
        setBackground(Color.BLACK);     
        this.canvas = new BufferedImage(600,400, BufferedImage.TYPE_INT_ARGB);
        paintRecursivo(nivel_de_recursividad,xp1,yp1,xp2,yp2,Color.GREEN);
    }
   //*******************************************************************************

   //*******************************************************************************
    public void paint(Graphics g){
        super.paint(g);
        //g.drawString("Lienzo de Dibujo Canvas",40,40);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(canvas,null,null);   
    }

    private void paintRecursivo(int i, double xp12, double yp12, double xp22, double yp22 ,Color c) {
      double dx=(xp22-xp12)/2.;
      double dy=(yp22-yp12)/2.;
      double xp32=xp12+dx-2*dy*sin60;
      double yp32=yp12+dy+2*dx*sin60;    
      double dx1=(xp22+xp12)/2.;
      double dy1=(yp22+yp12)/2.;
      double dx2=(xp32+xp22)/2.;
      double dy2=(yp32+yp22)/2.;
      double dx3=(xp12+xp32)/2.;
      double dy3=(yp12+yp32)/2.;
      if(i<=0){
           line((int)xp12,(int)yp12,(int)xp22,(int)yp22,c);
           line((int)xp22,(int)yp22,(int)xp32,(int)yp32,c);
           line((int)xp32,(int)yp32,(int)xp12,(int)yp12,c);
      }
      else{
           paintRecursivo(i-1,xp12,yp12,dx1,dy1,c);
           paintRecursivo(i-1,dx1,dy1,xp22,yp22,c);
           paintRecursivo(i-1,dx3,dy3,dx2,dy2,c);
      }
    }
     public void line(int x, int y, int x1, int y1,Color c){
        int color = c.getRGB();
        line = new LineBresemhan(new Point2D(x,y),new Point2D(x1,y1));
        line.drawLine();
        drawnPoint(line.getPoints(),color);
    }
     public void drawnPoint(ArrayList<Point2D> points,int color){
        for(Point2D p :points){
           this.canvas.setRGB(p.getX(),p.getY(),color);
           repaint();
        }        
    }    
}
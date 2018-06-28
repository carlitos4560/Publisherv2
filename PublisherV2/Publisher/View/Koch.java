package Publisher.View;

import Publisher.Controller.*;
import Publisher.Library.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Stack;

public class Koch extends Canvas{
     private BufferedImage canvas;
     private LineBresemhan line;      
     private double xp1=300;
     private double yp1=300;
     private double xp2=10;
     private double yp2=300;
     private double sin60=Math.sin(3.14/3.);
     private int nivel_de_recursividad=3;
    public Koch()
    {
        setBackground(Color.BLACK);     
        this.canvas = new BufferedImage(800,800, BufferedImage.TYPE_INT_ARGB);
        paintRecursivo(nivel_de_recursividad,xp1,yp1,xp2,yp2,Color.YELLOW);
    }
    public void paint(Graphics g){
        super.paint(g);
        //g.drawString("Lienzo de Dibujo Canvas",40,40);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(canvas,null,null);   
    }

     private void paintRecursivo(int i, double xp12, double yp12, double xp22, double yp22,Color c ){
         double dx=(xp22-xp12)/3.;
         double dy=(yp22-yp12)/3.;
         double xx=xp12+3*dx/2.-dy*sin60;
         double yy=yp12+3*dy/2.+dx*sin60;
         if(i<=0){
             line((int)xp12,(int)yp12,(int)xp22,(int)yp22,c);
         }
         else{
             paintRecursivo(i-1,xp12,yp12,xp12+dx,yp12+dy,c);
             paintRecursivo(i-1,xp12+dx,yp12+dy,xx,yy,c);
             paintRecursivo(i-1,xx,yy,xp22-dx,yp22-dy,c);
             paintRecursivo(i-1,xp22-dx,yp22-dy,xp22,yp22,c);
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
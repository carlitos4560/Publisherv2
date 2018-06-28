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
public class Canvas1 extends Canvas
{
    private BufferedImage canvas;
    private LineBresemhan line;
    private Triangle triangle;
    private Quadrilateral quadrilateral;
    private CircleBresenham circle;
    private Color colorFound;
    
    private final int pixelSize = 10;
    public Canvas1()
    {
        setBackground(Color.BLACK);     
    }
   //*******************************************************************************
    public void buffer(int height,int width){
         this.colorFound = Color.BLACK;    
         this.canvas = new BufferedImage(height,width, BufferedImage.TYPE_INT_ARGB);
         //line(0,0,50,50,Color.BLUE);
         // lineaTanslate(250,250,Color.RED);
         //lineScale(2,Color.RED);
         //lineScale(-2,Color.RED);
         /**************scalado de un triangulo*****************/
         
         //lineRote(45,Color.YELLOW);
         // triangle(100,50,150,100,75,100,Color.RED);
         //translateTriangle(200,400,Color.GREEN);
         //rotarTriangulo(180,Color.BLUE);
         //rotarTriangulo(90,Color.RED);
         //270rotarTriangulo(,Color.YELLOW);
         //scaleTriangle(2,Color.ORANGE);
         /***************Cruadrilatero*****************/
         quadrilateral(300,300,150,200,Color.YELLOW);
         translateQuadrilateral(10,10,Color.BLUE);
         scaleQuadrilateral(2,Color.RED);   
         /************** Para lo del criculo ya esta terminado * */
         // circle(200,200,20,Color.GREEN);
         // translateCircle(50,50,Color.GREEN);
         // scaleCircle(-10,Color.BLUE); 
         // scaleCircle(50,Color.RED);
         // scaleCircle(-20,Color.YELLOW); 
     }
    //*******************************************************************************
    public void paint(Graphics g){
        super.paint(g);
        //g.drawString("Lienzo de Dibujo Canvas",40,40);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(canvas,null,null);   
    }
    //*******************************************************************************  
    public void line(int x, int y, int x1, int y1,Color c){
        int color = c.getRGB();
        line = new LineBresemhan(new Point2D(x,y),new Point2D(x1,y1));
        line.drawLine();
        drawnPoint(line.getPoints(),color);
    }
    public void lineaTanslate(int x, int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = this.colorFound.getRGB();
        ArrayList<Point2D> aux = line.getPoints();
        drawnPoint(line.getPoints(),colorFoundDeault);
        line.translate(x,y);
        drawnPoint(line.getPoints(),color);
    }

    public void lineScale(int distands, Color c){
        int color = c.getRGB();
        int colorFoundDeault = this.colorFound.getRGB();
        ArrayList<Point2D> aux = line.getPoints();
        drawnPoint(line.getPoints(),colorFoundDeault);
        line.scaleAmpliacion(distands);            
        drawnPoint(line.getPoints(),color);       
     }
    
    public void lineRote(double angle,Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        drawnPoint(line.getPoints(),colorFoundDeault); 
        rote(line.getPoints(),angle);
        drawnPoint(line.getPoints(),color);
    }
    
    public void rote(ArrayList<Point2D> point, double angle){
        for(Point2D p : point){
            p.rotePoint(angle);
            //System.out.println(p.getX() + "" + p.getY());
        }
    }
  
    public void print(ArrayList<Point2D> print){
        System.out.println("x " + "  " + " y");    
        for(Point2D p : print){
            System.out.println(p.getX() + "  " + p.getY());
        }
    }
    
    
  //*******************************************************************************  
    public void triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c){
        int color = c.getRGB();
        triangle = new Triangle(new Point2D(x1,y1),new Point2D(x2,y2),new Point2D(x3,y3));
        drawnPoint(triangle.getPointTriangle(),color);
    }
    
    public void translateTriangle(int x, int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        ArrayList<Point2D> aux = triangle.getPointTriangle(); 
        //drawnPoint(aux,colorFoundDeault);
        triangle.translate(x,y);
        drawnPoint(triangle.getPointTriangle(),color);
    }
    public void scaleTriangle(int d, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        ArrayList<Point2D> aux = triangle.getPointTriangle();
        //drawnPoint(aux,colorFoundDeault);
        triangle.scaleTriangle(d);
        drawnPoint(triangle.getPointTriangle(),color);
    }
    public void rotarTriangulo(int angle, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        triangle.rotar(angle);
        drawnPoint(triangle.getPointTriangle(),color);
    }
    /*******************************************************************************/ 
    public void quadrilateral(int x1, int y1, int x2, int y2, Color c){
        int color = c.getRGB();
        quadrilateral = new Quadrilateral(new Point2D(x1,y1),new Point2D(x2,y2));
        quadrilateral.point2DQuadrilateral();
        drawnPoint(quadrilateral.getPoint2DQuadrilateral(),color);
    }   
    
    public void translateQuadrilateral(int x, int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        quadrilateral.point2DQuadrilateral();
        //drawnPoint(quadrilateral.getPoint2DQuadrilateral(),colorFoundDeault);
        quadrilateral.translate(x, y);
        drawnPoint(quadrilateral.getPoint2DQuadrilateral(),color);
    }
    public void scaleQuadrilateral(int d, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        quadrilateral.point2DQuadrilateral(); 
        //drawnPoint(quadrilateral.getPoint2DQuadrilateral(),colorFoundDeault);
        quadrilateral.scaleCuadrilatero(d);
        drawnPoint(quadrilateral.getPoint2DQuadrilateral(),color);
    }
    /*******************************************************************************/   
    public void circle(int xc, int yc, int radio, Color c){
        int color = c.getRGB();
        this.circle = new CircleBresenham(new Point2D(xc,yc),radio);
        drawnPoint(circle.calcule(),color);
    }

    public void translateCircle(int x,int y, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        drawnPoint(circle.getPoint2DCircle(),colorFoundDeault);
        circle.translation(x, y);
        drawnPoint(circle.getPoint2DCircle(),color);
    }
    public void scaleCircle(int d, Color c){
        int color = c.getRGB();
        int colorFoundDeault = colorFound.getRGB();
        drawnPoint(circle.getPoint2DCircle(),colorFoundDeault);
        circle.Scale(d);
        drawnPoint(circle.getPoint2DCircle(),color);
    }
    
        public void drawnPoint(ArrayList<Point2D> points,int color){
        for(Point2D p :points){
           this.canvas.setRGB(p.getX(),p.getY(),color);
           repaint();
        }        
    }    

    // public void paintSemilla(Point2D point,int color){   //pintado por semilla 
        // Point2D aux;
        // int colorFount = colorFound.getRGB();
        // if(colorFount != color){//Si el pixel p es del color de fondo
           // this.canvas.setRGB(point.getX(),point.getY(),color);
           // repaint();
           // aux = new Point2D(point.getX()-1,point.getY());
           // paintSemilla(aux,color);
           // //pixel de la izquierda
           // aux = new Point2D(point.getX()+1,point.getY());
           // paintSemilla(aux,color); 
           // //píxel de la derecha
           // aux = new Point2D(point.getX(),point.getY()-1);
           // paintSemilla(aux,color); 
           // //píxel inferior
           // aux = new Point2D(point.getX(),point.getY()+1);
           // paintSemilla(aux,color   );
           // //píxel superior                        
        // }
    // }
}

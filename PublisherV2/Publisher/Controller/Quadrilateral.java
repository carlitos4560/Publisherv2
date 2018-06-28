package Publisher.Controller;
import Publisher.Library.*;
import java.util.ArrayList;
import java.util.Stack;

public class Quadrilateral
{
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;
    private Point2D point4;
    private ArrayList<Point2D> point2DQuadrilateral;
    private LineBresemhan line1;
    private LineBresemhan line2;
    private LineBresemhan line3;
    private LineBresemhan line4;
    
    public Quadrilateral(Point2D point1,Point2D point3)
    {
        this.point1 = point1;
        this.point2 = new Point2D(point1.getX(),point3.getY());
        this.point3 = point3;
        this.point4 = new Point2D(point3.getX(),point1.getY());
        this.point2DQuadrilateral = new ArrayList<>();
        System.out.println(this.point1.getX()+" "+this.point1.getY()  + " puntos 1");
        System.out.println(this.point2.getX()+" "+this.point2.getY()  + " puntos 2");
        System.out.println(this.point3.getX()+" "+this.point3.getY()  + " puntos 3");
        System.out.println(this.point4.getX()+" "+this.point4.getY()  + " puntos 4");
        
    }
    public ArrayList<Point2D>getPoint2DQuadrilateral(){
        return point2DQuadrilateral;
    }
    public void setPoint1(Point2D p){
        this.point1 = p;
    }
    public void setPoint3(Point2D p){
        this.point3 = p;
    }
    public Point2D getPoint1(){
        return point1;
    }
    public Point2D getPoint2(){
        return point2;
    }
    public Point2D getPoint3(){
        return point3;
    }
    public Point2D getPoint4(){
        return point4;
    }
    public void point2DQuadrilateral(){
        line1 = new LineBresemhan(point1,point2);
        line1.drawLine();
        addPoinst(line1.getPoints());
        line2 = new LineBresemhan(point2,point3);
        line2.drawLine();
        addPoinst(line2.getPoints());
        line3 = new LineBresemhan(point3,point4);
        line3.drawLine();
        addPoinst(line3.getPoints());
        line4 = new LineBresemhan(point4,point1);
        line4.drawLine();
        addPoinst(line4.getPoints());
        //return point2DQuadrilateral;
    }
    public void addPoinst(ArrayList<Point2D> point){
        for(Point2D p : point){
            this.point2DQuadrilateral.add(p);
        }
    }
    public void translate(int x,int y){
        System.out.println("*************puntos iniciales********************************");
        System.out.println(this.point1.getX()+" "+this.point1.getY()  + " puntos 1");
        System.out.println(this.point2.getX()+" "+this.point2.getY()  + " puntos 2");
        System.out.println(this.point3.getX()+" "+this.point3.getY()  + " puntos 3");
        System.out.println(this.point4.getX()+" "+this.point4.getY()  + " puntos 4");
        this.point2DQuadrilateral.clear();
        point1.translate(x,y);
        point2.translate(x,y);
        point3.translate(x,y);
        point4.translate(x,y);
        line1.recalcular(point1,point2);
        addPoinst(line1.getPoints());
        line2.recalcular(point2,point3);
        addPoinst(line2.getPoints());
        line3.recalcular(point3,point4);
        addPoinst(line3.getPoints());
        line4.recalcular(point4,point1);
        addPoinst(line4.getPoints());
        System.out.println("*****Puntos trasladados**************************************");
        System.out.println(this.point1.getX()+" "+this.point1.getY()  + " puntos 1");
        System.out.println(this.point2.getX()+" "+this.point2.getY()  + " puntos 2");
        System.out.println(this.point3.getX()+" "+this.point3.getY()  + " puntos 3");
        System.out.println(this.point4.getX()+" "+this.point4.getY()  + " puntos 4");
        //point2DQuadrilateral();
    }
    public void scaleCuadrilatero(int d){
        this.point2DQuadrilateral.clear();
        point3.scaleAmplia(d);
        point2.setY(point3.getY());
        point4.setX(point3.getX());
        System.out.println("********************************************************************");
        System.out.println("apliacion del cuadrilatero");
        System.out.println(this.point1.getX()+" "+this.point1.getY()  + " puntos 1");
        System.out.println(this.point2.getX()+" "+this.point2.getY()  + " puntos 2");
        System.out.println(this.point3.getX()+" "+this.point3.getY()  + " puntos 3");
        System.out.println(this.point4.getX()+" "+this.point4.getY()  + " puntos 4");
        line1.recalcular(point1,point2);
        addPoinst(line1.getPoints());
        line2.recalcular(point2,point3);
        addPoinst(line2.getPoints());
        line3.recalcular(point3,point4);
        addPoinst(line3.getPoints());
        line4.recalcular(point4,point1);
        addPoinst(line4.getPoints());
        System.out.println("********************************************************************");
        System.out.println("new Puntos");
        System.out.println(this.point1.getX()+" "+this.point1.getY()  + " puntos 1");
        System.out.println(this.point2.getX()+" "+this.point2.getY()  + " puntos 2");
        System.out.println(this.point3.getX()+" "+this.point3.getY()  + " puntos 3");
        System.out.println(this.point4.getX()+" "+this.point4.getY()  + " puntos 4");
    }
    
    // public void scaleCuadrilatero(int d){
        // Point2D
        
        // this.point3.scaleAmplia(d);
        // System.out.println("/****************************/");
        // this.point2.setPoints(this.point1.getX(),this.point3.getY());
        // this.point4.setPoints(this.point3.getX(),this.point1.getY());
        // this.point2DQuadrilateral.clear();
        // point2DQuadrilateral();
        // System.out.println(this.point4.getX()+"  "+this.point4.getY());
        // System.out.println(this.point3.getX()+"  "+this.point3.getY());
        // System.out.println(this.point2.getX()+"  "+this.point2.getY());   
        // System.out.println(this.point1.getX()+"  "+this.point1.getY());
        
    // }
    
}

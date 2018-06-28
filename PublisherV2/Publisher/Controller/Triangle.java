package Publisher.Controller;
import Publisher.Library.*;
import Publisher.Controller.*;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Write a description of class Triangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangle
{
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;
    private ArrayList<Point2D> point2DTriangle;     
    private LineBresemhan line1;
    private LineBresemhan line2;
    private LineBresemhan line3;
    public Triangle(Point2D point1,Point2D point2,Point2D point3)
    {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point2DTriangle = new ArrayList<>();
    }
    public ArrayList<Point2D> getPointTriangle(){
        line1 = new LineBresemhan(point1,point2);
        line1.drawLine();
        addPoinst(line1.getPoints());
        line2 = new LineBresemhan(point1,point3);
        line2.drawLine();
        addPoinst(line2.getPoints());
        line3 = new LineBresemhan(point3,point2);
        line3.drawLine();
        addPoinst(line3.getPoints());
        return this.point2DTriangle;
    }
    public void scaleTriangle(int d){
        point2DTriangle.clear();
        if(d > 0){
            point1.scaleAmplia(d);
            point2.scaleAmplia(d);
            LineBresemhan line1 = new LineBresemhan(point1,point2);
            line1.drawLine();
            addPoinst(line1.getPoints());
            LineBresemhan line2 = new LineBresemhan(point1,point3);
            line2.drawLine();
            addPoinst(line2.getPoints());
            LineBresemhan line3 = new LineBresemhan(point3,point2);
            line3.drawLine();
            addPoinst(line3.getPoints());
        }
        else{
            point2.scaleAmplia(d);
            point3.scaleAmplia(d);
            LineBresemhan line1 = new LineBresemhan(point1,point2);
            line1.drawLine();
            addPoinst(line1.getPoints());
            LineBresemhan line2 = new LineBresemhan(point1,point3);
            line2.drawLine();
            addPoinst(line2.getPoints());
            LineBresemhan line3 = new LineBresemhan(point3,point2);
            line3.drawLine();
            addPoinst(line3.getPoints());
        }
    }
    public void addPoinst(ArrayList<Point2D> point){
        for(Point2D p : point){
            this.point2DTriangle.add(p);
        }
    }
    public void translate(int x,int y){
        // System.out.println("********************************************************************");
        // System.out.println(point1.getX()+" "+point1.getY());
        // System.out.println(point2.getX()+" "+point2.getY());
        // System.out.println(point3.getX()+" "+point3.getY());
        point1.translate(x,y);
        point2.translate(x,y);
        point3.translate(x,y);
        // System.out.println("********************************************************************");
        // System.out.println(point1.getX()+" "+point1.getY());
        // System.out.println(point2.getX()+" "+point2.getY());
        // System.out.println(point3.getX()+" "+point3.getY());
        for(Point2D p:this.point2DTriangle){
            p.translate(x,y);   
        }
    }
    public void rotar(int angle){
        int x,y, minX = 0, minY = 0;
        this.point2DTriangle.clear();
        
        Point2D point = new Point2D(point1.getX(), point1.getY());
        
        
        Point2D npoint1 = new Point2D(point1.getX()-point.getX(), point1.getY()-point.getY());
        Point2D npoint2 = new Point2D(point2.getX()-point.getX(), point2.getY()-point.getY());
        Point2D npoint3 = new Point2D(point3.getX()-point.getX(), point3.getY()-point.getY());
        
        System.out.println(npoint1.getX()+" ..- "+npoint1.getY());
        System.out.println(npoint2.getX()+" ..- "+npoint2.getY());
        System.out.println(npoint3.getX()+" ..- "+npoint3.getY());
        
        npoint1 = npoint1.rotePoint(angle);
        npoint2 = npoint2.rotePoint(angle);
        npoint3 = npoint3.rotePoint(angle);
        
        System.out.println(npoint1.getX()+" ..-.. "+npoint1.getY());
        System.out.println(npoint2.getX()+" ..-.. "+npoint2.getY());
        System.out.println(npoint3.getX()+" ..-.. "+npoint3.getY());
        
        System.out.println(point1.getX()+" -.. "+point1.getY());
        System.out.println(point2.getX()+" -.. "+point2.getY());
        System.out.println(point3.getX()+" -.. "+point3.getY());
        
        this.point1 = new Point2D(npoint1.getX()+point.getX(),npoint1.getY()+point.getY());
        this.point2 = new Point2D(npoint2.getX()+point.getX(),npoint2.getY()+point.getY());
        this.point3 = new Point2D(npoint3.getX()+point.getX(),npoint3.getY()+point.getY());
        
        System.out.println(point1.getX()+" - "+point1.getY());
        System.out.println(point2.getX()+" - "+point2.getY());
        System.out.println(point3.getX()+" - "+point3.getY());
        
        
    }
}

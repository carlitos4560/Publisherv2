package Publisher.Library;


/**
 * Write a description of class Point2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point2D
{
    private int x;
    private int y;
    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void setPoints(int x, int y){
        this.x =x;
        this.y =y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int[] getVectorP2D(){
        int [] vectorPoint2D = new int[2];
        vectorPoint2D[0] = this.x;
        vectorPoint2D[1] = this.y;
        return vectorPoint2D;
    }
    
    public void translate(int x1, int y1){
        this.x = this.x + x1;
        this.y = this.y + y1;
    }
    
    public void scaleAmplia(int d){
        this.x = this.x * d;
        this.y = this.y * d;
    }
    
    public void scaleReduce(double d){
        double x1,y1;
        x1=this.x;
        y1=this.y;
        x1 = (Math.round(x1/ d));
        y1 = (Math.round(y1/ d));
        this.x=(int)x1;
        this.y=(int)y1;
    }
    
    public Point2D rotePoint(double angle){
        
        double x1,y1;
        x1 = x;
        y1 = y;        
        //double rad = Math.toRadians(angle);
        //return new Point2D( 
        //(int)( (x1*Math.cos(rad))-(y1*Math.sin(rad)) )   ,
        //(int)( (x1*Math.sin(rad))+(y1*Math.cos(rad)) )     );       
        double alfa =  Math.toRadians(angle) ;
        x1 = x;
        y1 = y;        
        x1 = (x1 * Math.cos(alfa)) - (y1 * Math.sin(alfa));
        y1 = (x1 * Math.sin(alfa)) + (y1 * Math.cos(alfa));
        System.out.println("---- "+x1+" "+y1);
        this.x = (int)x1;
        this.y = (int)y1;
        return new Point2D(x,y);
    }

    public static void main(String [] args){
        Point2D p = new Point2D(50,50);
        p.rotePoint(90);
        System.out.println(p.getX()+" "+p.getY());
    }
    
    public int[] proyeccionX(int vx,int vy){
        int [] proyeccion = new int[2];
        int wx = x;
        int wy = y;
        int wv = (vx * wx) + (vy * wy);
        int vv = (vx * vx) + (vy * vy);
        int divide = wv / vv;
        proyeccion[0] = divide * vx;
        proyeccion[1] = divide * vy;;
        return proyeccion;
    }
}

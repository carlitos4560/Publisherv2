package Publisher.Controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Publisher.Library.*;
import java.util.ArrayList;
import java.util.Stack;

public class QuadrilateralTest
{
    Quadrilateral cuadrilatero;
    public QuadrilateralTest()
    {
        cuadrilatero = new Quadrilateral(new Point2D(0,0),new Point2D(50,50));
    }
    
    @Test
    public void testInicial(){
        Point2D point1 = new Point2D(0,0);
        Point2D point2 = new Point2D(0,50);
        Point2D point3 = new Point2D(50,50);
        Point2D point4 = new Point2D(50,0);
        assertEquals(point1,this.cuadrilatero.getPoint1());
        assertEquals(point1,this.cuadrilatero.getPoint1());
        assertEquals(point2,this.cuadrilatero.getPoint2());
        assertEquals(point2,this.cuadrilatero.getPoint2());
        assertEquals(point3,this.cuadrilatero.getPoint3());
        assertEquals(point3,this.cuadrilatero.getPoint3());
        assertEquals(point4,this.cuadrilatero.getPoint4());
        assertEquals(point4,this.cuadrilatero.getPoint4());
    }    
    // @Test
    // public void testTraslacion(){
        // Point2D point1 = new Point2D(0,0);
        // Point2D point2 = new Point2D(0,50);
        // Point2D point3 = new Point2D(50,50);
        // Point2D point4 = new Point2D(50,0);
    // }
    // @Test
    // public void testScalado(){
        // Point2D point1 = new Point2D(0,0);
        // Point2D point2 = new Point2D(0,50);
        // Point2D point3 = new Point2D(50,50);
        // Point2D point4 = new Point2D(50,0);
    // }
    // @Test
    // public void testRotacion(){
        // Point2D point1 = new Point2D(0,0);
        // Point2D point2 = new Point2D(0,50);
        // Point2D point3 = new Point2D(50,50);
        // Point2D point4 = new Point2D(50,0);
    // }
    // @Before
    // public void setUp()
    // {
    // }
    // @After
    // public void tearDown()
    // {
    // }
    // @Test
    // public void tespoint(){}
}

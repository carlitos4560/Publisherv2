/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Elipse{
    int centro_x;
    int centro_y;
    int a;
    int b;
    int aa;
    int aa_prima;
    int bb;
    int bb_prima;
    
    public Elipse (int x, int y, int l, int m){
        centro_x=x;
        centro_y=y;
        a=l;
        b=m;
        aa=centro_x+a;
        aa_prima=centro_x-a;
        bb=centro_y+b;
        bb_prima=centro_y-b;
    
        
    }
    public ArrayList <int[]> generar_puntos (){
        int [] y= new int [3];
        int aux=aa_prima;
        ArrayList <int[]> res= new ArrayList<int[]>();
        for(int i=0; i<(2*a)+1;i++){
            y=generar_y_dado_x (aux);
            aux=aux+1;
            res.add(y);
        }
        return res;
    }
            
    public int[] generar_y_dado_x (int x){
        int [] y= new int [3];
        double aux;
        aux= (Math.sqrt((Math.pow(b,2))*(1-((Math.pow(x-centro_x,2))/Math.pow(a,2)))));
        y[0]=x;
        y[1]=(int)(aux+centro_y);
        y[2]=(int)((aux*-1)+centro_y);
        System.out.println("X= "+y[0]+" y= "+y[1]+ " yp= "+y[2]+"jjj"+  aux);
        return y;
    }
    public void dibujar ( Graphics g,ArrayList<int[]> puntos){
        
        g.setColor(Color.red);
        //g.drawLine(20, 20, 30, 30);
        for (int i=0;i<puntos.size();i++){
            int[] y=puntos.get(i);
            g.drawLine(y[0],y[1],y[0],y[1]);
            g.drawRect(y[0], y[2], 1, 1);
        }
    }
}

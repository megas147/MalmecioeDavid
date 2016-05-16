/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/**
 *
 * @author Megas
 */
abstract class Forma extends JComponent {
    protected Point2D ponto;
    protected double raio;
    protected Color cor;
    
    public Forma(double x, double y, double t, Color c)
    {
        ponto = new Point2D.Double(x,y);
        raio = t;
        cor = c;
    }
    
    public void setPonto(Point2D ponto) {
        this.ponto = ponto;
    }
    
    public void setTamanho(double size) {
        this.raio = size;
    }
    
    public Point2D getPonto() {
        return ponto;
    }

    public double getRaio() {
        return raio;
    }

    public Color getCor() {
        return cor;
    }
    
    public void movePonto(double x, double y)
    {
        ponto = new Point2D.Double(x,y);
    }
    
    abstract Shape getForma();
}
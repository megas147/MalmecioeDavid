/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Megas
 */
public class Esfera{
    protected final Ellipse2D.Double circulo;
    private final Color cor;

    public Esfera(double x, double y, double raio, Color c)
    {
        circulo = new Ellipse2D.Double(x, y, raio, raio);
        cor = c;
    }
    
    public Point2D.Double getPonto()
    {
        return new Point2D.Double(circulo.getCenterX(), circulo.getCenterY());
    }

    public Color getCor() {
        return cor;
    }
    
    public void setX(double x)
    {
        circulo.x+=x;
    }
    
    public void setY(double y)
    {
        circulo.y+=y;
    }
    
    public Shape getCirculo()
    {
        return circulo;
    }
}

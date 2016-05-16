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
public class Esfera implements Mover{
    private final Ellipse2D.Double circulo;
    private final Point2D.Double ponto;
    private final Color cor;

    public Esfera(double x, double y, double raio, Color c)
    {
        circulo = new Ellipse2D.Double(x, y, raio, raio);
        ponto = new Point2D.Double(x, y);
        cor = c;
    }

    public Color getCor() {
        return cor;
    }

    public Point2D.Double getPonto() {
        return ponto;
    }
    
    @Override
    public void incrementaX()
    {
        circulo.x = circulo.x + 0.5;
        ponto.setLocation(circulo.x, circulo.y);
    }
    
    @Override
    public void decrementaX()
    {
        circulo.x = circulo.x - 0.5;
        ponto.setLocation(circulo.x, circulo.y);
    }
    @Override
    public void incrementaY()
    {
        circulo.y = circulo.y + 0.5;
        ponto.setLocation(circulo.x, circulo.y);
    }
    @Override
    public void decrementaY()
    {
        circulo.y = circulo.y - 0.5;
        ponto.setLocation(circulo.x, circulo.y);
    }
    
    public Shape getCirculo()
    {
        return circulo;
    }
}

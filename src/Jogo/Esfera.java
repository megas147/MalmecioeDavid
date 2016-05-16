/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Megas
 */
public class Esfera extends Forma{
    private Ellipse2D.Double circulo;
    
    public Esfera(double x, double y, double raio, Color cor)
    {
        super(x, y, raio, cor);
        circulo = new Ellipse2D.Double(x, y, raio, raio);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        //Renderiza as bordas do circulo(nao pixelizado)
        g2d.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);//anti-aliasing
        g2d.setColor(cor);
        g2d.fill(circulo);
    }
    
    public void setEllipseX(int x)
    {
        circulo.x = x;
    }
    
    public void setEllipseY(int y)
    {
        circulo.y = y;
    }
    
    @Override
    public Shape getForma()
    {
        return circulo;
    }
}

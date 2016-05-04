/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Megas
 */
public class Esfera extends Forma{
    private Point2D ponto;
    private double tamanho;
    
    public Esfera(Point2D point, double size)
    {
        super();
        ponto = point;
        tamanho = size;
    }

    public void setPonto(Point2D ponto) {
        this.ponto = ponto;
    }

    public Point2D getPonto() {
        return ponto;
    }

    public double getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(double size) {
        this.tamanho = size;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //Renderiza as bordas do circulo(nao pixelizado)
        g2d.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);//anti-aliasing
        Ellipse2D.Double circle = new Ellipse2D.Double(ponto.getX(), ponto.getY(), tamanho,tamanho);
        g2d.fill(circle);
    }
}

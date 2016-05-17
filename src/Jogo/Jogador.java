/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 *
 * @author Megas
 */
public class Jogador extends Esfera{
    private int raio;
    private Point2D localizacao;
    public Jogador(Point2D p, int r)
    {
        super((p.getX()-r), (p.getY()-r), 2*r, new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
        raio = r;
        localizacao = p;
    }
    
    public Point2D getLocalizacao()
    {
        return localizacao;
    }
    
    public void setLocalizacao(double x, double y)
    {
        localizacao.setLocation(x, y);
    }
    
    public int getRaio()
    {
        return raio;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.geom.Point2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Megas
 */
public class Painel extends JPanel implements Runnable{
    private Thread t;
    private final Esfera lista[];
    private final int tamanho = 11000;
    private int tamanhoInicialBolas;
    private Jogador jogador;
    private final int velocidade = 50;
    private final int nBolas = 7000;
    
    public Painel()
    {
        super();
        t = new Thread(this);
        this.setBackground(Color.white);
        lista = new Esfera[nBolas];
    }
    
    public void inserirTudo()
    {
        tamanhoInicialBolas = (this.getWidth()+this.getHeight())/6;
        float r,g,b;
        for(int i = 0; i < nBolas;i++)
        {
            r = (float)Math.random();
            g = (float)Math.random();
            b = (float)Math.random();
            if(r <= 0.5 && g <= 0.5 && b <= 0.5)
                r = (float) 0.75;
            lista[i] = new Esfera(Math.random()*(tamanho), Math.random()*(tamanho), tamanhoInicialBolas, new Color(r,g,b));
        }
        inserirJogador();
    }
    
    public final void inserirJogador()
    {
       Point2D p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
       jogador = new Jogador(p, 50);
    }
    
    public void jogar()
    {
        t.start();
    }
    
    public void updateBolas(double x, double y)
    {
        for(int i = 0; i < nBolas; i++)
        {
            lista[i].setX(x);
            lista[i].setY(y);
        }
    }
    
    public void moverJogador()
    {
        Point2D ponto = jogador.getPonto();
        Point2D localizacao = jogador.getLocalizacao();
        Point2D rato = MouseInfo.getPointerInfo().getLocation();
        int raio = jogador.getRaio();
        if((Math.abs(ponto.getX() - rato.getX()) <= raio) && (Math.abs(ponto.getY() - rato.getY()) <= raio))
            return;
        double ang = Math.atan2(rato.getX() - ponto.getX(), rato.getY() - ponto.getY());
        double x = (velocidade * Math.sin(ang)) * -1;
        double y = (velocidade * Math.cos(ang)) * -1;
        if(localizacao.getX() <= 0)
        {
            if(x < 0)
            {
                updateBolas(x,y);
                jogador.setLocalizacao((localizacao.getX()-x), (localizacao.getY()-y));
            }
            else
            {
                updateBolas(0,y);
                jogador.setLocalizacao(localizacao.getX(), (localizacao.getY()-y));
            }
            return;
        }
        if(localizacao.getX() >= tamanho)
        {
            if(x > 0)
            {
                updateBolas(x,y);
                jogador.setLocalizacao((localizacao.getX()-x), (localizacao.getY()-y));
            }
            else
            {
                updateBolas(0,y);
                jogador.setLocalizacao(localizacao.getX(), (localizacao.getY()-y));
            }
            return;
        }
        updateBolas(x,y);
        jogador.setLocalizacao((localizacao.getX()-x), (localizacao.getY()-y));
    }
       
    @Override
       public void run()
       {
           while(true)
           {
               moverJogador();
               this.repaint();
               try {
                   Thread.sleep(15);
               } catch (InterruptedException ex)
               {
                   //nao fazer nada
               }
           }
       }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //Renderiza as bordas do circulo(nao pixelizado)
        g2d.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);//anti-aliasing
        for(int i = 0; i < nBolas; i++)
        {
            g2d.setColor(lista[i].getCor());
            g2d.fill(lista[i].getCirculo());
        }
        g2d.fill(jogador.getCirculo());
    }
}

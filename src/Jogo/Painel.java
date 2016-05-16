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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Megas
 */
public class Painel extends JPanel implements Runnable{
    private Thread t;
    private final ArrayList<Esfera> lista;
    private final int tamanho = 11000;
    private int tamanhoInicialBolas;
    private Esfera jogador;
    private Point2D localizacao;
    private final int velocidade = 3;
    
    public Painel()
    {
        super();
        t = new Thread(this);
        this.setBackground(Color.white);
        lista = new ArrayList();
    }
    
    public void inserirTudo()
    {
        tamanhoInicialBolas = (this.getWidth()+this.getHeight())/6;
        for(int i = 0; i < 7000;i++)
            this.inserir();
        inserirJogador();
    }
    
    public final void inserirJogador()
    {
       Point2D p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
       jogador = new Esfera(p.getX(), p.getY(), 100, new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
       localizacao = p;
    }
    
    public void jogar()
    {
        t.start();
    }
    
    public void moverJogador()
    {
       Point2D pontoJogador = jogador.getPonto();
       Point2D rato = MouseInfo.getPointerInfo().getLocation();
       int t = lista.size();
       Esfera temp;
       //if(localizacao.getX() <= 0 || localizacao.getX() >= tamanho)
           //return;
      // if(localizacao.getY() <= 0 || localizacao.getY() >= tamanho)
           //return;
           
        if (pontoJogador.getX() > rato.getX())
       {
           for(int i = 0; i < t;i++)
           {
                temp = lista.get(i);
                temp.incrementaX(velocidade);
                lista.set(i, temp);
                localizacao.setLocation(localizacao.getX()+velocidade, localizacao.getY());
           }
       }
       else
       {
           for(int i = 0; i < t;i++)
           {
                temp = lista.get(i);
                temp.decrementaX(velocidade);
                lista.set(i, temp);
                localizacao.setLocation(localizacao.getX()-velocidade, localizacao.getY());
           }
       }
       
       if (pontoJogador.getY() > rato.getY())
       {
           for(int i = 0; i < t;i++)
           {
                temp = lista.get(i);
                temp.incrementaY(velocidade);
                lista.set(i, temp);
                localizacao.setLocation(localizacao.getX(), localizacao.getY()+velocidade);
           }
       }
       else
       {
           for(int i = 0; i < t;i++)
           {
                temp = lista.get(i);
                temp.decrementaY(velocidade);
                lista.set(i, temp);
                localizacao.setLocation(localizacao.getX(), localizacao.getY()-velocidade);
           }
       }
    }
       
    @Override
       public void run()
       {
           while(true)
           {
               moverJogador();
               this.repaint();
               try {
                   Thread.sleep(1);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Painel.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
    
    public final void inserir()
    {
        float r = (float)Math.random();
        float g = (float)Math.random();
        float b = (float)Math.random();
        if(r <= 0.5 && g <= 0.5 && b <= 0.5)
            r = (float) 0.75;
        lista.add(new Esfera(Math.random()*(tamanho), Math.random()*(tamanho), tamanhoInicialBolas, new Color(r,g,b)));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //Renderiza as bordas do circulo(nao pixelizado)
        /*g2d.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);//anti-aliasing*/
        lista.stream().map((a) -> {
            g2d.setColor(a.getCor());
            return a;
        }).forEach((a) -> {
            g2d.fill(a.getCirculo());
        });
        g2d.fill(jogador.getCirculo());
        repaint();
    }
}

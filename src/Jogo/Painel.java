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
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Megas
 */
public class Painel extends JPanel{
    protected ArrayList<Esfera> bolas = new ArrayList();
    private JogadorPrincipal jogador;
    protected ArrayList<Bot> bots = new ArrayList();
    private final int nBots = 100;
    protected final double tamanho = 10000;
    private final int nBolas = 2000;
    protected double xvisivel;
    protected double yvisivel;
    
    public Painel() {
       super();
       this.setBackground(Color.white);
    }
    
    public void inicializa() {
        Random r = new Random();
        for(int i = 0; i < nBolas; i++) {
            bolas.add(new Esfera(r.nextDouble()*(tamanho), r.nextDouble()*(tamanho), 15, new Color(r.nextFloat(), r.nextFloat(), r.nextFloat())));
        }
        jogador = new JogadorPrincipal(r.nextDouble()*(tamanho), r.nextDouble()*(tamanho), 50, this, new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
        for(int i = 0; i < nBots; i++) {
            bots.add(new Bot(r.nextDouble()*(tamanho), r.nextDouble()*(tamanho), 50, this, new Color(r.nextFloat(), r.nextFloat(), r.nextFloat())));
        }
        xvisivel = (jogador.getX()-getWidth()/2);
        yvisivel = (jogador.getY()-getHeight()/2);
    }
    
    public void inserirEsfera(int i)
    {
        Random r = new Random();
        bolas.set(i, new Esfera(r.nextDouble()*(tamanho), r.nextDouble()*(tamanho), 15, new Color(r.nextFloat(), r.nextFloat(), r.nextFloat())));
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        for(Esfera b:bolas)
            b.desenho(g2, xvisivel, yvisivel, getWidth(), getHeight());
        for(Esfera b:bots)
            b.desenho(g2, xvisivel, yvisivel, getWidth(), getHeight());
        jogador.desenho(g2, xvisivel, yvisivel);
        
    }
}

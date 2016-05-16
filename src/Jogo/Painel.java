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
import javax.swing.JPanel;

/**
 *
 * @author Megas
 */
public class Painel extends JPanel{
    private final ArrayList<Forma> lista;
    private final int largura = 11000;
    private final int altura = 11000;
    private int tamanhoInicialBolas;
    private Esfera jogador;
    
    public Painel()
    {
        super();
        this.setBackground(Color.white);
        lista = new ArrayList();
    }
    
    public void inserirTudo()
    {
        tamanhoInicialBolas = (this.getWidth()+this.getHeight())/6;
        for(int i = 0; i < 7000;i++)
            this.inserir();
        inserirJogador(tamanhoInicialBolas);
    }
    
    public final void inserirJogador(int raio)
    {
       jogador = new Esfera(this.getWidth(), this.getHeight(), raio, new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
    }
    
    public final void inserir()
    {
        float r = (float)Math.random();
        float g = (float)Math.random();
        float b = (float)Math.random();
        if(r <= 0.5 && g <= 0.5 && b <= 0.5)
            r = (float) 0.75;
        lista.add(new Esfera(Math.random()*(largura), Math.random()*(altura), tamanhoInicialBolas, new Color(r,g,b)));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //Renderiza as bordas do circulo(nao pixelizado)
        g2d.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);//anti-aliasing
        lista.stream().map((a) -> {
            g2d.setColor(a.getCor());
            return a;
        }).forEach((a) -> {
            g2d.fill(a.getForma());
        });
        g2d.fill(jogador.getForma());
    }
}

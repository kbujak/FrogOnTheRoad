package pl.edu.pk.frogOnTheRoad.board;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import pl.edu.pk.frogOnTheRoad.sprite.Frog;
import pl.edu.pk.frogOnTheRoad.sprite.Obstacle;
import pl.edu.pk.frogOnTheRoad.sprite.ObstacleMeta;

import java.util.Scanner;



public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Frog frog;
    private Image myBackground;
    private ArrayList<Obstacle> obstacles;
    private ObstacleMeta meta;
    private Random rand = new Random();
    private int level = 1;
    static int speed = 1;
    private boolean ingame;
    private boolean lost;
    private boolean win;
    private boolean continued;
    private final int B_WIDTH = 1000;
    private final int B_HEIGHT = 800;
    private final int FROG_X = B_WIDTH/2 - 90; // 500 - 90, 410 x zaby 
    private final int FROG_Y = B_HEIGHT - 90;	//710 pozycja y zaby
    private final int DELAY = 15;
    private final int META_X = 400;
    private final int META_Y = 0;
    private FactoryObstacle factory = new FactoryObstacle();
    private Facade facade = new Facade();
    Delays myDel = new Delays(0);
    
 

    

    public Board() {

        initBoard();
    }

    private void initBoard() {

    	//wzorzec projektowy obserwator
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        frog = new Frog(FROG_X, FROG_Y);
        initObstacles();
        ImageIcon ii = new ImageIcon("bg_honz2.png");
        myBackground = ii.getImage(); 
        initMeta();
        timer = new Timer(DELAY, this);
        timer.start();
        
        
    }

    public void initMeta() {
    	meta = new ObstacleMeta(META_X,META_Y);
    }
    
    
    public void initObstacles() {
    	
    	
    	obstacles = new ArrayList<>();
    	
    	//wzorzec projektowy fasada
    	//na podstawie poziomu dobiera ustawienie i szybkoœæ samochodów
    	facade.prepareForLevel(level, obstacles, 0);
    	
    	
    }

    
    //czêœæ widoku wzorca architektonicznego mvc
    //opisuje jak wyœwietliæ pewn¹ czêœæ modelu
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(ingame){ 
        
        	g.drawImage(myBackground, 0, 0, this);
            drawObjects(g);

        } 
        else {
        	if(win)
        		drawWin(g);        		
        	else
        		drawGameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (frog.isVisible()) {
            g.drawImage(frog.getImage(), frog.getX(), frog.getY(),
                    this);
        }
        
        if (meta.isVisible()) {
        	g.drawImage(meta.getImage(), meta.getX(), meta.getY(),
                    this);
        }

        for (Obstacle a : obstacles) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 30));
        g.drawString("Poziom: " + level, 5, 35);
        g.drawString("Zycie: " + frog.getLife(), 5, 65);
    }

    private void drawGameOver(Graphics g) {

    	
        String msg = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 40);
        FontMetrics fm = getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
        
       	
        	
        
        
    }
    
    private void drawWin(Graphics g) {

    	
        String msg = "Conratulations. You won!";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }
    
    

    //czêœæ logiczna wzorca architektonicznego mvc
    //stanowi model

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();
        updateFrog();
        updateObstacles();
        checkCollisions();
        repaint();
    }

    private void inGame() {
        
        if (!ingame) {
            timer.stop();
        }
    }

    private void updateFrog() {

        if (frog.isVisible()) {
            frog.move();
        }
    }


    private void updateObstacles() {

        if (obstacles.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < obstacles.size(); i++) {

        	Obstacle a = obstacles.get(i);
            if (a.isVisible()) {
            		a.moveLeft(speed);
            } else {
                obstacles.remove(i);
            }
        }
        
        
    }

    public void checkCollisions() {

        Rectangle r3 = frog.getBounds();
        Rectangle r1 = meta.getBounds();
        
        if(level == 8){
        	ingame = false;
        	win = true;
        }
        if(r3.intersects(r1)){
        	level+=1;
        	frog.initFrog(FROG_X, FROG_Y);
        	initObstacles();
        }
        
        for (Obstacle obstacle : obstacles) {
            Rectangle r2 = obstacle.getBounds();

            if (r3.intersects(r2)) {
            	
            	frog.setLife();
            	frog.initFrog(FROG_X, FROG_Y);           	
            	obstacles = new ArrayList<>();
            	facade.prepareForLevel(level, obstacles,1);
            	
            }
            if( frog.getLife() == 0){
            	
            	repaint();
                frog.setVisible(false);
                obstacle.setVisible(false);
                ingame = false;
            }
        }


    }

    //wzorzec projektowy obserwator
    //to jest obserwator
    //który jednoczeœnie stanowi czêœæ kontrolera we wzorcu architektonicznym mvc
    //dostaje od u¿ytkownika dane wejœciowe w postaci przycisków i powiadamia dalej
    private class TAdapter extends KeyAdapter {

    	//powiadomienie obserwatora
        @Override
        public void keyReleased(KeyEvent e) {
            frog.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            frog.keyPressed(e);
        }
    }
}
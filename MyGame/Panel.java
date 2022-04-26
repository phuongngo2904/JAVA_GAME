package MyGame;

import java.lang.System;
import java.lang.InterruptedException;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

import kb_inputs.KeyHandler;

public class Panel extends JPanel implements Runnable{
    //initilize screen settings
    private final int originalTileSize = 16;
    private final int scale=3;
    private final int tileSize = originalTileSize*scale;
    private final int maxScreenCol=16;
    private final int maxScreenRow=12;
    private final int screenWidth=tileSize*maxScreenCol;
    private final int screenHeight=tileSize*maxScreenRow;

    //player pos
    int player_X=100;
    int player_Y=100;
    int player_speed=4;

    //FPS
    private int FPS=60;

    KeyHandler key = new KeyHandler();

    Thread gameThread;
    public KeyHandler get_KeyHandler() {return key;}
    
    public Panel(){
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run(){
        double drawInterval = 1000000000/this.FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread!=null){
            
            update();
            repaint();
            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime/=1000000;

                if(remainingTime<0) {
                    remainingTime=0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime +=drawInterval;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if(key.upPressed==true){
            player_Y -= player_speed;
        }
        else if(key.downPressed==true){
            player_Y += player_speed;
        }
        else if(key.leftPressed==true){
            player_X -= player_speed;
        }
        else if(key.rightPressed==true){
            player_X += player_speed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(player_X, player_Y, tileSize, tileSize);
        g2.dispose();
    }
}

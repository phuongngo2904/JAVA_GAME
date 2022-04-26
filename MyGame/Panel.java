package MyGame;

import java.lang.System;
import java.lang.InterruptedException;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

import kb_inputs.KeyHandler;
import entity.Player;

public class Panel extends JPanel implements Runnable{
    //initilize screen settings
    private final int originalTileSize = 16;
    private final int scale=3;
    public final int tileSize = originalTileSize*scale;
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

    //Keyhandler
    KeyHandler key = new KeyHandler();
    public KeyHandler get_KeyHandler() {return key;}

    //thread
    Thread gameThread;

    //Player
    Player player = new Player(this, key);

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
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(gameThread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime = currentTime;
            if(delta>1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
    }
}

package MyGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
    //initilize screen settings
    private final int originalTileSize = 16;
    private final int scale=3;
    private final int tileSize = originalTileSize*scale;
    private final int maxScreenCol=16;
    private final int maxScreenRow=12;
    private final int screenWidth=tileSize*maxScreenCol;
    private final int screenHeight=tileSize*maxScreenRow;

    Thread gameThread;
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
        while(gameThread!=null){
            System.out.println("The game loop is running");
        }
    }
}

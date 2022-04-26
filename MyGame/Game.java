package MyGame;

import javax.swing.JFrame;

public class Game {
    private Window myWin;
    private Panel myPanel;
    private JFrame myFrame;
    public Game(){
        myWin = new Window();
        this.myPanel = new Panel();
        this.myFrame = myWin.get_JFrame();
        this.myFrame.add(this.myPanel);
        this.myFrame.pack();

    }
    public void runGame(){
        this.myPanel.startGameThread();
    }
}

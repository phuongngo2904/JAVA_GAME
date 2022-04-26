package MyGame;

import javax.swing.JFrame;

public class Window {
    private JFrame frame;

    public Window(){
        frame = new JFrame();
        frame.setTitle("2D Adventure");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


    }
    public JFrame get_JFrame() {return this.frame;}
}

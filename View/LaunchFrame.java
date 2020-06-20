package View;

import demo.Card;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchFrame extends JFrame
{
    private LaunchPane launchPane = new LaunchPane(this);
    private AdventurePane adventurePane = new AdventurePane(this);
    public void runLaunchPane(){
        setLayeredPane(launchPane);
    }
    public void runAdventurePane()
    {
        setLayeredPane(adventurePane);
        new Thread(adventurePane).start();
    }
    public LaunchFrame()
    {
        setVisible(true);
        setTitle("Plants VS Zombies");
        setBounds(100, 100, 810, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        LaunchFrame launchFrame = new LaunchFrame();
        launchFrame.runLaunchPane();
    }
}
package View;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchFrame extends JFrame
{
    private LaunchPane launchPane = new LaunchPane(this);
    private AdventurePane adventurePane;
    public void runLaunchPane(){
        launchPane = new LaunchPane(this);
        setLayeredPane(launchPane);
    }
    public void runAdventurePane()
    {
        adventurePane = new AdventurePane(this);
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
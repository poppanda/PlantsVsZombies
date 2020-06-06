//package PlantsVsZombies.Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LaunchFrame extends JFrame
{
    private JLayeredPane launchPane = new JLayeredPane();
    private void MyButton(JButton btn)
    {
        btn.setBorder(null);
        btn.setOpaque(false);
        btn.setVisible(true);
    }
    public LaunchFrame()
    {
        setTitle("Plants VS Zombies");
        setSize(810, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(launchPane);

        //BackGroud setting
        ImageIcon BGImage = new ImageIcon("../img/Background.png");
        JPanel BGImg = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(BGImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        launchPane.add(BGImg, 10);
        BGImg.setBounds(0, 0, getWidth(), getHeight());
        BGImg.setVisible(true);

        //Options setting
        //Adventure mode
        ImageIcon adventureIcon_Dark = new ImageIcon("../img/SelectorScreen_Adventure_highlight.png");
        ImageIcon adventureIcon_Light = new ImageIcon("../img/SelectorScreen_Adventure_highlight.png");
        JButton adventureIcon = new JButton(adventureIcon_Light);
        MyButton(adventureIcon);
        launchPane.add(adventureIcon, 0);
        adventureIcon.setBounds(410, 100, adventureIcon_Dark.getIconWidth(), adventureIcon_Dark.getIconHeight());
        adventureIcon.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent arg0)
            {
                adventureIcon.setIcon(adventureIcon_Light);
            }
            public void focusLost(FocusEvent arg0)
            {
                adventureIcon.setIcon(adventureIcon_Dark);
            }
        });
    }
    public static void main(String[] args)
    {
        LaunchFrame frame = new LaunchFrame();
        frame.setVisible(true);
    }
}
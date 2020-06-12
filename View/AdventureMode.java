package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdventureMode extends JLayeredPane
{
    final ImageIcon BGImg = new ImageIcon("../img/Background/Background_0.jpg");
    JPanel BGImgPanel = new JPanel(){
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(BGImg.getImage(), getBackgroundX(), 0, BGWidth, BGHeight, this);
        }
    };
    int BackGroundX, BackgroundY, BGWidth = 1400, BGHeight = 600;
    int getBackgroundX()
    {
        return BackGroundX;
    }
    public AdventureMode(JFrame frame)
    {
        frame.setLayeredPane(this);
        setBounds(0, 0, 810, 600);//frame.getWidth(), frame.getHeight());
        setVisible(true);
        add(BGImgPanel);
        BGImgPanel.setBounds(0, 0, getWidth(), getHeight());
        BGImgPanel.setVisible(true);
    }
}
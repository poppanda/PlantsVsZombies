package View;

import plant.*;
import zombies.*;
import java.awt.*;
import javax.swing.*;

public class AdventureMode extends JLayeredPane
{
    final ImageIcon BGImg = new ImageIcon("./img/Background/Background_0.jpg");
    JPanel BGImgPanel = new JPanel(){
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(BGImg.getImage(), (int)BackGroundX, (int)BackGroundY, BGWidth, BGHeight, this);
        }
    };
    private double BackGroundX = 0, BackGroundY = 0;
    private int BGWidth = 1400, BGHeight = 600;
    private void moveBG(int x, int y, int t)
    {
        int pics = t * 100;
        double dx = x - BackGroundX, dy = y - BackGroundY;
        double ax = 4 * dx / pics / pics, ay = 4 * dy / pics / pics;
        new Thread(()->{
            int pic = 0;
            for(double vx = -ax/2, vy = -ay/2; pic <= pics / 2; pic++, vx += ax, vy += ay)
            {
                try{
                    Thread.sleep(10);
                    BackGroundX += vx;
                    BackGroundY += vy;
                    BGImgPanel.repaint();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            for(double vx = ax*pics/2 - ax/2, vy = ay*pics/2 - ay/2; pic <= pics; pic++, vx -= ax, vy -= ay)
            {
                try{
                    Thread.sleep(10);
                    BackGroundX += vx;
                    BackGroundY += vy;
                    BGImgPanel.repaint();
                    System.out.println(BackGroundX + " " + BackGroundY);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            BackGroundX = (int)BackGroundX;
            BackGroundY = (int)BackGroundY;
            BGImgPanel.repaint();
        }).start();
    }
    // public void AddLabel(Zombie z)
    // {
    //     add(z, 9);
    // }
    public void AddPlant(CherryBomb p)
    {
        add(p , 10);
    }
    public AdventureMode(LaunchFrame frame)
    {
        frame.setLayeredPane(this);
        setBounds(0, 0, 810, 600);//frame.getWidth(), frame.getHeight());
        setVisible(true);
        add(BGImgPanel, 10);
        BGImgPanel.setBounds(0, 0, getWidth(), getHeight());
        BGImgPanel.setVisible(true);
        //moveBG(-590, 0, 3);
        zzombiee z = new zzombiee();
        add(z, 0);
        new Thread(z).start();
    }
}
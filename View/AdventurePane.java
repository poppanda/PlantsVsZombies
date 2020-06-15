package View;

import plant.*;
import zombies.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;

import java.util.concurrent.locks.*;

class PlantGroup extends JLabel implements Runnable
{
    private int x, y;
    private Thread before;
    private JButton startButton = new JButton();
    private final ImageIcon plantGroupIcon = new ImageIcon("./img/Screen/PlantGroupIcon.png");
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(PlantBarIcon.getImage(), x, y, this);
    }
    public PlantChoose(Thread before)
    {
        x = 0; y = 600;
        this.before = before;
        setBounds(0, 600 - plantGroupIcon.getIconHeight(), plantGroupIcon.getIconWidth(), plantGroupIcon.getIconHeight());
        setVisible(true);
    }
    public void run()
    {
        try{
            if(before != null) before.join();
            int time = 1000;
            double ny = y, v = -(double)plantGroupIcon.getIconHeight() / 100;
            while(time)
            {
                time -= 10;
                Thread.sleep(10);
                ny += v;
                y = (int)ny;
                repaint();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class PlantBar extends JLabel implements Runnable
{
    final ImageIcon plantBarIcon = new ImageIcon("./img/Screen/PlantBarIcon.png");
    int x, y;
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(plantBarIcon.getImage(), x, y, this);
    }
    public PlantBar(Thread before){

    }
    public void run(){
        try{
            if(before != null) before.join();
            int time = 1000;
            double ny = y, v = -(double)plantBarIcon.getIconHeight() / 100;
            while(time)
            {
                time -= 10;
                Thread.sleep(10);
                ny += v;
                y = (int)ny;
                repaint();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class AdventurePane extends JLayeredPane implements Runnable
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
    private static ReentrantLock lock = new ReentrantLock();
    private Thread moveBG(int x, int y, int t, Thread before)
    {
        int pics = t * 100;
        double dx = x - BackGroundX, dy = y - BackGroundY;
        double ax = 4 * dx / pics / pics, ay = 4 * dy / pics / pics;
        Thread move = new Thread(()->{
            lock.lock();
            try{
                if(before != null) before.join();
                int pic = 0;
                for(double vx = -ax/2, vy = -ay/2; pic <= pics / 2; pic++, vx += ax, vy += ay)
                {
                    Thread.sleep(10);
                    BackGroundX += vx;
                    BackGroundY += vy;
                    BGImgPanel.repaint();
                }
                for(double vx = ax*pics/2 - ax/2, vy = ay*pics/2 - ay/2; pic <= pics; pic++, vx -= ax, vy -= ay)
                {
                    Thread.sleep(10);
                    BackGroundX += vx;
                    BackGroundY += vy;
                    BGImgPanel.repaint();
                }
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }finally{
                lock.unlock();
                BackGroundX = (int)BackGroundX;
                BackGroundY = (int)BackGroundY;
                BGImgPanel.repaint();
            }
        });
        move.start();
        return move;
    }
    void AddZombie(ZombieTest zombie)
    {
        //zombie.setBounds(0, 0, 400, 400);
        zombie.setVisible(true);
        new Thread(zombie).start();
        add(zombie, 0);
    }
    public AdventurePane(LaunchFrame frame)
    {
        setBounds(0, 0, 810, 600);//frame.getWidth(), frame.getHeight());
        setVisible(true);
        add(BGImgPanel, -1);
        BGImgPanel.setBounds(0, 0, getWidth(), getHeight());
        BGImgPanel.setVisible(true);
    }
    public void run()
    {
        Thread moveToZombie = moveBG(-590, 0, 3, null);
        PlantChoose plantChoose = new PlantChoose(moveToZombie);
        add(plantChoose, 2);
        Thread chooseThread = new Thread(plantChoose);
        chooseThread.start();
        Thread moveToGrass = moveBG(400, 0, 2, moveToZombie);
    }
}
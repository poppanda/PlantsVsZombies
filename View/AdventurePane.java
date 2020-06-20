package View;

import demo.*;
import zombies.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;

import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class AdventurePane extends JLayeredPane implements Runnable
{
    static final long serialVersionUID = 1;
    Thread moveToZombie = moveBG(-590, 0, 3, null);
    Thread moveCardThread = null;
    PlantBar plantBar = new PlantBar(moveToZombie, this);
    PlantGroup plantGroup = new PlantGroup(moveToZombie);
    JButton startBtn = new JButton("./img/Screen/StartButton.png")
    {
        static final long serialVersionUID = 2;
    };
    final ImageIcon BGImg = new ImageIcon("./img/Background/Background_0.jpg");
    private JPanel BGImgPanel = new JPanel(){
        static final long serialVersionUID = 4;
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(BGImg.getImage(), (int)BackGroundX, (int)BackGroundY, BGWidth, BGHeight, this);
        }
    };
    private double BackGroundX = 0, BackGroundY = 0;
    private int BGWidth = 1400, BGHeight = 600;
    public final int GroupBoundX = 20, GroupBoundY = 50;
    public Cursor cursor;
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
        return move;
    }
    public void addCard(Card card)
    {
        plantGroup.AddCard(card);
        add(card, JLayeredPane.POPUP_LAYER, 0);
    }
    public Thread moveCard(Card card, int tarX, int tarY, int T)
    {
        return new Thread(()->{
            lock.lock();
            double vx = (double)(tarX - card.x) * 10 / T, vy = (double)(tarY - card.y) * 10 / T;
            double nx = card.x, ny = card.y;
            int time = T;
            try{
                while(time != 0)
                {
                    Thread.sleep(10);
                    time -= 10;
                    nx += vx;
                    ny += vy;
                    card.setLocation((int)nx, (int)ny);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
            card.setPosition(tarX, tarY);
        });
    }
    public void moveCardToBar(Card card)
    {
        plantBar.AddCard(card);
        plantGroup.RemoveCard(card);
        moveCardThread = moveCard(card, plantBar.getNextCardX(), plantBar.getNextCardY(), 100);
        moveCardThread.start();
    }
    public void setPlant(Card card)
    {
        
    }
    public void moveCardToGroup(Card card)
    {
        System.out.println(moveCardThread.isAlive());
        plantBar.RemoveCard(card);
        plantGroup.AddCard(card);
        moveCardThread = moveCard(card, GroupBoundX + card.GroupX, GroupBoundY + card.GroupY, 100);
        moveCardThread.start();
    }
    private void ShowPlants(Thread before)
    {
        new Thread(()->{
            try{
                before.join();
                Card cherryBomb = new DrawCherryBombCard(this);
                add(startBtn);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
    /*void AddZombie(Zombie zombie)
    {
        //zombie.setBounds(0, 0, 400, 400);
        zombie.setVisible(true);
        new Thread(zombie).start();
        add(zombie, 0);
    }*/
    public AdventurePane(LaunchFrame frame)
    {
        setBounds(0, 0, 810, 600);//frame.getWidth(), frame.getHeight());
        setVisible(true);
        add(BGImgPanel, JLayeredPane.DEFAULT_LAYER);
        BGImgPanel.setBounds(0, 0, getWidth(), getHeight());
        BGImgPanel.setVisible(true);
    }
    public void run()
    {
        moveToZombie.start();
        Thread barThread = new Thread(plantBar);
        Thread groupThread = plantGroup.moveTo(plantGroup.VisibleX, plantGroup.VisibleY, 500, moveToZombie);
        add(plantBar, JLayeredPane.POPUP_LAYER);
        add(plantGroup, JLayeredPane.POPUP_LAYER);
        barThread.start();
        groupThread.start();
        ShowPlants(groupThread);
        //Thread moveToGrass = moveBG(400, 0, 2, moveToZombie);
    }
}
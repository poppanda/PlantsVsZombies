package View;

import demo.*;
import zombies.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;

import java.util.Timer;
import java.util.LinkedList;
import java.util.TimerTask;
import java.util.concurrent.locks.*;

class Click implements MouseListener
{
    public boolean clicked;
    public int clickX, clickY;
    public void reset(){clicked = false;}
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == e.BUTTON1){
            clickX = e.getX();
            clickY = e.getY();
        }else{
            clickX = clickY = 0;
        }
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}

public class AdventurePane extends JLayeredPane implements Runnable
{
    Thread moveToZombie = moveBG(-590, 0, 3, null);
    Thread moveCardThread = null;
    PlantBar plantBar = new PlantBar(moveToZombie);
    PlantGroup plantGroup = new PlantGroup(moveToZombie);
    
    Click click = new Click();
    JButton startBtn = new JButton("./img/Screen/StartButton.png");
    final ImageIcon BGImg = new ImageIcon("./img/Background/Background_0.jpg");
    private JPanel BGImgPanel = new JPanel(){
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(BGImg.getImage(), (int)BackGroundX, (int)BackGroundY, BGWidth, BGHeight, this);
        }
    };
    private double BackGroundX = 0, BackGroundY = 0;
    private int BGWidth = 1400, BGHeight = 600;
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
    }
    public Thread moveCard(Card card, int tarX, int tarY, int T)
    {
        return new Thread(()->{
            lock.lock();
            double vx = (double)(tarX - card.x) * 10 / T, vy = (double)(tarY - card.y) * 10 / T;
            double nx = card.x, ny = card.y;
            try{
                while(T != 0)
                {
                    T -= 10;
                    nx += vx;
                    ny += vy;
                    card.setBounds((int)nx, (int)ny);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        });
    }
    public void moveCardToBar(Card card)
    {
        if(moveCardThread == null || (moveCardThread.isAlive() == false))
        {
            plantBar.AddCard(card);
            plantGroup.RemoveCard(card);
            moveCardThread = moveCard(card, plantBar.getNextCardX(), plantBar.getNextCardY(), 100);
            moveCardThread.start();
        }
    }
    public void setPlant(Card card)
    {
        Timer timer = new Timer();
        Graphics g = new Graphics();
        click.reset();
        addMouseListener(click);
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                if(click.clicked)
                {
                    timer.cancel();
                    timer.purge();
                }
                else
                {
                    g.dispose();
                }
            }
        }, 0, 10);
        removeMouseListener(click);
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
                Card[] cards ={
                    new DrawCherryBombCard(this),
                    new DrawPeaShooterCard(this),
                    new DrawRepeaterCard(this),
                    new DrawSnowPeaCard(this),
                    new DrawSunFlowerCard(this),
                    new DrawWallNutCard(this)
                    };
                add(startBtn);
                startBtn.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        Thread groupThread = plantGroup.moveTo(plantGroup.InvisibleX, plantGroup.InvisibleY, 100, null);
                        groupThread.start();
                    }
                });
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
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
        //Thread moveToGrass = moveBG(400, 0, 2, moveToZombie);
    }
}
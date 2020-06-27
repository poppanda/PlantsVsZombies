package View;

import demo.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.LinkedList;

public class PlantBar extends JLabel implements Runnable
{
    private final ImageIcon plantBarIcon = new ImageIcon("./img/Screen/PlantBarIcon.png");
    private Thread before;
    private final int cardX[], cardY, cardCapacity;
    private int x, y, cardsInBar;
    private LinkedList<Card> cards = new LinkedList<Card>();
    public boolean isFull = false;
    AdventurePane pane;
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(plantBarIcon.getImage(), 0, 0, plantBarIcon.getIconWidth(), plantBarIcon.getIconHeight(), this);
    }
    public PlantBar(Thread before, AdventurePane pane)
    {
        this.pane = pane;
        this.before = before;
        cardCapacity = 7;
        cardX = new int[]{0, 80, 132, 184, 236, 288, 340, 392, 444, 496};
        cardY = 7;
        cardsInBar = 0;
        x = 0;
        y = -plantBarIcon.getIconHeight();

        setBorder(null);
        setOpaque(false);
        setBounds(x, y, 1000, 1000);
        setVisible(true);
        repaint();
    }
    public void setFightState()
    {
        for(Card c : cards)c.setState(c.NORM_STATE);
    }
    public void run(){
        try{
            if(before != null) before.join();
            int time = 500;
            double ny = y, v = (double)plantBarIcon.getIconHeight() * 10 / time;
            while(time != 0)
            {
                time -= 10;
                Thread.sleep(10);
                ny += v;
                y = (int)ny;
                setLocation(x, y);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public boolean hasEmptyPosition(){return cards.size() < cardCapacity;}
    public int getNextCardX()
    {
        return cardX[cards.size()];
    }
    public int getNextCardY()
    {
        return cardY;
    }
    public void AddCard(Card card)
    {
        cards.add(card);
        if(cards.size() == cardCapacity)
        {
            isFull = true;
            pane.startBtn.setVisible(true);
        }
    }
    public void RemoveCard(Card card)
    {
        if(isFull)
        {
            isFull = false;
            pane.startBtn.setVisible(false);
        }
        int pos = cards.indexOf(card);
        cards.remove(card);
        for(int i = pos; i < cards.size(); i++)
        {
            Card c = cards.get(i);
            Thread move = pane.moveCard(c, cardX[i + 1], cardY, 100);
            move.start();
        }
    }
}
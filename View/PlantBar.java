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
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(plantBarIcon.getImage(), x, y, plantBarIcon.getIconWidth(), plantBarIcon.getIconHeight(), this);
    }
    public PlantBar(Thread before)
    {
        this.before = before;
        cardCapacity = 8;
        cardX = new int[]{10, 100};
        cardY = 50;
        cardsInBar = 0;
        x = 0;
        y = -plantBarIcon.getIconHeight();

        setBorder(null);
        setOpaque(false);
        setBounds(0, 0, 1000, 1000);
        setVisible(true);
        repaint();
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
                repaint();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
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
        if(cards.size() == cardCapacity)isFull = true;
    }
    public void RemoveCard(Card card)
    {
        int pos = cards.indexOf(card);
        cards.remove(card);
        for(int i = pos; i < cards.size(); i++)
        {
            Card c = cards.get(i);
            c.moveTo(cardX[i], cardY, 500);
        }
    }
}
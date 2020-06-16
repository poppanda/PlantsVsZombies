package View;

import demo.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.LinkedList;

public class PlantGroup extends JLabel
{
    private int x, y;
    public final int VisibleY, VisibleX, InvisibleX, InvisibleY;
    private Thread before;
    private JButton startButton = new JButton();
    private final ImageIcon plantGroupIcon = new ImageIcon("./img/Screen/PlantGroupIcon.png");
    private LinkedList<Card> cards = new LinkedList<Card>();
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //g.drawImage(plantGroupIcon.getImage(), 0, 0,plantGroupIcon.getIconWidth(), plantGroupIcon.getIconHeight(), this);
        g.drawImage(plantGroupIcon.getImage(), 0, 0,plantGroupIcon.getIconWidth(), 520, this);
    }
    public PlantGroup(Thread before)
    {
        this.before = before;
        VisibleX = 0;
        VisibleY = 80;
        InvisibleX = 0;
        InvisibleY = 600;
        x = InvisibleX;
        y = InvisibleY;
        setBounds(x, y, plantGroupIcon.getIconWidth(), 520);
        setVisible(true);
        repaint();
    }
    public Thread moveTo(int tarX, int tarY, int T, Thread before)
    {
        return new Thread(()->{
            if(before != null){
                try{
                    before.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            double vx = (tarX - x) * 10 / T, vy = (tarY - y) * 10 / T, nx = x, ny = y;
            int time = T;
            while(time != 0){
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                time -= 10;
                nx += vx;
                ny += vy;
                x = (int)nx;
                y = (int)ny;
                setLocation(x, y);
                System.out.println(x + " " + y);
            }
            setLocation(0, 80);
        });
    }
    public void AddCard(Card card)
    {
        cards.add(card);
    }
    public void RemoveCard(Card card)
    {
        cards.remove(card);
    }
}
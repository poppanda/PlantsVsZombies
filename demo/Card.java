package demo;

import View.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.*;

public class Card extends JButton
{
    private ImageIcon LightIcon, DarkIcon, FillIcon,PaintingIcon;
    Cursor cursor;
    private int x, y, FillTime;
    private final int GroupX, GroupY, GroupBoundX = 20, GroupBoundY = 120;
    private int state;
    final private int NORM_STATE = 1, DARK_STATE = 2, FILL_STATE = 3, IN_BAR = 4, IN_GROUP = 5;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(PaintingIcon.getImage(), 0, 0, PaintingIcon.getIconWidth(), PaintingIcon.getIconHeight(), this);
    }
    public void moveTo(int tarX, int tarY, int T)
    {
        double vx = (tarX - x) * 10 / T, vy = (tarY - y) * 10 / T, nx = x, ny = y;
        new Thread(()->{
            int time = T;
            while(time != 0){
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                time -= 10;
                x = (int)(nx - vx);
                y = (int)(ny - vy);
                setLocation(x, y);
            }
        });
    }
    public Card(PlantBar pb, PlantGroup pg, AdventurePane pane, int groupX, int groupY, int fillTime, ImageIcon lightIcon, ImageIcon darkIcon, ImageIcon fillIcon, ImageIcon CursorIcon)
    {
        super();
        PaintingIcon = LightIcon = lightIcon;
        DarkIcon = darkIcon;
        FillIcon = fillIcon;
        cursor = Toolkit.getDefaultToolkit().createCustomCursor(CursorIcon.getImage(), new Point(0, 0), "CardCursor");
        FillTime = fillTime;
        GroupX = groupX;
        GroupY = groupY;

        x = GroupX + GroupBoundX;
        y = GroupY + GroupBoundY;
        setBounds(x, y, lightIcon.getIconWidth(), lightIcon.getIconHeight());

        pg.AddCard(this);
        //pg.add(chosenLabel());
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(state == IN_GROUP){
                    pb.AddCard(Card.this);
                    pg.RemoveCard(Card.this);
                    moveTo(pb.getNextCardX(), pb.getNextCardY(), 500);
                    state = IN_BAR;
                }else if(state == IN_BAR){
                    pb.RemoveCard(Card.this);
                    pg.AddCard(Card.this);
                    moveTo(GroupX + GroupBoundX, GroupY + GroupBoundY, 500);
                    state = IN_GROUP;
                }else if(state == NORM_STATE){
                    pane.setCursor(cursor);
                    PaintingIcon = DarkIcon;
                    repaint();
                    new Thread(()->{
                        try
                        {
                            synchronized(pane.cursor)
                            {
                                pane.cursor.wait();
                            }
                            if(state == FILL_STATE)
                            {
                                JLabel fillLabel = new JLabel(FillIcon);
                                add(fillLabel);
                                int time = fillTime;
                                double fillX = FillIcon.getIconWidth(), fillY = 0, v = FillIcon.getIconHeight() * 10 / fillTime;
                                while(time != 0)
                                {
                                    time -= 10;
                                    fillY += v;
                                    fillLabel.setBounds(0, 0, (int)fillX, (int)fillY);
                                }
                                remove(fillLabel);
                                setState(NORM_STATE);
                                repaint();
                            }
                        }catch(InterruptedException err)
                        {
                            err.printStackTrace();
                        }
                    }).start();
                }
            }
        });
    }
    public void setState(int STATE)
    {
        state = STATE;
        if(state == NORM_STATE)
        {
            setEnabled(true);
            PaintingIcon = LightIcon;
            repaint();
        }
        else if(state == FILL_STATE)
        {
            setEnabled(false);
            PaintingIcon = FillIcon;
            repaint();
        }
    }
    public JLabel chosenLabel()
    {
        JLabel label = new JLabel(FillIcon);
        label.setLocation(GroupX, GroupY);
        label.setVisible(true);
        return label;
    }
}
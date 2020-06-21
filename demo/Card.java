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
import java.util.concurrent.locks.ReentrantLock;

public class Card extends JButton
{
    static final long serialVersionUID = 3;
    private ImageIcon LightIcon, DarkIcon, FillIcon,PaintingIcon;
    public final ImageIcon CursorIcon;
    private int w, h, FillTime, FISX, FIEX, FISY, FIEY;
    public int x, y;
    public final int GroupX, GroupY;
    private int state;
    private boolean isMoving = false;
    public final int NORM_STATE = 1, DARK_STATE = 2, FILL_STATE = 3, IN_BAR = 4, IN_GROUP = 5;
    private AdventurePane pane;
    private ActionListener click = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
            if(state == IN_GROUP){
                Card.this.removeActionListener(click);
                if(pane.moveCardToBar(Card.this))
                    state = IN_BAR;
                Card.this.addActionListener(click);
            }else if(state == IN_BAR){
                Card.this.removeActionListener(click);
                pane.moveCardToGroup(Card.this);
                state = IN_GROUP;
                Card.this.addActionListener(click);
            }else if(state == NORM_STATE){
                Card.this.removeActionListener(click);
                PaintingIcon = DarkIcon;
                repaint();
                pane.PlantPlainVisible();
                pane.setPlant(Card.this);
                Card.this.addActionListener(click);
            }else if(state == FILL_STATE){}
        }
    };
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(PaintingIcon.getImage(), 0, 0, PaintingIcon.getIconWidth(), PaintingIcon.getIconHeight(), this);
    }
    public Card(AdventurePane pane, int groupX, int groupY, int fillTime, ImageIcon lightIcon, ImageIcon darkIcon, ImageIcon fillIcon, ImageIcon cursorIcon)
    {
        this.pane = pane;
        PaintingIcon = LightIcon = lightIcon;
        DarkIcon = darkIcon;
        FillIcon = fillIcon;
        CursorIcon = cursorIcon;
        FillTime = fillTime;
        GroupX = groupX;
        GroupY = groupY;
        FISX = 0;
        FIEX = FillIcon.getIconWidth();
        FIEY = FillIcon.getIconHeight();

        x = GroupX + pane.GroupBoundX;
        y = GroupY + pane.GroupBoundY;
        w = lightIcon.getIconWidth();
        h = lightIcon.getIconHeight();
        setBounds(x, y, w, h);
        setVisible(true);
        state = IN_GROUP;

        pane.add(this, JLayeredPane.POPUP_LAYER, 0);
        pane.addCard(this);
        addActionListener(click);
    }
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    private void Fill()
    {
        JLabel filLabel = chosenLabel();
        pane.add(filLabel, JLayeredPane.POPUP_LAYER, 0);
        new Thread(()->{
            int time = FillTime;
            double vy = (double)FillIcon.getIconHeight() * 20 / time, ny = 0;
            while(time != 0)
            {
                time -= 20;
                ny += vy;
                FISY = FIEY - (int)ny;
                filLabel.repaint();
            }
            setState(NORM_STATE);
        }).start();
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
            Fill();
        }
    }
    public JLabel chosenLabel()
    {
        JLabel label = new JLabel(){
            @Override
            public void paintComponent(Graphics g)
            {
                g.drawImage(FillIcon.getImage(), FISX, FISY, FIEX, FIEY, FISX, FISY, FIEX, FIEY, this);
            }
        };
        label.setLocation(GroupX, GroupY);
        label.setVisible(true);
        return label;
    }
}
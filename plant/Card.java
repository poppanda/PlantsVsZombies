package plant;

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

public abstract class Card extends JButton
{
    static final long serialVersionUID = 3;
    private ImageIcon LightIcon, DarkIcon, FillIcon,PaintingIcon;
    public final ImageIcon CursorIcon;
    private int w, h, FillTime, FISX, FIEX, FISY, FIEY;
    public int x, y;
    public final int GroupX, GroupY;
    private int state;
    private boolean isMoving = false;
    public final int NORM_STATE = 1, DARK_STATE = 2, FILL_STATE = 3, IN_BAR = 4, IN_GROUP = 5, LOCK_STATE = 6;
    protected AdventurePane pane;
    private ActionListener click = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
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
            }else if(state == FILL_STATE){
            }
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

        pane.add(this, JLayeredPane.POPUP_LAYER, 1);
        pane.addCard(this);
        addActionListener(click);
    }
    abstract public plants CreatePlant(int X, int Y);
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    private void Fill()
    {
        JLabel fillLabel = chosenLabel();
        pane.add(fillLabel, JLayeredPane.POPUP_LAYER, 0);
        new Thread(()->{
            int time = FillTime;
            double vy = (double)FillIcon.getIconHeight() * 100 / time, ny = 0;
            while(time != 0)
            {
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                time -= 100;
                ny += vy;
                FISY = FIEY - (int)ny;
                fillLabel.repaint();
            }
            pane.remove(fillLabel);
            pane.repaint();
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
            PaintingIcon = DarkIcon;
            repaint();
            Fill();
        }
        else if(state == LOCK_STATE)
        {
            setEnabled(false);
            PaintingIcon = DarkIcon;
            repaint();
            removeActionListener(click);
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
        label.setBounds(x, y, w, h);
        label.setVisible(true);
        return label;
    }
    
    
}
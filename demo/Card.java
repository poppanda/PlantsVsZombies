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
    private ImageIcon LightIcon, DarkIcon, FillIcon,PaintingIcon;
    Cursor cursor;
    private int w, h, FillTime;
    public int x, y;
    final int GroupX, GroupY;
    private int state;
    private boolean isMoving = false;
    final private int NORM_STATE = 1, DARK_STATE = 2, FILL_STATE = 3, IN_BAR = 4, IN_GROUP = 5;
    private AdventurePane pane;
    private MouseListener click = new MouseListener()
    {
        @Override
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent arg0){}
        public void mouseClicked(MouseEvent e)
        {
            // Card.this.removeMouseListener(click);
            if(state == IN_GROUP){
                Card.this.removeMouseListener(click);
                Pane.moveCardToBar(Card.this);
                state = IN_BAR;
                Card.this.addMouseListener(click);
            }else if(state == IN_BAR){
                Card.this.removeMouseListener(click);
                Pane.moveCardToGroup(Card.this);
                state = IN_GROUP;
                Card.this.addMouseListener(click);
            }else if(state == NORM_STATE){
                Card.this.removeMouseListener(click);
                PaintingIcon = DarkIcon;
                repaint();
                pane.setPlant(Card.this);
                Card.this.removeMouseListener(click);
            }
            // Card.this.addMouseListener(click);
        }
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
    };
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(PaintingIcon.getImage(), 0, 0, PaintingIcon.getIconWidth(), PaintingIcon.getIconHeight(), this);
    }
    public Card(AdventurePane pane, int groupX, int groupY, int fillTime, ImageIcon lightIcon, ImageIcon darkIcon, ImageIcon fillIcon, ImageIcon CursorIcon)
    {
        this.pane = pane;
        PaintingIcon = LightIcon = lightIcon;
        DarkIcon = darkIcon;
        FillIcon = fillIcon;
        cursor = Toolkit.getDefaultToolkit().createCustomCursor(CursorIcon.getImage(), new Point(0, 0), "CardCursor");
        FillTime = fillTime;
        GroupX = groupX;
        GroupY = groupY;

        x = GroupX;
        y = GroupY;
        w = lightIcon.getIconWidth();
        h = lightIcon.getIconHeight();
        System.out.println(w + " " + h);
        setBounds(x, y, w, h);
        state = IN_GROUP;

        pane.addCard(this);
        addMouseListener(click);
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
package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AnimationTest extends JLabel implements Runnable
{
    private int pic = 0;
    AnimationTest()
    {
        setBounds(0, 0, 100, 100);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("./img/Plants/CherryBomb/CherryBomb_" + pic + ".png").getImage(),0 , 0, 100, 100, this);
    }
    public void run()
    {
        while(true)
        {
            try{
                Thread.sleep(100);
                pic = (pic + 1) % 7;
                g.repaint();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
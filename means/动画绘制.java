import java.awt.Graphics;

import javax.swing.*;

public class Zombie extends JLabel implements Runnable
{
    private int life;
    @Override
    public void run()
    {
        Graphics g = getGraphics();
        int imgNum;//the number of images
        ImageIcon[] imgs;
        while(life > 0)
        {
            try
            {
                g.drawImage(img[i%imgNum], x, y, width, height,this);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyButton extends JButton
{
    private boolean focus;
    private int iconWidth, iconHeight;
    private final ImageIcon lightIcon, darkIcon;
    MyButton(int iconWidth, int iconHeight, ImageIcon lighIcon, ImageIcon darkIcon)
    {
        this.lightIcon = lighIcon;
        this.darkIcon = darkIcon;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
        setBorder(null);
        setOpaque(false);
        setVisible(true);
        focus = false;
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(isFocused())
            g.drawImage(lightIcon.getImage(),
                        0, 0, 
                        getBtnWidth(), getBtnHeight(),
                        this);
        else g.drawImage(darkIcon.getImage(), 
                         0, 0, 
                         getBtnWidth(), getBtnHeight(), 
                         this);
    }
    void gainFocus(){focus = true;}
    void loseFocus(){focus = false;}
    int getBtnWidth(){return iconWidth;}
    int getBtnHeight(){return iconHeight;}
    boolean isFocused(){return focus;}
}

public class LaunchFrame extends JFrame
{
    private JLayeredPane launchPane = new JLayeredPane();
    public LaunchFrame()
    {
        setTitle("Plants VS Zombies");
        setSize(810, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(launchPane);

        //BackGroud setting
        ImageIcon BGImage = new ImageIcon("./img/Screen/MainMenu.png");
        JPanel BGImg = new JPanel()//Draw BackGround
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(BGImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        launchPane.add(BGImg, 10);
        BGImg.setBounds(0, 0, getWidth(), getHeight());
        BGImg.setVisible(true);
        //Options setting
        //Adventure mode
        final ImageIcon adventureIcon_Dark = new ImageIcon("./img/Screen/Adventure_1.png");
        final ImageIcon adventureIcon_Light = new ImageIcon("./img/Screen/Adventure_0.png");
        MyButton adventureBtn = new MyButton(340, 120, adventureIcon_Light, adventureIcon_Dark);
        adventureBtn.setBounds(410, 80, adventureBtn.getBtnWidth(), adventureBtn.getBtnHeight());
        launchPane.add(adventureBtn, 0);
        adventureBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                adventureBtn.gainFocus();
                adventureBtn.repaint();
            }
            public void mouseExited(MouseEvent arg0)
            {
                adventureBtn.loseFocus();
                adventureBtn.repaint();
            }
            public void mouseClicked(MouseEvent e){}
            public void mousePressed(MouseEvent e)
            {
                adventureBtn.loseFocus();
                adventureBtn.repaint();
            }
            public void mouseReleased(MouseEvent e)
            {
                String flag = "Advecture mode start";
                Thread twinkle = new Thread(()->{
                    int times = 10;
                    try
                    {
                        while(times != 0)
                        {
                            Thread.sleep(100);
                            adventureBtn.loseFocus();
                            adventureBtn.repaint();
                            Thread.sleep(100);
                            adventureBtn.gainFocus();
                            adventureBtn.repaint();
                            times--;
                        }
                        synchronized(flag)
                        {
                            flag.notify();
                        }
                    }
                    catch(InterruptedException err)
                    {
                        err.printStackTrace();
                    }
                });
                twinkle.start();
                new Thread(()->{
                    try
                    {
                        synchronized(flag)
                        {
                            flag.wait();
                        }
                        new AdventureMode(LaunchFrame.this);
                    }
                    catch(InterruptedException err)
                    {
                        err.printStackTrace();
                    }
                }).start();
            }
        });
        //Options right down
        final ImageIcon helpIcon_Dark = new ImageIcon("./img/Screen/SelectorScreen_Help1.png");
        final ImageIcon helpIcon_Light = new ImageIcon("./img/Screen/SelectorScreen_Help2.png");
        final ImageIcon optionIcon_Dark = new ImageIcon("./img/Screen/SelectorScreen_Options1.png");
        final ImageIcon optionIcon_Light = new ImageIcon("./img/Screen/SelectorScreen_Options2.png");
        final ImageIcon quitIcon_Dark = new ImageIcon("./img/Screen/SelectorScreen_Quit1.png");
        final ImageIcon quitIcon_Light = new ImageIcon("./img/Screen/SelectorScreen_Quit2.png");
        MyButton helpBtn = new MyButton(40, 20, helpIcon_Light, helpIcon_Dark);
        launchPane.add(helpBtn, 0);
        helpBtn.setBounds(590, 500, helpBtn.getBtnWidth(), helpBtn.getBtnHeight());
        helpBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                helpBtn.gainFocus();
                helpBtn.repaint();
            }
            public void mouseExited(MouseEvent arg0)
            {
                helpBtn.loseFocus();
                helpBtn.repaint();
            }
            public void mouseClicked(MouseEvent e)
            {
                new Thread(()->{
                    JLabel developer = new JLabel();
                    developer.setText("开发人员：曹雨薇 牛冰冰 潘曲阳");
                    developer.setBounds(300, 200, 400, 50);
                    Font font = new Font("宋体", Font.PLAIN, 20);
                    developer.setFont(font);
                    launchPane.add(developer, 0);
                    try{
                        Thread.sleep(3000);
                    }
                    catch(InterruptedException err)
                    {
                        err.printStackTrace();
                    }
                    launchPane.remove(developer);
                    launchPane.repaint();
                    System.out.print("HAHA");
                }).start();
            }
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
        MyButton optionBtn = new MyButton(40, 20, optionIcon_Light, optionIcon_Dark);
        launchPane.add(optionBtn, 0);
        optionBtn.setBounds(660, 525, optionBtn.getBtnWidth(), optionBtn.getBtnHeight());
        optionBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                optionBtn.gainFocus();
                optionBtn.repaint();
            }
            public void mouseExited(MouseEvent arg0)
            {
                optionBtn.loseFocus();
                optionBtn.repaint();
            }
            public void mouseClicked(MouseEvent e){}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
        MyButton quitBtn = new MyButton(40, 20, quitIcon_Light, quitIcon_Dark);
        launchPane.add(quitBtn, 0);
        quitBtn.setBounds(730, 515, quitBtn.getBtnWidth(), quitBtn.getBtnHeight());
        quitBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                quitBtn.gainFocus();
                quitBtn.repaint();
            }
            public void mouseExited(MouseEvent arg0)
            {
                quitBtn.loseFocus();
                quitBtn.repaint();
            }
            public void mouseClicked(MouseEvent e){System.exit(0);}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
    }
}
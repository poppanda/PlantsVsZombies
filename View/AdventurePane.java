package View;

import demo.*;
import zombies.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Timer;
import java.util.LinkedList;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class AdventurePane extends JLayeredPane implements Runnable {
    Thread moveToZombie = moveBG(-590, 0, 3, null);
    Thread moveCardThread = null;
    Thread battleThread;
    LaunchFrame frame;
    PlantBar plantBar = new PlantBar(moveToZombie, this);
    PlantGroup plantGroup = new PlantGroup(moveToZombie);
    Battle battle = new Battle(this);
    AddPlantPlain addPlantPlain = new AddPlantPlain();
    Blur blur = new Blur();

    JButton startBtn = new JButton(new ImageIcon("./img/Screen/StartButton.png"));
    final ImageIcon BGImg = new ImageIcon("./img/Background/Background_0.jpg");
    private JPanel BGImgPanel = new JPanel() {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(BGImg.getImage(), (int) BackGroundX, (int) BackGroundY, BGWidth, BGHeight, this);
        }
    };
    private double BackGroundX = 0, BackGroundY = 0;
    private int BGWidth = 1400, BGHeight = 600;
    public int GroupBoundX = 15, GroupBoundY = 50;
    private static ReentrantLock lock = new ReentrantLock();
    public AdventurePane(LaunchFrame frame) {
        this.frame = frame;
        setBounds(0, 0, 810, 600);
        setVisible(true);
        add(BGImgPanel, JLayeredPane.DEFAULT_LAYER);
        BGImgPanel.setBounds(0, 0, getWidth(), getHeight());
        BGImgPanel.setVisible(true);
    }
    private Thread moveBG(int x, int y, int t, Thread before) {
        int pics = t * 50;
        double dx = x - BackGroundX, dy = y - BackGroundY;
        double ax = 4 * dx / pics / pics, ay = 4 * dy / pics / pics;
        Thread move = new Thread(() -> {
            lock.lock();
            try {
                if (before != null) before.join();
                int pic = 0;
                for (double vx = -ax / 2, vy = -ay / 2; pic <= pics / 2; pic++, vx += ax, vy += ay) {
                    Thread.sleep(20);
                    BackGroundX += vx;
                    BackGroundY += vy;
                    BGImgPanel.repaint();
                }
                for (double vx = ax * pics / 2 - ax / 2, vy = ay * pics / 2 - ay / 2; pic <= pics; pic++, vx -= ax, vy -= ay) {
                    Thread.sleep(20);
                    BackGroundX += vx;
                    BackGroundY += vy;
                    BGImgPanel.repaint();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                BackGroundX = (int) BackGroundX;
                BackGroundY = (int) BackGroundY;
                BGImgPanel.repaint();
            }
        });
        return move;
    }
    public void addCard(Card card) {
        plantGroup.AddCard(card);
    }
    public void addSunshine(Sun_Shine s) {
        add(s, JLayeredPane.DRAG_LAYER);
        battle.addSunshine(s);
    }
    public Thread moveCard(Card card, int tarX, int tarY, int T) {
        return new Thread(() -> {
            lock.lock();
            double vx = (double)(tarX - card.x) * 20 / T,
            vy = (double)(tarY - card.y) * 20 / T;
            double nx = card.x,
            ny = card.y;
            int time = T;
            try {
                while (time != 0) {
                    Thread.sleep(20);
                    time -= 20;
                    nx += vx;
                    ny += vy;
                    card.setLocation((int) nx, (int) ny);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            card.setPosition(tarX, tarY);
        });
    }
    Point getGrid() {
        int locX = addPlantPlain.coor.point.x, locY = addPlantPlain.coor.point.y;
        if (locX >= 55 && locX <= 775 && locY >= 100 && locY <= 585) {
            int gridX, gridY;
            gridX = (locX - 55) / 80;
            gridY = (locY - 100) / 97;
            if (battle.hasPlant[gridX][gridY] == false) {
                locX = (locX - 55) / 80 * 80 + 55;
                locY = (locY - 100) / 97 * 97 + 100;
            } else {
                locX = -500;
                locY = -500;
            }
        } else {
            locX = addPlantPlain.coor.point.x - (blur.blur.getWidth(blur)) / 2;
            locY = addPlantPlain.coor.point.y - (blur.blur.getHeight(blur)) / 2;
        }
        return new Point(locX, locY);
    }
    public void PlantPlainVisible() {
        add(blur, JLayeredPane.DRAG_LAYER, 0);
        add(addPlantPlain, JLayeredPane.DRAG_LAYER, 0);
    }
    public void setPlant(Card card) {
        Timer timer = new Timer();
        blur.setBlur(card.CursorIcon);
        addPlantPlain.click.reset();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (addPlantPlain.click.clicked) {
                    timer.cancel();
                    timer.purge();
                    int locX = addPlantPlain.click.clickP.x,
                        locY = addPlantPlain.click.clickP.y;
                    if (locX >= 55 && locX <= 775 && locY >= 100 && locY <= 585) {
                        int gridX, gridY;
                        gridX = (locX - 55) / 80;
                        gridY = (locY - 100) / 97;
                        if (battle.hasPlant[gridX][gridY] == false) {
                            battle.hasPlant[gridX][gridY] = true;
                            locX = (locX - 55) / 80 * 80 + 55;
                            locY = (locY - 100) / 97 * 97 + 100;
                            plants nxt = card.CreatePlant(locX, locY);
                            battle.addPlant(nxt);
                            card.setState(card.FILL_STATE);
                        } else {
                            card.setState(card.NORM_STATE);
                        }
                    } else {
                        card.setState(card.NORM_STATE);
                    }
                    remove(blur);
                    remove(addPlantPlain);
                } else blur.setLocation(getGrid());
            }
        }, 0, 20);
        repaint();
    }
    public boolean moveCardToBar(Card card) {
        if (plantBar.hasEmptyPosition() == false) return false;
        plantBar.AddCard(card);
        plantGroup.RemoveCard(card);
        moveCardThread = moveCard(card, plantBar.getNextCardX(), plantBar.getNextCardY(), 100);
        moveCardThread.start();
        return true;
    }
    public void moveCardToGroup(Card card) {
        moveCard(card, GroupBoundX + card.GroupX, GroupBoundY + card.GroupY, 100).start();
        plantBar.RemoveCard(card);
        plantGroup.AddCard(card);
    }
    private void ShowPlants(Thread before) {
        startBtn.setBounds(151, 543, 158, 45);
        startBtn.setVisible(false);
        new Thread(() -> {
            try {
                before.join();
                Card[] cards = {
                    new DrawCherryBombCard(this),
                    new DrawChomperCard(this),
                    new DrawHypnoShroomCard(this),
                    new DrawJalapenCard(this),
                    new DrawPeaShooterCard(this),
                    new DrawRepeaterCard(this),
                    new DrawSnowPeaCard(this),
                    new DrawSunFlowerCard(this),
                    new DrawWallNutCard(this),
                    new DrawPotatoMineCard(this),
                    new DrawSquashCard(this),
                    new DrawSunShroomCard(this),
                    new DrawThreePeashooterCard(this)
                };
                add(startBtn, JLayeredPane.POPUP_LAYER, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void run() {
        moveToZombie.start();
        Thread barThread = new Thread(plantBar);
        Thread groupThread = plantGroup.moveTo(plantGroup.VisibleX, plantGroup.VisibleY, 500, moveToZombie);
        add(plantBar, JLayeredPane.PALETTE_LAYER, 1);
        add(plantGroup, JLayeredPane.PALETTE_LAYER, 1);
        barThread.start();
        groupThread.start();
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plantGroup.removeALL(AdventurePane.this);
                plantBar.setFightState();
                Thread groupThread = plantGroup.moveTo(plantGroup.InvisibleX, plantGroup.InvisibleY, 100, null);
                groupThread.start();
                remove(startBtn);
                Thread moveThread = moveBG(-200, 0, 2, groupThread);
                moveThread.start();
                battle.before = moveThread;
                battleThread = new Thread(battle);
                battleThread.start();
            }
        });
        ShowPlants(groupThread);
        try {
            synchronized(battle) {
                battle.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JButton backToMenu = new JButton();
        backToMenu.setLocation(300, 200);
        if (battle.win) backToMenu.setIcon(new ImageIcon("./img/Screen/GameVictory.png"));
        else backToMenu.setIcon(new ImageIcon("./img/Screen/GameLoose.jpg"));
        add(backToMenu, JLayeredPane.DRAG_LAYER);
        backToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.runLaunchPane();
            }
        });
    }
}

class Blur extends JLabel {
    Image blur = null;
    int x, y;
    public Blur() {
        super();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(blur, 0, 0, this);
    }
    public void setBlur(ImageIcon blur) {
        this.blur = blur.getImage();
        setSize(blur.getIconWidth(), blur.getIconHeight());
    }
}

class Click implements MouseListener {
    public boolean clicked;
    public Point clickP;
    public void reset() {
        clicked = false;
    }
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            clickP = e.getPoint();
        }
        clicked = true;
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

class Coordinate implements MouseMotionListener {
    Point point = new Point(0, 0);
    public void mouseMoved(MouseEvent e) {
        point = e.getPoint();
    }
    public void mouseDragged(MouseEvent e) {}
}

class AddPlantPlain extends JLabel {
    Click click = new Click();
    Coordinate coor = new Coordinate();
    AddPlantPlain() {
        super();
        setBounds(0, 0, 810, 620);
        addMouseListener(click);
        addMouseMotionListener(coor);
    }
}

class Battle implements Runnable {
    private LinkedList < plants > plantList = new LinkedList < plants > ();
    private LinkedList < plants > plantRemoveList = new LinkedList < plants > ();
    private LinkedList < ZombieBasis > zombieList = new LinkedList < ZombieBasis > ();
    private LinkedList < ZombieBasis > zombieRemoveList = new LinkedList < ZombieBasis > ();
    private LinkedList < Bullets > bulletList = new LinkedList < Bullets > ();
    private LinkedList < Bullets > bulletRemoveList = new LinkedList < Bullets > ();
    private LinkedList < Bomb > bombList = new LinkedList < Bomb > ();
    private LinkedList < Bomb > bombRemoveList = new LinkedList < Bomb > ();
    private LinkedList < Sun_Shine > sunshineList = new LinkedList < Sun_Shine > ();
    private ExecutorService livePlants = new ThreadPoolExecutor(45, 45, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue < > ());
    private ExecutorService liveZombies = new ThreadPoolExecutor(45, 45, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue < > ());
    private ExecutorService liveBullets = new ThreadPoolExecutor(45, 45, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue < > ());
    public boolean win = false;
    protected boolean hasZombie[][] = new boolean[15][6], hasPlant[][] = new boolean[15][6];
    private int Damage[][] = new int[15][6];
    AdventurePane pane;
    Battle(AdventurePane pane) {
        this.pane = pane;
    }
    //(locY - 100) / 97 * 97 + 100
    public Thread before;
    void addPlant(plants P) {
        pane.add(P, JLayeredPane.MODAL_LAYER);
        plantList.add(P);
        livePlants.submit(new Thread(P));
        addZombie(new FlagZombie(1000));
    }
    public void addSunshine(Sun_Shine s) {
        sunshineList.add(s);
    }
    void addZombie(ZombieBasis Z) {
        pane.add(Z, JLayeredPane.MODAL_LAYER);
        zombieList.add(Z);
        liveZombies.submit(new Thread(Z));
    }
    public void run() {
        int rest = 10, gridX, gridY, damageDis = 10;
        try {
            if (before != null) before.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //while(liveZombies.isTerminated() == false)
        while (rest != 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Bullets b: bulletList)
                if(b.state == b.DEAD_STATE)
                    bulletRemoveList.add(b);
            for (Bullets b: bulletRemoveList) {
                bulletList.remove(b);
                pane.remove(b);
            }
            for (Bomb b:bombRemoveList){
                bombList.remove(b);
            }
            for (plants p: plantRemoveList) {
                plantList.remove(p);
                pane.remove(p);
            }
            for (ZombieBasis z : zombieRemoveList){
                zombieList.remove(z);
                pane.remove(z);
            }
            pane.repaint();
            bulletRemoveList.clear();
            plantRemoveList.clear();
            bombRemoveList.clear();
            zombieRemoveList.clear();
            for (int y = 0; y < 5; y++)
                for (int x = 0; x <= 9; x++)
                    hasZombie[x][y] = false;
            for (ZombieBasis z: zombieList) {
                {
                    if (z.state == z.DEAD_STATE)zombieRemoveList.add(z);
                    if (z.state == z.NORM_DIE_STATE || z.state == z.BOMB_DIE_STATE) continue;
                }
                gridX = (z.getX() - 55) / 80;
                gridY = (z.getY() - 10) / 97;
                hasZombie[gridX][gridY] = true;
                if (hasPlant[gridX + 1][gridY])
                {
                    System.out.println(gridX + " " + gridY);
                    Damage[gridX + 1][gridY]++;
                    z.eat();
                }
                else
                {
                    z.walk();
                }
                for (Bullets b: bulletList) {
                    if (((b.y - 100) / 97) == gridY && Math.abs(b.getX() - z.getX() - 10) <= damageDis) {
                        b.state = b.HIT_STATE;
                        z.getHurt(b.damage);
                    }
                }
                if (z.HP <= 0)z.setState(z.NORM_DIE_STATE);
            }
            for (plants p: plantList) {
                gridX = (p.getX() - 55) / 80;
                gridY = (p.getY() - 100) / 97;
                boolean haszombie = false;
                p.loseHP(Damage[gridX][gridY]);
                if(p.isAlive() == false)
                    p.state = p.DEAD_STATE;
                Damage[gridX][gridY] = 0;
                for (int x = gridX; x < 9; x++)
                {
                    if (hasZombie[x][gridY]) haszombie = true;
                }
                if (haszombie && (p.state == p.ATTACK_STATE)) {
                    while (p.BulletsList.size() != 0) {
                        System.out.println("Bullet");
                        Bullets b = p.getBullet();
                        pane.add(b, JLayeredPane.MODAL_LAYER);
                        bulletList.add(b);
                        liveBullets.submit(new Thread(b));
                    }
                } else if (p.state == p.BOMB_STATE) {
                    Bomb b = p.getBomb();
                    bombList.add(b);
                } else if (p.state == p.DEAD_STATE) {
                    plantRemoveList.add(p);
                    hasPlant[gridX][gridY] = false;
                }
            }
            for(Bomb b : bombList)
                if(b.state == b.BOMB_STATE)
                {
                    for(ZombieBasis z : zombieList)
                        if(b.involve(z.getX(), z.getY()))
                            z.boomdie();
                    bombRemoveList.add(b);
                }else{
                    for(ZombieBasis z : zombieList)
                        if(b.involve(z.getX(), z.getY()))
                        {
                            b.state = b.BOMB_STATE;
                            break;
                        }
                }
        }
        if (rest == 0) win = true;
        else win = false;
        Battle.this.notify();
    }
}
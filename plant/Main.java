package plant;


import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Main  extends JPanel{
	
	public static corrdinate coor=new corrdinate(); 
	public static JFrame jframe=new JFrame();
	public static ImageIcon back=new ImageIcon("Peashooter/background.jpg");
	public static ImageIcon bea=new ImageIcon("Peashooter/Bullets/PeaShooter.png");
	//public static ImageIcon pea=new ImageIcon("nine_eleven_image/peas.gif");
	public static ImageIcon cor=new ImageIcon("Peashooter/Corpse.gif");
	public static ImageIcon beanone=new ImageIcon("Peashooter/Bullets/PeaShooterHit.png");
	public static ImageIcon peasicon=new ImageIcon("Peashooter/Peashooter/Peashooter_0.png");
	public static JLabel bean=new JLabel();
	public static JLabel background=new JLabel();
	public static JLabel corpse=new JLabel();
	public static JLabel peas = new JLabel();
	
	public static void main(String[] args){
		//参数为true会有碰撞效果，false不会
		new Main(false);
	}
	
	public Main(Boolean flag){
		jframe.setSize(back.getIconWidth(),back.getIconHeight());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.setTitle("豌豆射手");
		
		this.setLayout(null);
		jframe.add(this);
		
		
		
		bean.setBounds(coor.x[0],coor.y[0] , bea.getIconWidth(), bea.getIconHeight());
		bean.setIcon(bea);
		add(bean);
		
		
		
		/*JLabel peas=new JLabel();
		peas.setIcon(pea);
		peas.setBounds(coor.x[1], coor.y[1], pea.getIconWidth()-2,pea.getIconHeight());*/
		peas.setIcon(peasicon);
		peas.setBounds(coor.x[1], coor.y[1], peasicon.getIconWidth()-2,peasicon.getIconHeight());
		add(peas);
		
/*		corpse.setIcon(cor);
		corpse.setBounds(coor.x[2], coor.y[2], cor.getIconWidth(),cor.getIconHeight());
		add(corpse);*/
		Timer ct1=new Timer();
		
		TimerTask cs1=new TimerTask(){
			int idx=0;
			@Override
			public void run() {
				String path="Peashooter/Peashooter/Peashooter_"+idx+".png";
				ImageIcon pea=new ImageIcon(path);
				peas.setIcon(pea);
				if(idx<12) {
					idx += 1;
				}else {
					idx = 0;
				}			
			}
			
		};
		ct1.schedule(cs1, 200L,30L);
		
		
		if(flag) {
			Timer ct=new Timer();
			TimerTask cs=new TimerTask(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					coor.x[2]-=1;
					corpse.setIcon(cor);
					corpse.setBounds(coor.x[2], coor.y[2], cor.getIconWidth()+50,cor.getIconHeight());
					
				}
				
			};
			ct.schedule(cs, 200L,30L);
		}

		Timer t=new Timer();
		TimerTask s=new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				coor.x[0]+=2;
				bean.setBounds(coor.x[0],coor.y[0] , bea.getIconWidth(), bea.getIconHeight());
				bean.setIcon(bea);

				if(coor.x[0] >= coor.x[2]){
					bean.setIcon(beanone);
					bean.setBounds(coor.x[0],coor.y[0] , beanone.getIconWidth(), beanone.getIconHeight());
				}
				
				if(coor.x[0] > coor.x[2]+20){
					coor.hit+=1;
					coor.x[0]=230;
					
					if(coor.hit==5){
						coor.hit=0;
						coor.x[2]=1420;
					}
					
				}
				
				repaint();
			}
			
		};
		t.schedule(s, 200L,10L);
		
		background.setSize(back.getIconWidth(),back.getIconHeight());
		background.setIcon(back);
		add(background);
		
		
		
	}

}


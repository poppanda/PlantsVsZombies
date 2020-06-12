package plant;

import View.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class CherryBomb  extends JLabel{
	
	public static corrdinate coor=new corrdinate(); 
	public static LaunchFrame jframe;
	public static ImageIcon back=new ImageIcon("Peashooter/background.jpg");
	public static ImageIcon bea=new ImageIcon("CherryBomb/boom/Frame0.png");
	//public static ImageIcon pea=new ImageIcon("nine_eleven_image/peas.gif");
	public static ImageIcon cor=new ImageIcon("Peashooter/Corpse.gif");
	public static ImageIcon peasicon=new ImageIcon("./img/Plants/CherryBomb/CherryBomb_0.png");
	public static JLabel bean=new JLabel();
	public static JLabel background=new JLabel();
	public static JLabel corpse=new JLabel();
	public static JLabel peas = new JLabel();
	
	// public static void main(String[] args){
	// 	//����Ϊtrue������ײЧ����false����
	// 	new CherryBomb(true);
	// }
	
	public CherryBomb(Boolean flag){
		this.setLayout(null);
		setBounds(0, 0, peasicon.getIconWidth()-2, peasicon.getIconHeight());
		peas.setIcon(peasicon);
		peas.setBounds(coor.x[1], coor.y[1], peasicon.getIconWidth()-2,peasicon.getIconHeight());
		add(peas);
		
		new Thread(new Runnable() {
			int idx=0;
		    public void run() {
		    	while(true) {
		    		String path="CherryBomb/CherryBomb_"+idx+".png";
					ImageIcon pea=new ImageIcon(path);
					peas.setIcon(pea);
					if(idx<6) {
						idx += 1;
					}else {
						idx = 0;
					}
					try
			        {
			            Thread.sleep(100);
			        }
			        catch (InterruptedException e)
			        {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
		    	}
		    			
		    }
		}).start();

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
			//	coor.x[0]+=2;
				bean.setBounds(320,coor.y[0] , bea.getIconWidth(), bea.getIconHeight());
				bean.setIcon(bea);
				int idx = 0;
				while(true) {
					
		    		String path="./img/Plants/CherryBomb/CherryBomb_"+idx+".png";
					ImageIcon pea=new ImageIcon(path);
					peas.setIcon(pea);
					if(idx<19) {
						idx += 1;
					}else {
						idx = 0;
					}
					try
			        {
			            Thread.sleep(100);
			        }
			        catch (InterruptedException e)
			        {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
		    	}
				//repaint();
			}
			
		};
		t.schedule(s, 200L,10L);
		
		background.setSize(back.getIconWidth(),back.getIconHeight());
		background.setIcon(back);
		add(background);

	}

}



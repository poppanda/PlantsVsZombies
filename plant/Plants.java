package plants;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Plants {
	//��������
	protected int HP;
	protected int CD;
	
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getCD() {
		return CD;
	}
	public void setCD(int cD) {
		CD = cD;
	}

	//ͼƬ�Ĵ�С
	protected int height;
	protected int width;
	
	//ͼƬ����ʼ����
	protected int x;
	protected int y;
	
	//ֲ��֡��
	public static int cherryBombNum = 6;
	public static int peaShooterNum = 12;
	public static int peaBulletNum = 3;
	public static int repeaterNum = 14;
	public static int snowPeaNum = 14;
	public static int snowBullet = 3;


	public static int wallNutNum = 15;
	public static int wallnut_cracked1Num = 10;
	public static int Wallnut_cracked2Num = 14;
	
	//�Ƿ���ֲ
	protected static final int empty = 0;
	protected static final int hold = 1;
	protected int tem = empty;

	// �ж�״̬
	public boolean isEmpty() {
		return tem == empty;
	}
	public boolean isHold() {
		return tem == hold;
	}
	
	// �ı�״̬
	public void goEmpty() {
		tem = empty;
	}
	public void goHold() {
		tem = hold;
	}
	
	
	    //����ֲ��λ��
		public Plants(int x, int y,int height,int width) {
			this.x = x;
			this.y = y;
			this.height = height;
			this.width = width;
		}
		
		// ֲ�ﱻ������Ѫ
		public void loseHP(int attack) {
			this.HP = HP - attack;
		}
		
		//�ж�ֲ���Ƿ���
		public boolean isAlive(int hp) {
			if(hp > 0)
				return true;
			return false;
		}
		
		//�ж�CDʱ��
		public boolean isOk(int time) {
			if(time >= CD)
				return true;
			return false;
		}
		
		
		
		class sunFlower extends JLabel implements Runnable{
			private int sunFlower_HP = 4;
			private int sunFlower_CD = 6;
			private int time = 0;
			private int tCD = 0;
			//���ƶ�ͼ
			public void run() {
				while(isAlive(sunFlower_HP)) {
					for(int i = 0; i <= 17; i++) {
						//��ȡͼƬ
						ImageIcon flower = new ImageIcon("pic/SunFlower_" + i +".png");
						//����JLabel����
						JLabel icon = new JLabel(flower);
						//����λ�úʹ�С
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//��������
			public void bringSun(int time) {
				//10�����һ������
				if(time >= 10) {
					//��ȡͼƬ
					ImageIcon sun = new ImageIcon("0.png");
					//����JLabel����
					JLabel icon = new JLabel(sun);
					//����λ�úʹ�С
					icon.setBounds(x+5, y-5, width, height);
				}
				time ++;
			}
			
			//���ÿ�Ƭ
			public void setCard(int sun, int cd) {
				if(sun >= 50) {
					if(cd >= sunFlower_CD) {
						//��ȡͼƬ
						ImageIcon card = new ImageIcon("SunFlower0.png");
						//����JLabel����
						JLabel icon = new JLabel(card);
						//����λ�úʹ�С(ͼƬ��Сδ�ⶨ��
						icon.setBounds(100, 50, width, height);
					}
					else {
						if(cd >= sunFlower_CD/2) {
							ImageIcon card = new ImageIcon("SunFlower1.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
						else {
							ImageIcon card = new ImageIcon("SunFlower2.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
					}
				}
				else {
					ImageIcon card = new ImageIcon("SunFlower1.png");
					JLabel icon = new JLabel(card);
					icon.setBounds(100, 50, width, height);
				}
			}
			
		}
		
		class peaShooter extends JLabel implements Runnable{
			private int peaShooter_HP = 6;
			private int peaShooter_CD = 6;
			private int time = 0;
			//���ƶ�ͼ
			public void run() {
				while(isAlive(peaShooter_HP)) {
					for(int i = 0; i <= peaShooterNum; i++) {
						//��ȡͼƬ
						ImageIcon shoot = new ImageIcon("pic/Peashooter_" + i +".png");
						//����JLabel����
						JLabel icon = new JLabel(shoot);
						//����λ�úʹ�С
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//����ӵ�
			public void shoot() {
				while(isAlive(peaShooter_HP)) {
					for(int i = 0; i <= peaBulletNum; i++) {
						//��ȡͼƬ
						ImageIcon image[] = null;
					    image[i] = new ImageIcon("PeaBullet" + i +".png");
						//����JLabel����
						JLabel icon[] = null;
						icon[i] = new JLabel(image[i]);
						//����λ�úʹ�С
						icon[i].setBounds(x+5, y, width, height);
						if(i > 1) {
							for(int j = 0; j <= i - 1; j++) {
								icon[j].setBounds(x+5, y, width, height);
							}
						}
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
				
		}
			
			//���ÿ�Ƭ
			public void setCard(int sun, int cd) {
				if(sun >= 100) {
					if(cd >= peaShooter_CD) {
						//��ȡͼƬ
						ImageIcon card = new ImageIcon("Peashooter0.png");
						//����JLabel����
						JLabel icon = new JLabel(card);
						//����λ�úʹ�С(ͼƬ��Сδ�ⶨ��
						icon.setBounds(100+width, 50, width, height);
					}
					else {
						if(cd >= peaShooter_CD/2) {
							ImageIcon card = new ImageIcon("SunFlower1.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
						else {
							ImageIcon card = new ImageIcon("SunFlower2.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
					}
				}
				else {
					ImageIcon card = new ImageIcon("SunFlower1.png");
					JLabel icon = new JLabel(card);
					icon.setBounds(100, 50, width, height);
				}
			}
			
	}
		class snowPea extends JLabel implements Runnable{
			private int snowPea_HP = 8;
			private int snowPea_CD = 7;
			private int time = 0;
			//���ƶ�ͼ
			public void run() {
				while(isAlive(snowPea_HP)) {
					for(int i = 0; i <= snowPeaNum; i++) {
						//��ȡͼƬ
						ImageIcon flower = new ImageIcon("pic/SnowPea_" + i +".png");
						//����JLabel����
						JLabel icon = new JLabel(flower);
						//����λ�úʹ�С
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//����ӵ�
			public void shoot() {
				while(isAlive(snowPea_HP)) {
					for(int i = 0; i <= snowPeaNum; i++) {
						//��ȡͼƬ
						ImageIcon image[] = null;
					    image[i] = new ImageIcon("SnowBullet" + i +".png");
						//����JLabel����
						JLabel icon[] = null;
						icon[i] = new JLabel(image[i]);
						//����λ�úʹ�С
						icon[i].setBounds(x+5, y, width, height);
						if(i > 1) {
							for(int j = 0; j <= i - 1; j++) {
								icon[j].setBounds(x+5, y, width, height);
							}
						}
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
				
		}
			
		}
		
		class repeater extends JLabel implements Runnable{
			private int repeater_HP = 8;
			private int repeater_CD = 8;
			private int time = 0;
			//���ƶ�ͼ
			public void run() {
				while(isAlive(repeater_HP)) {
					for(int i = 0; i <= peaShooterNum; i++) {
						//��ȡͼƬ
						ImageIcon flower = new ImageIcon("pic/Peashooter_" + i +".png");
						//����JLabel����
						JLabel icon = new JLabel(flower);
						//����λ�úʹ�С
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
				
			}
			
			//����ӵ�
			public void shoot() {
				while(isAlive(repeater_HP)) {
					for(int i = 0; i <= peaBulletNum; i++) {
						//��ȡͼƬ
						ImageIcon image[] = null;
					    image[i] = new ImageIcon("PeaBullet" + i +".png");
						//����JLabel����
						JLabel icon[] = null;
						icon[i] = new JLabel(image[i]);
						//����λ�úʹ�С
						icon[i].setBounds(x+5, y, width, height);
						i++;
						icon[i].setBounds(x+10, y, width, height);
						if(i > 1) {
							for(int j = 0; j <= i - 1; j++) {
								icon[j].setBounds(x+5, y, width, height);
							}
						}
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
				
		}
			
		}
		
		class cherryBomb extends JLabel implements Runnable{
			private int cherryBomb_HP = 4;
			private int cherryBomb_CD = 12;
			private int cherryBomb_damage = 20;
			private int time = 0;
			//���ƶ�ͼ
			public void run() {
				while(isAlive(cherryBomb_HP)) {
					for(int i = 0; i <= cherryBombNum; i++) {
						//��ȡͼƬ
						ImageIcon flower = new ImageIcon("pic/CherryBomb_" + i +".png");
						//����JLabel����
						JLabel icon = new JLabel(flower);
						//����λ�úʹ�С
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//��ը
			public void bomb() {
				
			}
			
		}
		
		class wallNut extends JLabel implements Runnable{
			private int wallNut_HP = 10;
			private int wallNut_CD = 15;
			private int time = 0;
			//���ƶ�ͼ
			public void run() {
				while(isAlive(wallNut_HP)) {
					for(int i = 0; i <= wallNutNum; i++) {
						//��ȡͼƬ
						ImageIcon flower = new ImageIcon("pic/WallNut_" + i +".png");
						//����JLabel����
						JLabel icon = new JLabel(flower);
						//����λ�úʹ�С
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			
			
		}
}

package plant;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public abstract class Plant {
	
	//����ͼƬ
	public static BufferedImage loadImage(File file) {
		try {
			BufferedImage img = ImageIO.read(file);
			return img;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// ��ȡͼƬ
		public abstract BufferedImage getImage();
		
		// ��ͼƬ
		public void paintObject(Graphics g) {
			g.drawImage(getImage(),x,y,null);                                   
		}
			
		
	protected int HP;
	protected int CD;
	//ͼƬ������
	protected int photoTotal;
	//��ǰͼƬ�ǵڼ���
	protected int photoNum;

	public void setHP(int hP) {
		HP = hP;
	}

	// ��ȡֲ���Ѫ��
	public int getHP() {
		return this.HP;
	}
	
	public int getCD() {
		return CD;
	}

	public void setCD(int cD) {
		CD = cD;
	}

	public int getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}
	
	//ͼƬ�Ĵ�С
	protected int height;
	protected int width;
	//ͼƬ����ʼ����
	protected int x;
	protected int y;
		
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
		
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	//����ֲ��λ��
	public Plant(int width,int height,int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
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
	
}

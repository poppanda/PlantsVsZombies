package plant;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public abstract class Plant {
	
	//加载图片
	public static BufferedImage loadImage(File file) {
		try {
			BufferedImage img = ImageIO.read(file);
			return img;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 获取图片
		public abstract BufferedImage getImage();
		
		// 画图片
		public void paintObject(Graphics g) {
			g.drawImage(getImage(),x,y,null);                                   
		}
			
		
	protected int HP;
	protected int CD;
	//图片的总数
	protected int photoTotal;
	//当前图片是第几张
	protected int photoNum;

	public void setHP(int hP) {
		HP = hP;
	}

	// 获取植物的血量
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
	
	//图片的大小
	protected int height;
	protected int width;
	//图片的起始坐标
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
	
	//设置植物位置
	public Plant(int width,int height,int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	
		
	// 植物被攻击扣血
	public void loseHP(int attack) {
		this.HP = HP - attack;
	}
	
	//判断植物是否存活
	public boolean isAlive(int hp) {
		if(hp > 0)
			return true;
		return false;
	}
	
	//判断CD时间
	public boolean isOk(int time) {
		if(time >= CD)
			return true;
		return false;
	}
	
}

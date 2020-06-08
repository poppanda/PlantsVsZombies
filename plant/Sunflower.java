package plant;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

public  class sunFlower extends Plant{
	
	//加载向日葵图片
	private static BufferedImage[] imgs;
	static {
		imgs = new BufferedImage[6];
		for(int i=0;i<imgs.length;i++) {
			File file = new File("path");
			imgs[i] = loadImage(file);
		}
	}
	
	//绘制向日葵图片的位置和大小
		public sunFlower(int width, int height, int x, int y) {
			super(width, height, x, y);
			// TODO Auto-generated constructor stub
		}
		
	@Override
	public BufferedImage getImage() {
		int tem = 0;
		if(isAlive(getHP())) {
			//按照帧数绘制图片使图片动起来
			tem++;
			return imgs[tem];
			
		}else {
			return null;
		}
	}
		
	//生产阳光,创建了向日葵后调用循环，每次循环改变i的值，用于控制生产阳光的CD
	int i = 5;
	public void bringSun(boolean isTure) {
		if(isTure) {
			if(i%5 == 0) {
				//生产阳光
			}
		}
	}
	
	//阳光的位置
	protected Point sunPoint;
	//生产出来的阳光是否被点击
	protected boolean isClick;
	//初始化阳光值
	protected int sunNum = 50;
	
	//给定生产的阳光的位置
	public void Sun(Point p) {
		this.sunPoint = p;
	}
	 //阳光掉落过程
	public void move() {
		if(sunPoint.x > 50) {
			sunPoint.x -=50;
			sunPoint.y -=50;
		}
	}

	public static BufferedImage[] getImgs() {
		return imgs;
	}

	public static void setImgs(BufferedImage[] imgs) {
		sunFlower.imgs = imgs;
	}

	public Point getSunPoint() {
		return sunPoint;
	}

	public void setSunPoint(Point sunPoint) {
		this.sunPoint = sunPoint;
	}

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}

	public int getSunNum() {
		return sunNum;
	}

	public void setSunNum(int sunNum) {
		this.sunNum = sunNum;
	}
	
}

package plant;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

public  class sunFlower extends Plant{
	
	//�������տ�ͼƬ
	private static BufferedImage[] imgs;
	static {
		imgs = new BufferedImage[6];
		for(int i=0;i<imgs.length;i++) {
			File file = new File("path");
			imgs[i] = loadImage(file);
		}
	}
	
	//�������տ�ͼƬ��λ�úʹ�С
		public sunFlower(int width, int height, int x, int y) {
			super(width, height, x, y);
			// TODO Auto-generated constructor stub
		}
		
	@Override
	public BufferedImage getImage() {
		int tem = 0;
		if(isAlive(getHP())) {
			//����֡������ͼƬʹͼƬ������
			tem++;
			return imgs[tem];
			
		}else {
			return null;
		}
	}
		
	//��������,���������տ������ѭ����ÿ��ѭ���ı�i��ֵ�����ڿ������������CD
	int i = 5;
	public void bringSun(boolean isTure) {
		if(isTure) {
			if(i%5 == 0) {
				//��������
			}
		}
	}
	
	//�����λ��
	protected Point sunPoint;
	//���������������Ƿ񱻵��
	protected boolean isClick;
	//��ʼ������ֵ
	protected int sunNum = 50;
	
	//���������������λ��
	public void Sun(Point p) {
		this.sunPoint = p;
	}
	 //����������
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

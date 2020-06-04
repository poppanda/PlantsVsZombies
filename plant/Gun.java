package plant;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public abstract class Gun {
	// ��ʼ����λ��
	protected int x;
	protected int y;
	//ͼƬ��С
	protected int width;
	protected int height;
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	// �����ӵ�
	public Gun(int x,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	// �ӵ���״̬
	protected int Speed;
	public static final int exit = 0;
	public static final int disappear = 1;

	// �ж��ӵ���״̬
	public boolean isExit() {
		return exit;
	}
	public boolean isDisappear() {
		return disappear ;
	}

	// �ӵ����ƶ�
	public void move() {
		x+=Speed;
	}


	// �ӵ��뽩ʬ�Ƿ���ײ
	public abstract boolean isHit();

	// �ӵ��Ƿ�Խ��
	public boolean isOut() {
		return this.x >= background.width;
	}

}


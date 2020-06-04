package plant;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public abstract class Gun {
	// 起始坐标位置
	protected int x;
	protected int y;
	//图片大小
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

	// 创建子弹
	public Gun(int x,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	// 子弹的状态
	protected int Speed;
	public static final int exit = 0;
	public static final int disappear = 1;

	// 判断子弹的状态
	public boolean isExit() {
		return exit;
	}
	public boolean isDisappear() {
		return disappear ;
	}

	// 子弹的移动
	public void move() {
		x+=Speed;
	}


	// 子弹与僵尸是否碰撞
	public abstract boolean isHit();

	// 子弹是否越界
	public boolean isOut() {
		return this.x >= background.width;
	}

}


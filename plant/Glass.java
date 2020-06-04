package plant;

public class Glass {
	//绘制矩形的坐标
	protected int x;
	protected int y;
	//每个矩形的大小
	public static final int width = 80;
	public static final int hight = 100;
	
	// 将矩形绘制在背景图的草地上（调用循环）
	public Glass(int x,int y) {
		this.x = x;
		this.y = y;
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
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return hight;
	}

	// 草地的状态
	protected static final int empty = 0;
	protected static final int hold = 1;
	protected int tem = empty;

	// 判断状态
	public boolean isEmpty() {
		return tem == empty;
	}
	public boolean isHold() {
		return tem == hold;
	}
	
	// 改变状态
	public void goEmpty() {
		state = empty;
	}
	public void goHold() {
		state = hold;
	}
	
}

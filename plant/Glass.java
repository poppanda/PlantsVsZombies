package plant;

public class Glass {
	//���ƾ��ε�����
	protected int x;
	protected int y;
	//ÿ�����εĴ�С
	public static final int width = 80;
	public static final int hight = 100;
	
	// �����λ����ڱ���ͼ�Ĳݵ��ϣ�����ѭ����
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

	// �ݵص�״̬
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
		state = empty;
	}
	public void goHold() {
		state = hold;
	}
	
}

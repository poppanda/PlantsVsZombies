package demo;

public class Bomb
{
	int x0, x1, y0, y1;
	public int state;
	public final int WAIT_STATE = 0, BOMB_STATE = 1;
	public Bomb(int x0, int x1, int y0, int y1){
		this.x0 = x0;
		this.x1 = x1;
		this.y0 = y0;
		this.y1 = y1;
	}
	void setState(int state){
		this.state = state;
	}
	public boolean involve(int x, int y) {
		x = (x - 55) / 80;
		y = (y - 10) / 97;
		//System.out.println(x + " " + y + " " + x0 + " " + x1 + " " + y0 + " " + y1);
		if(x >= x0 && x <= x1 && y >= y0 && y <= y1)
			return true;
		return false;
	}
}
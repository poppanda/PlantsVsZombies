package demo;

public class Bomb extends plants{
	public Bomb(int X, int Y) {
		super();
		CD = 1;
		attack = 10;
		setBounds(X, Y, 100, 100);
		this.x = X;
		this.y = Y;
	}
	
	public void run() {
		
	}
	
	
	public boolean involve(int x, int y) {
		if((x >= x - 200 || x <= x + 200) && ((y >= y - 200 || y <= y + 200)))
			return true;
		return false;
	}
	
	public void getBomb(int x, int y) {
		
	}


}

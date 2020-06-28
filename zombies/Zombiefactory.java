package zombies;

import View.*;
import java.util.*;
import java.io.*;

//the file's form is:  wave(‘1’is a big wave,‘0’ is normal wave)+count(the count of all types zombies)
public class Zombiefactory {
	public Zombiefactory(String filename, AdventurePane pane) {
		final int ZombieNum = 1, FlagNum = 3, ConeheadNum = 2, BucketheadNum = 4;
		int num, delaytime, style;
		FastReader read = new FastReader(filename);
		num = read.nextInt();
		delaytime = (int)(Math.random() * 2000) + 5000;
		style = read.nextInt();
		for (int i = 0; i < num; i++) {
			delaytime += (int)(Math.random() * 2000) + 1000;
			if (style == FlagNum) {
				pane.addZombie(new FlagZombie(delaytime));
			} else if (style == ConeheadNum) {
				pane.addZombie(new ConeheadZombie(delaytime));
			} else if (style == BucketheadNum) {
				pane.addZombie(new BucketheadZombie(delaytime));
			} else if (style == ZombieNum) {
				pane.addZombie(new Zombie(delaytime));
			}
		}
	}

}
class FastReader {
	BufferedReader in ;
	StringTokenizer st;
	public FastReader(String filename) {
		try{
			in = new BufferedReader(new FileReader(new File(filename)));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer( in .readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	int nextInt() {
		return Integer.parseInt(next());
	}
}
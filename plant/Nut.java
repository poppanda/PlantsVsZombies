package plant;

import java.awt.image.BufferedImage;
import java.io.File;

public class Nut extends Plant{

	public Nut(int width, int height, int x, int y) {
		super(width, height, x, y);
		// TODO Auto-generated constructor stub
		HP = 10;
	}

	//加载坚果图片
		private static BufferedImage[] imgs;
		static {
			imgs = new BufferedImage[6];
			for(int i=0;i<imgs.length;i++) {
				File file = new File("path");
				imgs[i] = loadImage(file);
			}
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
	
}


package plant;
import java.awt.image.BufferedImage;
import java.io.File;

public class CherryBomb extends Plant{
	protected int attack = 10;
	public CherryBomb(int width, int height, int x, int y) {
		super(width, height, x, y);
		HP = 1;
		// TODO Auto-generated constructor stub
	}

	//º”‘ÿ”£Ã“’®µØÕº∆¨
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
					//∞¥’’÷° ˝ªÊ÷∆Õº∆¨ πÕº∆¨∂Ø∆¿¥
					tem++;
					return imgs[tem];
					
				}else {
					return null;
				}
			}

}


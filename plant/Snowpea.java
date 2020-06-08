package plant;

import java.awt.image.BufferedImage;
import java.io.File;

public class Snowpea extends Plant {

	//�趨�������ֹ���ֵ
	protected int attack = 3;
	public Snowpea(int width, int height, int x, int y) {
		super(width, height, x, y);
		// TODO Auto-generated constructor stub
		HP = 6;
	}

	//���غ�������ͼƬ
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
					//����֡������ͼƬʹͼƬ������
					tem++;
					return imgs[tem];
					
				}else {
					return null;
				}
			}
	
}


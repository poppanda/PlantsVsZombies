package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JLabel;

public class plants extends JLabel{
		//��������
		protected int HP;
		protected int CD;
		protected int attack;
		
		public int getHP() {
			return HP;
		}
		public void setHP(int hP) {
			HP = hP;
		}
		public int getCD() {
			return CD;
		}
		public void setCD(int cD) {
			CD = cD;
		}
		//�Ƿ���ֲ
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
			tem = empty;
		}
		public void goHold() {
			tem = hold;
		}
		// ֲ�ﱻ������Ѫ
		public void loseHP(int attack) {
			this.HP = HP - attack;
		}
				
		//�ж�ֲ���Ƿ���
		public boolean isAlive(int hp) {
			if(hp > 0)
				return true;
			    return false;
		}
				
		//�ж�CDʱ��
		public boolean isOk(int time) {
			if(time >= CD)
				return true;
				return false;
		}
		
		
	
}

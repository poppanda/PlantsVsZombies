### 一、植物类基本属性和方法

所有细分的植物都继承自父类plants，父类中定义基本属性和方法，并使用LinkedList存储绘制动画需要的图片

植物重写父类run()方法，实现动画，不同植物根据动作增加独有的方法

```mermaid
classDiagram
class plants{
	int HP
	int state, **_STATE
	int x, y
	int num
	LinkedList
	void loseHP(int attack)
	boolean isAlive()
	void paint(Graphics g)
	boolean involve(int x, int y)
	int isHit(int x, int y)
	getXX()
	setXX()
	run()
}

class Bullets{
	Image BulletsImage, BulletsbombImage, PaintingImage
	int damage
	+int isHit(int x,int y)
}


class Bomb{
	int x0, x1, y0, y1;
	int state, **_STATE
	+setState()
	+boolean involve(int x, int y)
}

class Sunflower{
	+void MakeSunshine()
}

class PeaShooter{
	+Bullets getBullet()
	+boolean remainBullets()
}

class Repeater{
	+Bullets getBullet()
	+boolean remainBullets()
}


class CherryBomb{
	+Bomb getBomb()
}

class WallNut

class Chomper{
	+void Eat()
}

class PotatoMine{
	+Bomb getBomb()
}

plants<--Sunflower
plants<--PeaShooter
plants<--WallNut
plants<--Chomper
plants<--PotatoMine
plants<--CherryBomb
plants<--Repeater

PeaShooter-->Bullets
Repeater-->Bullets

CherryBomb-->Bomb
PotatoMine-->Bomb
```

### 二、卡片绘制

父类Card定义了放置卡片和选择卡片的功能，绘制不同的植物选项卡只要继承父类将所需参数添加进去即可

```mermaid
classDiagram
class Card{
	ImageIcon LightIcon, DarkIcon, FillIcon, PaintingIcon, CursorIcon
	int w, h, FillTime, FISX, FIEX, FISY, FIEY
	int x, y, GroupX, GroupY
	int state, **_STATE
	boolean isMoving
	AdventurePane
	ActionListener
	void actionPerformed(ActionEvent e)
	void paintComponent(Graphics g)
	Card(AdventurePane pane, int groupX, int groupY, int fillTime, ImageIcon lightIcon, ImageIcon darkIcon, ImageIcon fillIcon, ImageIcon cursorIcon)
	abstract public plants CreatePlant(int X, int Y);
	void setPosition(int x, int y)
	void Fill()
	void setState(int STATE)
	JLabel chosenLabel()
}

class DrawXXCard{
	DrawXXCard(AdventurePane pane)
	XX CreatePlant(int X, int Y)
}

DrawXXCard <-- Card
```

### 三、动画实现及状态判断

创建植物的同时通过getXX().add()方法将图片储存进在父类中定义好的缓存区，在run方法里按照编号不断循环绘制图片，实现动画效果

state标记植物当前状态，根据不同时间段下植物状态的改变修改DrawGroup以此控制改变动画效果

```mermaid
graph TD
A[create object]
A --> a(1.getImage)
A --> b(2.setBounds)
A --> c(3.run)
c --> d(isAlive)
d --> e(1.repaint)
d --> f(2.modify picture num)
d --> g(3.judge or modify state)
```

对于射出子弹实现子弹的移动效果，基本原理与上图相同，只需要在repaint()里增加setBounds()方法每次使x的值递增即可

```mermaid
graph LR
A[isAlive] --> a(1.repaint)
A --> b(2.setBounds *x++*)
A --> c(3.judge or modify state)




```


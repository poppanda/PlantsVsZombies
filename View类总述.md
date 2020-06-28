### LaunchFrame

对整体框架进行绘制

其中 LaunchPane 和 AdventurePane 均为JLayeredPane的子类，用于绘制具体的界面

<img src="./img/Data/LaunchFrame1.png" alt="LaunchFrame1" style="zoom:33%;" />

#### 关系图

LaunchFrame 中的几个要素之间的关联满足以下关系

<img src="./img/Data/LaunchFrame2.png" alt="LaunchFrame2" style="zoom:25%;" />

### LaunchPane

LaunchPane负责绘制初始界面

<img src="./img/Data/LaunchPane1.png" alt="LaunchPane1" style="zoom:33%;" />



### AdventurePane

AdventurePane负责战斗界面的绘制和处理，包括选择卡片界面、战斗界面的绘制和植物与僵尸之间关系的处理

<img src="./img/Data/AdventurePane1.png" alt="AdventurePane1" style="zoom: 33%;" />

处理过程如下

<img src="./img/Data/AdventurePane2.png" alt="AdventurePane2" style="zoom:33%;" />

植物类相关判定

<img src="./img/Data/AdventurePane3.png" alt="AdventurePane3" style="zoom:33%;" />

僵尸类相关判定

![Screen Shot 2020-06-28 at 11.03.25 PM](/Users/smile./Library/Application Support/typora-user-images/Screen Shot 2020-06-28 at 11.03.25 PM.png)
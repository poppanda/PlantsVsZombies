```mermaid
classDiagram
class Plant{
	<<abstract>>
	int life,position
	boolean eatable
	String environment
	void place()
	void remove()
}

class Shooter{
	<<interface>>
	void Shoot
}

class Bomb{
	<<interface>>
	void Bomb
}

class Sunflower{
	+void MakeSunshine()
}

class PeaShooter

class SnowPea

class CherryBomb

class WallNut

class Chomper{
	void Eat()
	void Process()
}

class PotatoMine

Plant<--Sunflower
Plant<--PeaShooter
Plant<--SnowPea
Plant<--WallNut
Plant<--Chomper
Plant<--PotatoMine
Plant<--CherryBomb

PeaShooter-->Shooter
SnowPea-->Shooter

CherryBomb-->Bomb
PotatoMine-->Bomb
```


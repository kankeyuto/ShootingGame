
public class OriginalEnemy extends Enemy {
	public OriginalEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 10;
		score = 15;
	}
	public void move() {
		super.move();
		if(x > 300) vx = -GameWorld.stage;
		if(x < 100) vx = GameWorld.stage;
//		if(Math.random() < 0.05) {
//			GameWorld.enemies.add(new StraightEnemy(x, y, 0, 1+GameWorld.stage));
//		}
		if(Math.random() < 0.05) {
			GameWorld.enemies.add(new RandomEnemy(x, y, 0, GameWorld.stage));
		}
		if(Math.random() < 0.05) {
			GameWorld.enemies.add(new DropEnemy(x, y, 0, GameWorld.stage));
		}
		if(Math.random() < 0.05) {
			GameWorld.enemies.add(new CurveEnemy(x, y, 0, GameWorld.stage));
		}
	}
	public void draw(MyFrame f) {
		f.setColor(0, 0, 0);
		f.fillOval(x, y, 25, 25);
		f.setColor(0, 0, 0);
		f.fillOval(x+24, y, 25, 25);
		f.setColor(0, 0, 0);
		f.fillOval(x+48, y, 25, 25);
		
		f.setColor(255, 255, 255);
		f.fillOval(x, y+6, 25, 12);
		f.setColor(255, 255, 255);
		f.fillOval(x+24, y+6, 25, 12);
		f.setColor(255, 255, 255);
		f.fillOval(x+48, y+6, 25, 12);
		
		f.setColor(255, 0, 0);
		f.fillOval(x+7, y+7, 10, 10);
		f.setColor(255, 0, 0);
		f.fillOval(x+31, y+7, 10, 10);
		f.setColor(255, 0, 0);
		f.fillOval(x+55, y+7, 10, 10);
	}
}

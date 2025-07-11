
public class EnemyBase extends Enemy {
	public EnemyBase(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 20;
		score = 10;
	}
	public void move() {
		super.move();
		if(x > 300) vx = -GameWorld.stage;
		if(x < 100) vx = GameWorld.stage;
		if(Math.random() < 0.05) {
			GameWorld.enemies.add(new StraightEnemy(x, y, 0, 1+GameWorld.stage));
		}
		if(Math.random() < 0.05) {
			GameWorld.enemies.add(new RandomEnemy(x, y, 0, GameWorld.stage));
		}
//		練習問題11-1.
		if(Math.random() < 0.05) {
			GameWorld.enemies.add(new DropEnemy(x, y, 0, GameWorld.stage));
		}
		if(Math.random() < 0.05) {
			GameWorld.enemies.add(new CurveEnemy(x, y, 0, GameWorld.stage));
		}
		
		
	}
	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
	    f.fillOval(x - 16, y - 16, 32, 32); // ← 中心に合わせて修正！
	    f.setColor(200, 200, 200);
	    f.fillOval(x - 32, y - 8, 64, 16);  // 雲みたいなエフェクトも位置調整
	    
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

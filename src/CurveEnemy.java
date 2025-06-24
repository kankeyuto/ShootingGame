  
public class CurveEnemy extends Enemy {
	public CurveEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
//		練習問題12-1.
		life = 3;
	}
	public void move() {
		super.move();
		if(x < GameWorld.player.x) {
			x++;
		}
		if(x > GameWorld.player.x) {
			x--;
		}	
	}
//	練習問題11-2.
	public void draw(MyFrame f) {
		f.setColor(0, 0, 0);
		f.fillOval(x, y, 20, 20);
		f.setColor(255, 255, 255);
		f.fillOval(x+5, y, 10, 20);
	}

}

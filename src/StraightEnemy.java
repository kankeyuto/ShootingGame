
public class StraightEnemy extends Enemy {
	public StraightEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
//		練習問題12-1.
		life = 5;
	}
//	練習問題11-2.
	public void draw(MyFrame f) {
		f.setColor(0, 0, 0);
		f.fillRect(x, y, 14, 15);
		f.setColor(0, 0, 0);
		f.fillRect(x+2, y+15, 10, 10);
	}

}

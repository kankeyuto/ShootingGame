
public class DropEnemy extends Enemy {
	public DropEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
//		練習問題12-1.
		life = 1;
	}
	public void move() {
		super.move();
		vy = vy + 0.05;
	}
//	練習問題11-2.
	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
		f.fillRect(x, y, 30, 10);
		f.setColor(0, 128, 0);
		f.fillRect(x+10, y, 10, 30);
	}

}

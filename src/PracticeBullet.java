
//練習問題10-3.
public class PracticeBullet extends Character{
	public PracticeBullet(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
	}
	public void draw(MyFrame f) {
		f.setColor(0 ,0 ,0);
		f.fillRect(x+10, y, 10, 15);
	}

}

import java.util.Vector;

public class GameFrame extends MyFrame {
	public void run() {
		GameWorld.player = new Player(100,300,0,0);
//		GameWorld.player.draw(this);
		addKeyListener(GameWorld.player);
		GameWorld.playerBullets = new Vector<PlayerBullet>();
		GameWorld.practiceBullets = new Vector<PracticeBullet>();
		while(true) {
			clear();
			GameWorld.player.draw(this);
			GameWorld.player.move();
//			movePlayerBullets();
			movePracticeBullets();
			sleep(0.03);
		}
	}
	
	public void movePlayerBullets() {
		int i = 0;
		while(i < GameWorld.playerBullets.size()) {
			PlayerBullet b = GameWorld.playerBullets.get(i);
			b.draw(this);
			b.move();
			if(b.y< 0) {
				GameWorld.playerBullets.remove(i);
			}else {
				i++;
			}
		}
	}
	
//	練習問題10-3.
	public void movePracticeBullets() {
		int i = 0;
		while(i < GameWorld.practiceBullets.size()) {
			PracticeBullet b = GameWorld.practiceBullets.get(i);
			b.draw(this);
			b.move();
			if(b.y< 0) {
				GameWorld.practiceBullets.remove(i);
			}else {
				i++;
			}
		}
	}
}

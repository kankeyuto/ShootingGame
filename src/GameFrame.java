import java.util.Vector;

public class GameFrame extends MyFrame {
	public void run() {
		GameWorld.player = new Player(100,300,0,0);
//		GameWorld.player.draw(this);
		addKeyListener(GameWorld.player);
		GameWorld.playerBullets = new Vector<PlayerBullet>();
		GameWorld.practiceBullets = new Vector<PracticeBullet>();
		GameWorld.enemies = new Vector<Enemy>();
		GameWorld.enemies.add(new EnemyBase(100, 50, 1, 0));
		while(true) {
			clear();
			GameWorld.player.draw(this);
			GameWorld.player.move();
//			movePlayerBullets();
			movePracticeBullets();
			moveEnemies();
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
	
	public void moveEnemies() {
		for(int i = 0; i < GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			e.draw(this);
			e.move();
		}
	}
}

import java.util.Vector;

public class GameFrame extends MyFrame {
	public void run() {
		GameWorld.player = new Player(100,300,0,0);
//		GameWorld.player.draw(this);
		addKeyListener(GameWorld.player);
		GameWorld.stage = 1;
		GameWorld.score = 0;
		while(true) {
			GameWorld.player.x = 100;
			GameWorld.player.y = 300;
			GameWorld.playerBullets = new Vector<PlayerBullet>();
			GameWorld.practiceBullets = new Vector<PracticeBullet>();
			GameWorld.enemies = new Vector<Enemy>();
			GameWorld.enemies.add(new EnemyBase(120, 50, GameWorld.stage, 0));
			GameWorld.enemies.add(new OriginalEnemy(5, 50, GameWorld.stage, 0));
			while(true) {
				clear();
				drawString("Stage = " + GameWorld.stage, 300, 50, 15);
				drawString("Score = " + GameWorld.score, 300, 80, 15);
				GameWorld.player.draw(this);
				GameWorld.player.move();
				movePlayerBullets();
				movePracticeBullets();
				moveEnemies();
				checkPlayerAndEnemies();
				checkPlayerBulletsAndEnemies();
				if(GameWorld.enemies.size() == 0) {
					setColor(0, 0, 0);
				    drawString("クリア！", 100, 200, 40);

				    // ★画面に反映されるように短くsleep
				    sleep(0.5);

				    // ★Enterが押されるまで待つループ
				    while (!GameWorld.enterPressed) {
				        sleep(0.03);
				    }
				    
				    GameWorld.stage++;
					GameWorld.enterPressed = false;
					break;
//					if(GameWorld.enterPressed) {
//						GameWorld.stage++;
//						GameWorld.enterPressed = false;
//						break;
//					}
				}else if(GameWorld.player.y < 0) {
					setColor(0, 0, 0);
					drawString("GameOver", 50, 200, 40);
					if(GameWorld.enterPressed) {
						GameWorld.stage = 1;
						GameWorld.score = 0;
						break;
					}
				}
				sleep(0.03);
			}
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
		int i = 0;
		while(i < GameWorld.enemies.size()) {
			Enemy e = GameWorld.enemies.get(i);
			if(e.y > 400) {
				GameWorld.enemies.remove(i);
			}else {
				i++;
			}
		}
	}
	
	public void checkPlayerAndEnemies() {
		for(int i = 0; i < GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			if(checkHit(GameWorld.player,e)) {
				System.out.println("やられた！");
				GameWorld.player.y = -1000;
			}
		}
	}
	
	public void checkPlayerBulletsAndEnemies() {
		int i = 0;
		while(i < GameWorld.playerBullets.size()) {
			PlayerBullet b = GameWorld.playerBullets.get(i);
			int j = 0;
			int hits = 0;
			while(j < GameWorld.enemies.size()) {
				Enemy e = GameWorld.enemies.get(j);
				if(checkHit(e,b)) {
					System.out.println("あたり");
					hits++;
					e.life--;
				}
				if(e.life <= 0) {
					GameWorld.score += e.score;
					GameWorld.enemies.remove(j);
				}
				else {
					j++;
				}
			}
			if(hits > 0) {
				GameWorld.playerBullets.remove(i);
			}else {
				i++;
			}
		}
	}
	
	public boolean checkHit(Character a, Character b) {
//		練習問題12-2.
		if(Math.abs(a.x-b.x) <= 30 &&
		   Math.abs(a.y-b.y) <= 30) {
			return true;
		}else {
			return false;
		}
	}
}

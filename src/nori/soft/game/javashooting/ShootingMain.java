package nori.soft.game.javashooting;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

//Shooting Main Class
public class ShootingMain {

    public static ShootingJFrame shootingFrame;
    public static boolean gameLoop;

    public static void main(String[] args) {
        ShootingMain.shootingFrame = new ShootingJFrame();
        gameLoop = true;

        Graphics gameGraphics = shootingFrame.shootingPanel.getGraphics();

        EnumShootingScreen gameScreenEnum = EnumShootingScreen.START;

        int playerX = 0, playerY = 0;
        ArrayList<Bullet> bullets = new ArrayList<>();
        ArrayList<Bullet> bullets_enemy = new ArrayList<>();
        ArrayList<Enemy> enemies = new ArrayList<>();

        Random random = new Random();
        Keyboard key = new Keyboard();

        while (gameLoop) {

            gameGraphics.setColor(Color.WHITE);
            gameGraphics.fillRect(0, 0, 500, 500);

            switch (gameScreenEnum) {
                case START:
                    gameGraphics.setColor(Color.BLACK);

                    Font gameTitleFont = new Font("SansSerif", Font.BOLD, 30);
                    gameGraphics.setFont(gameTitleFont);
                    FontMetrics gameTitleFontMetrics = gameGraphics.getFontMetrics(gameTitleFont);

                    gameGraphics.drawString("Java Shooting 2020", 250 - gameTitleFontMetrics.stringWidth("Java Shooting 2020") / 2, 100);
                    gameGraphics.drawString("Press SPACE to Start", 250 - gameTitleFontMetrics.stringWidth("Press SPACE to Start") / 2, 350);
                    if (key.isKeyPressed(KeyEvent.VK_SPACE)) {

                        bullets = new ArrayList<>();
                        enemies = new ArrayList<>();

                        playerX = 225;
                        playerY = 400;

                        gameScreenEnum = EnumShootingScreen.GAME;
                    }
                    break;
                case GAME:
                    gameGraphics.setColor(Color.BLUE);
                    gameGraphics.fillRect(playerX + 10, playerY, 10, 10);
                    gameGraphics.fillRect(playerX, playerY + 10, 30, 10);

                    for (int i = 0; i < bullets.size(); i++) {
                        Bullet bullet = bullets.get(i);
                        gameGraphics.setColor(Color.blue);
                        gameGraphics.fillRect(bullet.x, bullet.y, 5, 5);
                        bullet.y -= 30;
                        if (bullet.y < 0) bullets.remove(bullet);
                    }

                    gameGraphics.setColor(Color.red);

                    for (int i = 0; i < enemies.size(); i++) {
                        Enemy enemy = enemies.get(i);
                        gameGraphics.fillRect(enemy.x, enemy.y, 30, 10);
                        gameGraphics.fillRect(enemy.x + 10, enemy.y + 10, 30, 10);
                        enemy.y+=5;
                        if(enemy.y>500)
                            enemies.remove(i);

                        if(random.nextInt(80 )==1)
                            bullets_enemy.add(new Bullet(enemy.x,enemy.y));

                        if(random.nextInt(100)==1)
                            enemies.add(new Enemy(random.nextInt(470),enemy.y));
                    }

                    for (int i = 0; i < bullets_enemy.size(); i++) {
                        Bullet bullet_enemy = bullets_enemy.get(i);
                        gameGraphics.setColor(Color.blue);
                        gameGraphics.fillRect(bullet_enemy.x, bullet_enemy.y, 5, 5);
                        bullet_enemy.y += 25;
                        if (bullet_enemy.y < 0) bullets.remove(bullet_enemy);
                    }

                    if (key.isKeyPressed(KeyEvent.VK_LEFT) && playerX > 0)
                        playerX -= 5;
                    if (key.isKeyPressed(KeyEvent.VK_RIGHT) && playerX < 450)
                        playerX += 5;

                    if (key.isKeyPressed(KeyEvent.VK_UP) && playerY > 0)
                        playerY -= 5;
                    if (key.isKeyPressed(KeyEvent.VK_DOWN) && playerY < 425)
                        playerY += 5;

                    if (key.isKeyPressed(KeyEvent.VK_SPACE))
                        bullets.add(new Bullet(playerX + 12, playerY));
                    break;
                case GAMEOVER:

                    break;

            }

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}

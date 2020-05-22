package nori.soft.game.javashooting;


import java.awt.*;
import java.awt.event.KeyEvent;

//Shooting Main Class
public class ShootingMain {

    public static ShootingJFrame shootingFrame;
    public static boolean gameLoop;

    public static void main(String[] args) {
        ShootingMain.shootingFrame=new ShootingJFrame();
        gameLoop=true;

        Graphics gameGraphics=shootingFrame.shootingPanel.getGraphics();

        EnumShootingScreen gameScreenEnum=EnumShootingScreen.START;

        int playerX,playerY;

        Keyboard key=new Keyboard();

        while(gameLoop){

            gameGraphics.setColor(Color.WHITE);
            gameGraphics.fillRect(0,0,500,500);

            switch (gameScreenEnum){
                case START:
                    gameGraphics.setColor(Color.BLACK);

                    Font gameTitleFont=new Font("SansSerif",Font.BOLD,30);
                    gameGraphics.setFont(gameTitleFont);
                    FontMetrics gameTitleFontMetrics=gameGraphics.getFontMetrics(gameTitleFont);

                    gameGraphics.drawString("Java Shooting 2020",250-gameTitleFontMetrics.stringWidth("Java Shooting 2020")/2,100);
                    gameGraphics.drawString("Press SPACE to Start",250-gameTitleFontMetrics.stringWidth("Press SPACE to Start")/2,350);
                    if(key.isKeyPressed(KeyEvent.VK_SPACE)){

                        gameScreenEnum=EnumShootingScreen.GAME;
                    }
                    break;
                case GAME:

                    break;
                case GAMEOVER:

                    break;

            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}

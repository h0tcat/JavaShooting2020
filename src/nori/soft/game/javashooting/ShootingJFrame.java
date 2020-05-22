package nori.soft.game.javashooting;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShootingJFrame extends JFrame {
    public ShootingJPanel shootingPanel;

    public  ShootingJFrame(){

        this.shootingPanel=new ShootingJPanel();

        this.add(this.shootingPanel);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                ShootingMain.gameLoop=true;
            }
        });

        this.addKeyListener(new Keyboard());

        this.setTitle("Shooting 2020");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(500,500);
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

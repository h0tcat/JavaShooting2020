package nori.soft.game.javashooting;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ShootingJPanel extends JPanel {
    public BufferedImage shootingPanelImage;

    public ShootingJPanel(){
        super();
        this.shootingPanelImage=new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(this.shootingPanelImage,0,0,this);
    }

    public void draw(){
        this.repaint();
    }
}

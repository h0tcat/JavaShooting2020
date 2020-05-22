package nori.soft.game.javashooting;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Keyboard extends KeyAdapter {

    public static ArrayList<Integer> preccedKeys;

    public Keyboard(){
        this.preccedKeys=new ArrayList<>();
    }

    public boolean isKeyPressed(int keyCode){
        return preccedKeys.contains(keyCode);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if(!this.preccedKeys.contains(e.getKeyCode())) this.preccedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        this.preccedKeys.remove((Integer)e.getKeyCode());
    }
}

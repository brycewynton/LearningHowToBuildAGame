package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler)
    {

        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;

    }

    public void keyPressed(KeyEvent e)
    {
        float key = e.getKeyCode();
        //System.out.println(key);
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.Player)            //  if this is Player 1, then these are all the major events he can perform
            {
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP ) { tempObject.setVelY(-6); keyDown[0] = true; }
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN ) { tempObject.setVelY(6); keyDown[1] = true; }
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) { tempObject.setVelX(6); keyDown[2] = true; }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) { tempObject.setVelX(-6); keyDown[3] = true; }
            }

            /*
            if (tempObject.getID() == ID.Player2)
            {
                if (key == KeyEvent.VK_UP) { tempObject.setVelY(-5); }
                if (key == KeyEvent.VK_DOWN) { tempObject.setVelY(1); }
                if (key == KeyEvent.VK_RIGHT) { tempObject.setVelX(1); }
                if (key == KeyEvent.VK_LEFT) { tempObject.setVelX(-5); }
            }
             */
        }
        if (key == KeyEvent.VK_ESCAPE) { System.exit(1); }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        //System.out.println(key);
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.Player)            //  if this is Player 1, then these are all the major events he can perform
            {
                if (key == KeyEvent.VK_W) {
                    keyDown[0] = false;
                }
                if (key == KeyEvent.VK_S) {
                    keyDown[1] = false;
                }
                if (key == KeyEvent.VK_D) {
                    keyDown[2] = false;
                }
                if (key == KeyEvent.VK_A) {
                    keyDown[3] = false;
                }

                //vertical movement
                if (!keyDown[0] && !keyDown[1]) { tempObject.setVelY(0); }
                //horizontal movement
                if (!keyDown[2] && !keyDown[3]) { tempObject.setVelX(0); }

            }
        }
    }
}

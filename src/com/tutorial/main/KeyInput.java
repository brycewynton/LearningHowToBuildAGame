package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private Handler handler;

    public KeyInput(Handler handler)
    {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        //System.out.println(key);
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.Player)            //  if this is Player 1, then these are all the major events he can perform
            {
                if (key == KeyEvent.VK_W) { tempObject.setVelY(-5); }
                if (key == KeyEvent.VK_S) { tempObject.setVelY(5); }
                if (key == KeyEvent.VK_D) { tempObject.setVelX(5); }
                if (key == KeyEvent.VK_A) { tempObject.setVelX(-5); }
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

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
    }
}

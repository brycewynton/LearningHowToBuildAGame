package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject
{
    Random r = new Random();
    Handler handler;

    public Player(float x, float y, ID id, Handler handler)
    {
        super(x,y,id);
        this.handler = handler;
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;

        x = Game.clamp(x,0,Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        handler.addObject(new PlayerTrail( x, y, ID.Trail, Color.black, 32,32, 0.06f, handler));

        collision();
    }

    private void collision()
    {
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() ==  ID.BasicEnemy)
            {
                if (getBounds().intersects(tempObject.getBounds()))  // tempObject referws to basicEnemy in this instance
                {
                    HUD.HEALTH -= 2;  // player health decreases if touch by the police officers
                }
            }
        }
    }

    @Override
    public void render(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.green);
        g2d.draw(getBounds());

        if (id == ID.Player) { g.setColor(Color.black); }      // Black man's plight
        else if (id == ID.Player2) { g.setColor(Color.white); } // player 2 gets to join the aqua police force to help murder the perpetrator with his fellow comrades
        g.fillRect((int)  x, (int) y,32,32);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int)  x, (int)  y,32,32);
    }
}

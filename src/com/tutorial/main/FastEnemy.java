package com.tutorial.main;

import java.awt.*;

public class FastEnemy extends GameObject
{
    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler)
    {
        super(x,y,id);
        this.handler = handler;
        velX = 8;
        velY = 8;
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;

        if ( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if ( x <= 0 || x >= Game.HEIGHT - 16) velX *= -1;

        handler.addObject(new Trail( (int) x, (int) y, ID.Trail, Color.blue, 16,16, 0.05f, handler));

        collision();

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y,16,16);
    }
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y,16,16);
    }

    private void collision()
    {
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.PlayerTrail)
            {
                if (getBounds().intersects(tempObject.getBounds()))  // tempObject refers to player Trail in this instance
                    {
                        HUD.HEALTH += 10;  // player health increases if he touches the police officers with trail
                    }
            }
        }
    }
}



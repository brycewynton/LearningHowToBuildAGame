package com.tutorial.main;

import java.awt.*;

public class EnemyBoss1 extends GameObject
{
    private Handler handler;
    private int timer = 120;

    public EnemyBoss1(float x, float y, ID id, Handler handler)
    {
        super(x,y,id);
        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;

        if (timer <= 0 )
        {
            velY = 0;
        }
        else
        {
            timer--;
        }

        //if ( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        //if ( x <= 0 || x >= Game.HEIGHT - 16) velX *= -1;

        handler.addObject(new Trail(  x, y, ID.Trail, Color.white, 128,128, 0.05f, handler));


    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect((int) x,(int) y,128,128);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y,128,128);
    }

}

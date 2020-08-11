package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullets extends GameObject
{
    private Handler handler;
    Random r = new Random();

    public EnemyBossBullets(float x, float y, ID id, Handler handler)
    {
        super(x,y,id);
        this.handler = handler;

        velX = r.nextInt((5 - -5) + -5);
        velY = 4;
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;

        //if ( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        //if ( x <= 0 || x >= Game.HEIGHT - 16) velX *= -1;

        if (y >= Game.HEIGHT)
        {
            handler.removeObject(this);
        }

        handler.addObject(new Trail(  x, y, ID.Trail, Color.orange, 4,4, 0.08f, handler));


    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.orange);
        g.fillRect((int) x,(int) y,4,4);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y,4,4);
    }

}

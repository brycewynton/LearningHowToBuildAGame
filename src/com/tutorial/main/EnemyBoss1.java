package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBoss1 extends GameObject
{
    private Handler handler;
    private int timer = 114;
    private int timer2 = 64;
    Random r = new Random();

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

        if (timer <= 0 ) { velY = 0; }
        else { timer--; }

        if (timer <= 0 ) { timer2--; }

        if (timer2 <= 0 )
        {
            if (velX == 0) { velX = 2; }
            if (velX > 0)
            {
                velX += 0.005f;
            }
            else if ( velX < 0)
            {
                velX -= 0.005f;
            }

            velX = Game.clamp(velX, 10, -10);

            int spawn = r.nextInt(10);
            if (spawn == 0) { handler.addObject((new EnemyBossBullets((int) x + 48, (int) y +48, ID.BasicEnemy, handler))); }
        }


        //if ( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if ( x <= 0 || x >= Game.HEIGHT - 16) velX *= -1;

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

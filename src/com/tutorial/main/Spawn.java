package com.tutorial.main;

import java.util.Random;

public class Spawn
{
    private Handler handler;
    private HUD hud;
    private float scoreKeep = 0;
    private Random r = new Random();

    public Spawn (Handler handler, HUD hud)
    {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick()
    {
        scoreKeep ++ ;

        if (scoreKeep >= 400) {
            scoreKeep = 0;
            hud.setLevel((int) hud.getLevel() + 1);


            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
            }
            else if (hud.getLevel() == 3)
            {
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.BasicEnemy, handler));
            }
            else if (hud.getLevel() == 4)
            {
                handler.addObject(new BasicEnemy(r.nextInt((int)  Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.BasicEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.FastEnemy, handler));

            }
            else if (hud.getLevel() == 5)
            {
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.FastEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH)-50, r.nextInt((int) Game.HEIGHT)-50, ID.SmartEnemy, handler));
            }
        }
    }
}

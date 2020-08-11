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


            if (hud.getLevel() == 2)
            {
                handler.addObject(new BasicEnemy(r.nextInt((int)  Game.WIDTH) -50, r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
            }
            else if (hud.getLevel() == 3)
            {
                handler.addObject(new HealthPellet(r.nextInt((int) Game.WIDTH) -50, r.nextInt((int) Game.HEIGHT)-50, ID.HealthPellet, handler));
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH) -50, r.nextInt((int) Game.HEIGHT)-50, ID.BasicEnemy, handler));
            }
            else if (hud.getLevel() == 7)
            {
                handler.addObject(new BasicEnemy(r.nextInt((int)  Game.WIDTH) -50, r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH) -50, r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH) -50, r.nextInt((int) Game.HEIGHT), ID.FastEnemy, handler));

            }
            else if (hud.getLevel() == 10)
            {
                handler.clearEnemies();
                handler.addObject(new EnemyBoss1((Game.WIDTH/2) - 48 ,-120, ID.EnemyBoss1, handler));
            }
        }
    }
}

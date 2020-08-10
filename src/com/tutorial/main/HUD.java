package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Color;


public class HUD
{
    public static float HEALTH = 100;
    private float greenValue = 255;
    private float score = 0;
    private float level = 1;

    public void tick()
    {
        HEALTH = Game.clamp(HEALTH, 0, 100);

        score++;
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(15,15,200,32);
        g.setColor(Color.green);
        g.fillRect(15,15,(int) HEALTH * 2,32);
        g.setColor(Color.white);
        g.drawRect(15,15,(int) HEALTH * 2,32);

        g.drawString("Score: "+score, 15, 64);
        g.drawString("Level: "+level, 15, 77);
    }

    public void score(int score)
    {
        this.score =score;
    }

    public float getScore()
    {
        return score;
    }

    public float getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }
}


package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Player extends GameObject
{
    Random r = new Random();

    public Player(int x, int y, ID id)
    {
        super(x,y,id);
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;

        x = Game.clamp(x,0,Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
    }

    @Override
    public void render(Graphics g)
    {
        if (id == ID.Player) g.setColor(Color.black);
        else if (id == ID.Player2) g.setColor(Color.blue);
        g.fillRect(x,y,32,32);
    }
}

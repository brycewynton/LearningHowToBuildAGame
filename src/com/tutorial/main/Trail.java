package com.tutorial.main;

import java.awt.*;

public class Trail extends GameObject
{
    private float alpha = 1;
    private Handler handler;
    private float width, height;
    private Color color;
    private float life;

    //life = 0.001 - 0.1

    public Trail(float x, float y, ID id, Color color, float width, float height,  float life, Handler handler)
    {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    }

    @Override
    public void tick()
    {
        if (alpha > life)
        {
            alpha -= life - 0.01f;
        }
        else
        {
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int) x, (int) y, (int) width, (int)height);
        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha)
    {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds()
    {
        return null;
    }
}

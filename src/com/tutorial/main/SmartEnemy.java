package com.tutorial.main;

import java.awt.*;

public class SmartEnemy extends GameObject
{
    private Handler handler;
    private GameObject player;

    public SmartEnemy(float x, float y, ID id, Handler handler)
        {
            super(x,y,id);
            this.handler = handler;

            for (int i = 0; i < handler.object.size(); i++)
            {
                if (handler.object.get(i).getID() == ID.Player) { player = handler.object.get(i); }
            }

        }

        @Override
        public void tick()
        {
            x += velX;
            y += velY;

            float diffX = x - player.getX() -8;
            float diffY = y - player.getX() -8;
            float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

            velX = (int) ((-1.0/distance) * diffX);
            velY = (int) ((-1.0/distance) * diffY);

            if ( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
            if ( x <= 0 || x >= Game.HEIGHT - 16) velX *= -1;

            handler.addObject(new Trail( (int) x, (int) y, ID.Trail, Color.green, 16,16, 0.05f, handler));

            collision();
        }

        @Override
        public void render(Graphics g)
        {
            g.setColor(Color.green);
            g.fillRect( (int) x, (int)y,16,16);
        }
        @Override
        public Rectangle getBounds()
        {
            return new Rectangle( (int) x, (int) y,16,16);
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


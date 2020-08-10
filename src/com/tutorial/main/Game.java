package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1550691097823471818L;
    public static final float WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;

    public Game()
    {
        handler = new Handler(); // initialize this first to avoid a null pointer?

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Let's Build A Game!",this);

        hud = new HUD();

        spawner = new Spawn(handler, hud);

        r = new Random();

        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player , handler));

        handler.addObject(new EnemyBoss1((Game.WIDTH / 2)-78, -180, ID.EnemyBoss1, handler));

    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop()
    {
        try {
            thread.join();      // kills off thread
            running = false;    //sets to false
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        float frames = 0;
        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                tick();
                delta--;
            }
            if (running)
            {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {
        handler.tick();
        hud.tick();
        spawner.tick();
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.cyan);
        g.fillRect(0,0, (int) WIDTH, (int) HEIGHT);

        handler.render(g);

        hud.render(g); // this placed second will place the display above the player

        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max)
    {
        if (var >= max )
        {
            return var = max;
        }
        else if (var <= min)
        {
            return var = min;
        }
        else
        {
            return var;
        }
    }

    public static void main(String[] args)
    {
        new Game();
    }
}


package com.tutorial.main;

import java.awt.*;

public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Game()
    {
        new Window(WIDTH, HEIGHT, "Let's Build A Game!",this);
    }


    public static void main(String[] args)
    {
        new Game();
    }

    public synchronized void start()
    {

    }

    @Override
    public void run() {

    }
}

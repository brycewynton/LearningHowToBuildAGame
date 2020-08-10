package com.tutorial.main;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;


public class Window extends Canvas
{
    private static final long serialVersionUID = -240840600533728354L;

    public Window(float width, float height, String title, Game game)
    {
        //frame of our window from JRE Library
        // set variable name to frame
        JFrame frame = new JFrame(title);
        // set up a new dimension with our preferred width and height
        frame.setPreferredSize(new Dimension((int) width, (int) height));
        frame.setMaximumSize(new Dimension((int) width, (int) height));
        frame.setMinimumSize(new Dimension((int) width, (int) height));
        //A way to actually stop the thread running the game operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Does not allow user to reset frame size
        frame.setResizable(false);
        //allows window to pop up in middle of the screen as opposed to upper left corner
        frame.setLocationRelativeTo(null);
        //actually adds the instance of game object to the frame
        frame.add(game);
        //make it actually visible
        frame.setVisible(true);
        //start our game
        game.start();
    }
}

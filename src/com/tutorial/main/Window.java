package com.tutorial.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas
{
    private static final long serialVersionUID = -240840600533728354L;

    public Window(int width, int height, String title, Game game)
    {
        //frame of our window from JRE Library
        // set variable name to frame
        JFrame frame = new JFrame(title);
        // set up a new dimension with our preferred width and height
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
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

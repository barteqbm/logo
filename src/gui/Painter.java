/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Bartek
 */
public class Painter {

    private JPanel canvas;
    private Turtle turtle;

    public Painter(JPanel canvas, Turtle turtle) {
        this.canvas = canvas;
        this.turtle = turtle;
    }

    public void clear() {
        Graphics g = canvas.getGraphics();

        g.setColor(Color.WHITE);
    }
}

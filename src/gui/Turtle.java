/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import math.UnitVector2;

/**
 *
 * @author Bartek
 */
public class Turtle {

    private JPanel panel = null;
    // Turtle's state
    private boolean isUp = false;
    private Color color = Color.BLACK;
    private math.UnitVector2 direction = new math.UnitVector2();
    private boolean isVisible = true;
    // Turtle's position
    private double x = 0.0;
    private double y = 0.0;
    private double nextX = 0.0;
    private double nextY = 0.0;
    
    private double xOffset;
    private double yOffeset;

    public Turtle(JPanel panel) {
        this.panel = panel;
    }

    public void setOffset(double xoffset, double yoffset) {
        xOffset = xoffset;
        yOffeset = yoffset;
        
    }
    
    // In degrees, not radians!
    public void rotate(double degrees) {
        direction.rotate(degrees);
    }

    public void up() {
        isUp = true;
    }

    public void down() {
        isUp = false;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void goForward(double distance) {
        if (isUp) {
            return;
        }

        move(distance);

        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine((int) x, (int) y, (int) nextX, (int) nextY);

        updatePosition();
    }

    public void goBack(double distance) {
        if (isUp) {
            return;
        }

        move(distance);
        nextX *= -1.0;
        nextY *= -1.0;

        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine((int) x, (int) y, (int) nextX, (int) nextY);

        updatePosition();
    }

    public void goTo(double x, double y) {
        nextX = x + xOffset;
        nextY = y + yOffeset;

        if (!isUp) {
            Graphics g = panel.getGraphics();
            g.setColor(color);
            g.drawLine((int) this.x, (int) this.y, (int) nextX, (int) nextY);
        }

        updatePosition();
    }

    public void show() {
        isVisible = true;
    }

    public void hide() {
        isVisible = false;
    }

    public void reset() {
        x = 0.0 + xOffset;
        y = 0.0 + yOffeset;
        nextX = 0.0;
        nextY = 0.0;
        color = Color.BLACK;
        direction = new UnitVector2();
        show();
        down();
    }

    public void draw() {
        if (isVisible) {
            // TODO:
            // Draw turtle
        }
    }

    private void move(double distance) {
        nextX = x + distance * direction.getX();
        nextY = y + distance * direction.getY();
    }

    private void updatePosition() {
        x = nextX;
        y = nextY;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.gui;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import pl.edu.agh.student.jfik.math.UnitVector2;

/**
 *
 * @author Bartek
 */
public class Turtle {

    private JPanel panel = null;
    // Turtle's state
    private boolean isUp = false;
    private Color color = Color.BLACK;
    private pl.edu.agh.student.jfik.math.UnitVector2 direction = new pl.edu.agh.student.jfik.math.UnitVector2();
    private boolean isVisible = true;
    // Turtle's position
    private double x = 0.0;
    private double y = 0.0;
    private double nextX = 0.0;
    private double nextY = 0.0;
    
    private double xOffset = 0.0;
    private double yOffeset = 0.0;

    public Turtle(JPanel panel) {
        this.panel = panel;
    }

    public void setOffset(double xoffset, double yoffset) {
        this.xOffset = Math.round(xoffset);
        this.yOffeset = Math.round(yoffset);
        
    }
    
    // In degrees, not radians!
    public void rotate(double degrees) {
        direction.rotate(degrees);
    }

    public void pickUp() {
        isUp = true;
    }

    public void put() {
        isUp = false;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void goForward(double distance) {
        moveForward(distance);
        
        if (isUp) {
            updatePosition();
            return;
        }

        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine((int) x, (int) y, (int) nextX, (int) nextY);

        updatePosition();
    }

    public void goBack(double distance) {
        moveBack(distance);
        
        if (isUp) {
            updatePosition();
            return;
        }

        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine((int) x, (int) y, (int) nextX, (int) nextY);

        updatePosition();
    }

    public void goTo(double x, double y) {
        nextX = Math.round(x + xOffset);
        nextY = Math.round(y + yOffeset);

        if (!isUp) {
            Graphics g = panel.getGraphics();
            g.setColor(color);
            g.drawLine((int)this.x, (int) this.y, (int) nextX, (int) nextY);
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
        x = Math.round(0.0 + xOffset);
        y = Math.round(0.0 + yOffeset);
        nextX = 0.0;
        nextY = 0.0;
        color = Color.BLACK;
        direction = new UnitVector2();
        show();
        put();
    }

    public void draw() {
        if (isVisible) {
            // TODO:
            // Draw turtle
        }
    }

    private void moveForward(double distance) {
        nextX = Math.round(x + distance * direction.getX());
        nextY = Math.round(y + distance * direction.getY());
    }
    
    private void moveBack(double distance) {
        nextX = Math.round(x - distance * direction.getX());
        nextY = Math.round(y - distance * direction.getY());
    }

    private void updatePosition() {
        x = nextX;
        y = nextY;
    }
}

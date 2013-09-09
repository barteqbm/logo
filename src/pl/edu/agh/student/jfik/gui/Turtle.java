/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.gui;

import java.awt.Color;

import pl.edu.agh.student.jfik.math.Matrix2x2;
import pl.edu.agh.student.jfik.math.MatrixFactory;
import pl.edu.agh.student.jfik.math.Triangle;
import pl.edu.agh.student.jfik.math.Vector2;

/**
 *
 * @author Bartek
 */
public class Turtle {

    private Canvas canvas = null;
    // Turtle's state
    private boolean isUp = false;
    private Color color = Color.GREEN;
    private boolean isVisible = true;
    
    // Turtle's triangle
    Triangle triangle = new Triangle(new Vector2(0.0, 0.0));    

    private Vector2 nextPosition = new Vector2(0.0, 0.0);
    
    // Turtle's rotation Matrix
    Matrix2x2 rotationMatrix = MatrixFactory.createRotationMatrix(0.0);
    


    public Turtle(Canvas canvas) {
        this.canvas = canvas;
    }
    
    // In degrees, not radians!
    public void rotate(double degrees) {
        rotationMatrix = MatrixFactory.createRotationMatrix(degrees);
        triangle.rotate(rotationMatrix);
    }

    public void pickUp() {
        isUp = true;
        color = Color.GRAY;
    }

    public void put() {
        isUp = false;
        color = Color.GREEN;
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

        canvas.drawLine(triangle.position(), nextPosition, color);

        updatePosition();
    }

    public void goBack(double distance) {
        moveBack(distance);
        
        if (isUp) {
            updatePosition();
            return;
        }

        canvas.drawLine(triangle.position(), nextPosition, color);

        updatePosition();
    }

    public void goTo(double x, double y) {
        nextPosition = new Vector2(x, y);

        if (!isUp) {
            canvas.drawLine(triangle.position(), nextPosition, color);
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
        triangle = new Triangle(new Vector2(0.0, 0.0));
        nextPosition = new Vector2(0.0, 0.0);
        color = Color.GREEN;
        show();
        put();
    }

    public void draw() {
        if (isVisible) {
        	canvas.dravTriangle(triangle, color);
        }
    }

    private void moveForward(double distance) {
        Vector2 translaction = Vector2.multiply(triangle.direction(), distance);
        nextPosition = Vector2.translate(triangle.position(), translaction);
    }
    
    private void moveBack(double distance) {
        Vector2 translaction = Vector2.multiply(triangle.direction(), -distance);
        nextPosition = Vector2.translate(triangle.position(), translaction);
    }

    private void updatePosition() {
        triangle.setPosition(nextPosition);
        draw();
    }
}

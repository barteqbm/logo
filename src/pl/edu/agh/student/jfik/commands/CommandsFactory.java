/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.commands;

import java.awt.Color;
import pl.edu.agh.student.jfik.gui.Turtle;
import pl.edu.agh.student.jfik.gui.PaintManager;
/**
 *
 * @author Bartek
 */
public class CommandsFactory {
    public CommandsFactory(PaintManager paintManager, Turtle turtle) {
        this.paintManager = paintManager;
        this.turtle = turtle;
    }
    
    private Turtle turtle = null;
    private PaintManager paintManager = null;
    
    // ---------------- Complex commands -----------------------------------------------
    public ICommand repeatCommand(int times, ICommand command) {
        return new RepeatCommand(times, command);
    }
    
    public CommandsSequence commandsSequence() {
        return new CommandsSequence();
    }
    
    // ------------------- Turtle behavior and visibility ------------------------------
    public ICommand pickUpTurtle() {
        return new TurtleBehaviorCommand(turtle, TurtleBehaviorCommand.CommandType.PICK_UP);
    }
    
    public ICommand putTurtle() {
        return new TurtleBehaviorCommand(turtle, TurtleBehaviorCommand.CommandType.PUT);
    }
    
    public ICommand showTurtle() {
        return new TurtleBehaviorCommand(turtle, TurtleBehaviorCommand.CommandType.SHOW);
    }
    
    public ICommand hideTurtle() {
        return new TurtleBehaviorCommand(turtle, TurtleBehaviorCommand.CommandType.HIDE);
    }
    
    // -----------------------Turtle  motion commands------------------------------------
    
    // Turtle's rotation
    // rotetes turtle in oposite to clockwise direction
    public ICommand rotateTurtle(double angle) {
        return new TurtleMotionCommand(turtle, TurtleMotionCommand.CommandType.ROTATE, angle);
    }
    
    public ICommand rotateTurtleLeft(double angle) {
        return new TurtleMotionCommand(turtle, TurtleMotionCommand.CommandType.ROTATE, angle);
    }
    
    public ICommand rotateTurtleRight(double angle) {
        return new TurtleMotionCommand(turtle, TurtleMotionCommand.CommandType.ROTATE, -1.0 * angle);
    }

    public ICommand turtleGoTo(double x, double y) {
        return new TurtlePositionCommand(turtle, x, y);
    }
    
    public ICommand turtleGoForward(double distance) {
        return new TurtleMotionCommand(turtle, TurtleMotionCommand.CommandType.GO_FORWARD, distance);
    }
    
    public ICommand turtleGoBack(double distance) {
        return new TurtleMotionCommand(turtle, TurtleMotionCommand.CommandType.GO_BACK, distance);
    }
    
    public ICommand turtleColor(Color color) {
        return new TurtleColorCommand(turtle, color);
    }
    
    //--------------------- Canvas commands -------------------------------------------------
    public ICommand resetCanvas() {
        return new PainterCommand(paintManager, PainterCommand.CommandType.RESET);
    }
    
    public ICommand clearCanvas() {
        return new PainterCommand(paintManager, PainterCommand.CommandType.CLEAR);
    }
}

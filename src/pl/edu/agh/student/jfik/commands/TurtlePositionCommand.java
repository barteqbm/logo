/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.commands;

import pl.edu.agh.student.jfik.gui.Turtle;

/**
 *
 * @author Bartek
 */
class TurtlePositionCommand extends TurtleCommand {

    private double x;
    private double y;
    
    public TurtlePositionCommand(Turtle turtle, double x, double y) {
        super(turtle);
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void execute() {
        turtle().goTo(x, y);
    }
    
}

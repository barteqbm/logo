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
abstract class TurtleCommand implements ICommand {

    Turtle turtle = null;
    
    public TurtleCommand(Turtle turtle) {
        this.turtle = turtle;
    }
    
    protected Turtle turtle() {
        return turtle;
    }
    
}

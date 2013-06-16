/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.commands;

import java.awt.Color;
import pl.edu.agh.student.jfik.gui.Turtle;

/**
 *
 * @author Bartek
 */
class TurtleColorCommand extends TurtleCommand {
    
    private Color color = null;
    
    public TurtleColorCommand(Turtle turtle, Color color) {
        super(turtle);
        this.color = color;
    }

    @Override
    public void execute() {
        
        turtle().setColor(color);
        
    }
    
}

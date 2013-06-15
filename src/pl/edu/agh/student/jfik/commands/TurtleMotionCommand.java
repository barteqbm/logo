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
class TurtleMotionCommand extends TurtleCommand {

    public enum CommandType {ROTATE, GO_FORWARD, GO_BACK};
    private CommandType command;
    private double value = 0.0;
    
    public TurtleMotionCommand(Turtle turtle, CommandType command, double value) {
        super(turtle);
        this.command = command;
        this.value = value;
    }
            
    @Override
    public void execute() {
        
        switch(command)
        {
            case ROTATE:
                turtle().rotate(value);
                break;
            case GO_FORWARD:
                turtle().goForward(value);
                break;
            case GO_BACK:
                turtle().goBack(value);
                break;
        }
        
    }
    
}

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
class TurtleBehaviorCommand extends TurtleCommand {

    public enum CommandType {HIDE, SHOW, PICK_UP, PUT};
    private CommandType command;
    
    public TurtleBehaviorCommand(Turtle turtle, CommandType command) {
        super(turtle);
        this.command = command;
    }
    
    @Override
    public void execute() {
        
        switch(command) {
            case HIDE:
                turtle().hide();
                break;
            case SHOW:
                turtle().show();
                break;
            case PICK_UP:
                turtle().pickUp();
                break;
            case PUT:
                turtle().put();
                break;
        }
        
    }
    
}

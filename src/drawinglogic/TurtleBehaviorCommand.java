/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawinglogic;

/**
 *
 * @author Bartek
 */
public class TurtleBehaviorCommand extends TurtleCommand {

    public enum CommandType {HIDE, SHOW, UP, DOWN};
    private CommandType command;
    
    public TurtleBehaviorCommand(CommandType command) {
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
            case UP:
                turtle().up();
                break;
            case DOWN:
                turtle().down();
                break;
        }
        
    }
    
}

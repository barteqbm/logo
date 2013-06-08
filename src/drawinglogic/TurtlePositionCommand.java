/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawinglogic;

/**
 *
 * @author Bartek
 */
public class TurtlePositionCommand extends TurtleCommand {

    private double x;
    private double y;
    
    public TurtlePositionCommand(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void execute() {
        
        turtle().goTo(x, y);
        
    }
    
}

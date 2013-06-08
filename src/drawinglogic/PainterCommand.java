/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawinglogic;

/**
 *
 * @author Bartek
 */
public class PainterCommand extends Command {

    public PainterCommand() {
        super();
    }

    @Override
    public void execute() {
        painter().clear();
    }
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawinglogic;

import gui.Turtle;
import gui.Painter;

/**
 *
 * @author Bartek
 */
public abstract class Command implements ICommand {
    
    private Turtle turtle = null;
    private Painter painter = null;
    
    public void setPainter(Painter painter) {
        this.painter = painter;
    }
    
    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }
    
    protected Turtle turtle() {
        return turtle;
    }
    
    protected Painter painter() {
        return painter;
    }
    
}

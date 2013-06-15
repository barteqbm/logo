/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.commands;

import pl.edu.agh.student.jfik.gui.PaintManager;
/**
 *
 * @author Bartek
 */
class PainterCommand implements ICommand {

    enum CommandType { RESET, CLEAR };
    
    private PaintManager paintManager = null;
    private CommandType commandType = null;
    
    public PainterCommand(PaintManager paintManager, CommandType command) {
        this.paintManager = paintManager;
        this.commandType = command;
    }

    @Override
    public void execute() {
        switch(commandType) {
            case RESET:
                painter().reset();
                break;
            case CLEAR:
                painter().clear();
                break;
        }
    }
    
    protected PaintManager painter() {
        return paintManager;
    }
    
    
}
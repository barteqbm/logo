/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.input;

import pl.edu.agh.student.jfik.commands.CommandsFacotry;
import pl.edu.agh.student.jfik.commands.ICommand;
import pl.edu.agh.student.jfik.gui.PaintManager;
import pl.edu.agh.student.jfik.parser.Parser;

/**
 *
 * @author Bartek
 */
public class InputProcessor {
    
    private CommandsFacotry factory = null;
    private PaintManager paintManager = null;
    
    private Parser parser = null;
    
    public InputProcessor(PaintManager manager) {
        this.paintManager = manager;
        this.factory = manager.commandsFactory();
        
        parser = new Parser(factory);
    }
    
    // input parameter represents string from text field in main window gui
    public void processInput(String input) {
        
        try
        {
            ICommand command = parser.parse(input);
            paintManager.queueCommand(command);
        }
        catch( Exception e ) // parser should throw an exception when command is wrong
        {
            // display error message
        }
       
        
    }
    
}

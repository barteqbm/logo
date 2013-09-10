/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.input;

import pl.edu.agh.student.jfik.commands.CommandsFactory;
import pl.edu.agh.student.jfik.commands.ICommand;
import pl.edu.agh.student.jfik.gui.PaintManager;
import pl.edu.agh.student.jfik.parser.Parser;

/**
 *
 * @author Bartek
 */
public class InputProcessor {
    
    private CommandsFactory factory = null;
    private PaintManager paintManager = null;
    
    private Parser parser = null;
    
    public InputProcessor(PaintManager manager) {
        this.paintManager = manager;
        this.factory = manager.commandsFactory();
        
        parser = new Parser(factory);
        parser.createLogoParser();
    }
    
    // input parameter represents string from text field in main window gui
    public boolean processInput(String input) {
        ICommand command = null;
        try
        {
            command = parser.parse(input);
            
            paintManager.queueCommand(command);
        }
        catch( Exception e ) // parser should throw an exception when command is wrong
        {
            // display error message
        }
       
        if(command != null) {
        	return true;
        } else {
        	return false;
        }
        
    }
    
}

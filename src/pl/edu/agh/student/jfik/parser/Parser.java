/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.parser;

import pl.edu.agh.student.jfik.commands.CommandsFacotry;
import pl.edu.agh.student.jfik.commands.ICommand;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Bartek
 */
public class Parser {
    
    private CommandsFacotry factory = null;
    
    public Parser(CommandsFacotry factory) {
        this.factory = factory;
    }
    
    public ICommand parse(String input) throws Exception {
         
        // TODO:
        // Create pareser and mplement me!
        
        //
        //Parser builds appropriate commands using methods from CommandsFactory.
        // Sequence of commands and loops also are commands (they implement ICommand interface).
        // test() method in PaintManager shows how to use them.
        //
        throw new NotImplementedException();
        
    }
}

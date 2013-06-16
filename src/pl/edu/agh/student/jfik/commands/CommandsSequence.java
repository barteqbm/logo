/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.commands;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Bartek
 */

public class CommandsSequence implements ICommand {

    public void addCommand(ICommand command) {
        commandsQueue.add(command);
    }

    //
    // Only CommandsFactory can create CommandsSequence
    //
    CommandsSequence() {
        
    }
    
    private Queue<ICommand> commandsQueue = new LinkedBlockingQueue<>();
    
    @Override
    public void execute() {
        
        for(ICommand i : commandsQueue) {
            i.execute();
        }
        
    }
    
    
}

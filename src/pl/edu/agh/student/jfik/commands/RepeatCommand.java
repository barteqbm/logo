/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.commands;

/**
 *
 * @author Bartek
 */
class RepeatCommand implements ICommand {

    private int times;
    private ICommand command;
    
    //
    // Oncly CommandsFactory can create RepeatCommand objects
    //
    RepeatCommand(int times, ICommand command) {
        this.times = times;
        this.command = command;
    }
    
    @Override
    public void execute() {
        
        for(int i = 0; i < times; i++ ) {
            command.execute();
        }
        
    }
    
    
    
}

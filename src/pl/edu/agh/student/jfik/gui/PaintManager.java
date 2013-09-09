/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.gui;

import pl.edu.agh.student.jfik.commands.CommandsFactory;

/**
 *
 * @author Bartek
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import pl.edu.agh.student.jfik.commands.ICommand;

public class PaintManager implements ComponentListener {

    private Canvas canvas = null;
    private Turtle turtle = null;
    private List<ICommand> commands = new LinkedList<>();
    private ListIterator<ICommand> iterator = commands.listIterator();
    private CommandsFactory commandsFacotry = null;

    public PaintManager(Canvas panel) {

        this.canvas = panel;
        this.canvas.setVisible(true);
        turtle = new Turtle(panel);

        panel.addComponentListener(this);
    }
    
    public CommandsFactory commandsFactory() {
        
        if( commandsFacotry == null )
        {
            commandsFacotry = new CommandsFactory(this, turtle);
        }
        
        return commandsFacotry;
    }

    public void queueCommand(ICommand command) {
        
        iterator.add(command);
        
        redraw();
    }

    private void executeCommands() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListIterator<ICommand> it = commands.listIterator();
                for (; it.hasNext() && it != iterator;) {
                    it.next().execute();
                }
                turtle.draw();
            }
        });
    }

    public void reset() {
        commands.clear();
    }

    public void undo() {
        if (iterator.hasPrevious()) {
            iterator.previous();
        }
        redraw();
    }

    public void redo() {
        if (iterator.hasNext()) {
            iterator.next();
        }
        redraw();
    }

    public void clear() {
    	reset();
        canvas.clear();
        turtle.draw();
    }
    
    public void test() {
        pl.edu.agh.student.jfik.commands.CommandsSequence triangle = commandsFactory().commandsSequence();
        
        triangle.addCommand(commandsFactory().rotateTurtleLeft(1200.0));
        triangle.addCommand(commandsFactory().turtleGoForward(100.0));
        
        ICommand repeat = commandsFactory().repeatCommand(3, triangle);
        
        pl.edu.agh.student.jfik.commands.CommandsSequence sequence = commandsFactory().commandsSequence();
        sequence.addCommand(repeat);
        
        sequence.addCommand(commandsFactory().pickUpTurtle());
        sequence.addCommand(commandsFactory().turtleGoForward(150.0));
        sequence.addCommand(commandsFactory().turtleColor(Color.red));
        sequence.addCommand(commandsFactory().putTurtle());
        
        sequence.addCommand(commandsFactory().turtleGoBack(50.0));
        
        pl.edu.agh.student.jfik.commands.CommandsSequence secondShape = commandsFactory().commandsSequence();
        secondShape.addCommand(commandsFactory().turtleColor(Color.green));
        
        secondShape.addCommand(commandsFactory().rotateTurtleRight(60.0));
        secondShape.addCommand(commandsFactory().turtleGoForward(50.0));
        
        ICommand repeat2 = commandsFactory().repeatCommand(6, secondShape);
        
        sequence.addCommand(repeat2);
        
        queueCommand(sequence);
    }

    private void redraw() {
        turtle.reset();
        canvas.clear();
        executeCommands();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        canvas.recalculateOffset();
        redraw();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // Do nothing
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // Do nothing
        canvas.recalculateOffset();
        redraw();
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // Do nothing
    }
}

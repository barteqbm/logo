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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.swing.SwingUtilities;
import pl.edu.agh.student.jfik.commands.ICommand;

public class PaintManager implements ComponentListener {

    private Canvas canvas = null;
    private Turtle turtle = null;
    private List<ICommand> commands = new LinkedList<>();
    private ListIterator<ICommand> iterator = commands.listIterator();
    private CommandsFactory commandsFacotry = null;
    
    private Map<String, ICommand> procedures = new HashMap<>();

    public PaintManager(Canvas canvas) {

        this.canvas = canvas;
        turtle = new Turtle(canvas);
        commandsFacotry = new CommandsFactory(this, turtle);
        canvas.addComponentListener(this);
        
        this.canvas.setVisible(true);
        this.canvas.updateUI();
    }
    
    public CommandsFactory commandsFactory() {        
        return commandsFacotry;
    }

    public void queueCommand(ICommand command) {
        iterator.add(command);
        
        redraw();
    }
    
    public void addProcedure(String name, ICommand procedure) {
    	procedures.put(name, procedure);
    }
    
    public ICommand getProcedure(String name) {
    	return procedures.get(name);
    }

    private void executeCommands() {
        ListIterator<ICommand> it = commands.listIterator();
        for (; it.hasNext() && it != iterator;) {
        	it.next().execute();
        }
    }

    public void reset() {
        commands.clear();
        procedures.clear();
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
        redraw();
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
    	canvas.updateUI();
    	SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				canvas.recalculateOffset();
				canvas.clear();
				turtle.reset();
		        
		        executeCommands();
		        turtle.draw();
			}
		});
    }

    @Override
    public void componentResized(ComponentEvent e) {
        redraw();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // Do nothing
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // Do nothing
        redraw();
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // Do nothing
    }
}

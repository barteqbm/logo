/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Bartek
 */
import drawinglogic.Command;
import drawinglogic.TurtleMotionCommand;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintManager implements ComponentListener {

    private JPanel panel = null;
    private Turtle turtle = null;
    private Painter painter = null;
    private List<Command> commands = new LinkedList<>();
    private ListIterator<Command> iterator = commands.listIterator();

    public PaintManager(JPanel panel) {

        this.panel = panel;
        this.panel.setVisible(true);
        turtle = new Turtle(panel);
        painter = new Painter(panel, turtle);

        panel.addComponentListener(this);

        turtle.setOffset(panel.getWidth() / 2.0, panel.getHeight() / 2.0 );
    }

    public void queueCommand(Command command) {
        command.setPainter(painter);
        command.setTurtle(turtle);

        iterator.add(command);
        
        //
        // TODO:
        // Change it! Each previous step should be
        // performed only when canvas has been resized,
        // or undo / redo action has been raised.
        // Oh! My english...
        //
        redraw();
    }

    private void executeCommands() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListIterator<Command> it = commands.listIterator();
                for (; it.hasNext() && it != iterator;) {
                    it.next().execute();
                }
                turtle.draw();
            }
        });
    }

    public void reset() {
        painter.clear();
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

    public void test() {
        for (int i = 0; i < 4; i++) {
            queueCommand(new TurtleMotionCommand(TurtleMotionCommand.CommandType.ROTATE, 90.0));
            queueCommand(new TurtleMotionCommand(TurtleMotionCommand.CommandType.GO_FORWARD, 40));
        }
    }

    private void redraw() {
        painter.clear();
        turtle.reset();

        executeCommands();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        turtle.setOffset(e.getComponent().getWidth() / 2.0, e.getComponent().getHeight() / 2.0);

        redraw();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // Do nothing
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // Do nothing
        turtle.setOffset(e.getComponent().getWidth() / 2.0, e.getComponent().getHeight() / 2.0);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // Do nothing
    }
}

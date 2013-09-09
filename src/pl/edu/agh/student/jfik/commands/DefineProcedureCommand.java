package pl.edu.agh.student.jfik.commands;

import pl.edu.agh.student.jfik.gui.PaintManager;

public class DefineProcedureCommand implements ICommand {

	private PaintManager paintManager;
	private String name;
	private ICommand procedure;
	
	public DefineProcedureCommand(PaintManager manager, String name, ICommand procedure) {
		paintManager = manager;
		this.name = name;
		this.procedure = procedure;
	}
	
	@Override
	public void execute() {
		paintManager.addProcedure(name, procedure);
	}
}

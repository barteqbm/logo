package pl.edu.agh.student.jfik.commands;

import pl.edu.agh.student.jfik.gui.PaintManager;

public class ExecuteProcedureCommand implements ICommand {

	private PaintManager paintManager;
	private String procedureName;
	
	public ExecuteProcedureCommand(PaintManager manager, String name) {
		paintManager = manager;
		procedureName = name;
	}
	
	@Override
	public void execute() {
		ICommand procedure = paintManager.getProcedure(procedureName);
		if(procedure != null)
		{
			procedure.execute();
		}
	}
	
}

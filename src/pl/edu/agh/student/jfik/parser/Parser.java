/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.student.jfik.parser;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import pl.edu.agh.student.jfik.commands.CommandsFactory;
import pl.edu.agh.student.jfik.commands.ICommand;

/**
 *
 * @author Bartek
 */
public class Parser {
    
    private CommandsFactory factory = null;
    private LogoParser logoParser;
    
    public Parser(CommandsFactory factory) {
        this.factory = factory;
    }
    
    public void createLogoParser(){
        logoParser = new LogoParser(System.in); //TODO!
    }
    
    public ICommand parse(String input) throws Exception {
        InputStream streamIn = new ByteArrayInputStream(input.getBytes());
        logoParser.ReInit(streamIn);
        return logoParser.parse(factory);
    }
}

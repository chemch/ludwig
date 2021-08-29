package com.lockettvesp.ludwig.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
@RequiredArgsConstructor
public class Command {
	private String description;
    private CommandType commandType;
    
    public Command(String description, CommandType commandType) {
    	this.description = description;
    	this.commandType = commandType;
    }
}

package com.lockettvesp.ludwig.model;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name="t_command")
public class Command {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private Long id;
	@NotNull
	private String description;
	@NotNull
    private CommandType commandType;
    
    public Command(String description, CommandType commandType) {
    	this.description = description;
    	this.commandType = commandType;
    }
}

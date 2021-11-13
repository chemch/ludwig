package com.lockettvesp.ludwig.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lockettvesp.ludwig.data.CommandRepository;
import com.lockettvesp.ludwig.data.ExtractionRepository;
import com.lockettvesp.ludwig.data.OperatorRepository;
import com.lockettvesp.ludwig.data.SourceRepository;
import com.lockettvesp.ludwig.data.UserRepository;
import com.lockettvesp.ludwig.model.Command;
import com.lockettvesp.ludwig.model.CommandType;
import com.lockettvesp.ludwig.model.Extraction;
import com.lockettvesp.ludwig.model.Operator;
import com.lockettvesp.ludwig.model.Source;
import com.lockettvesp.ludwig.model.SourceType;
import com.lockettvesp.ludwig.model.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/extraction")
@SessionAttributes("extraction")
public class ExtractionController {
	private final CommandRepository commandRepo;
	private final SourceRepository sourceRepo;
	private final ExtractionRepository extractionRepo;
	private final OperatorRepository operatorRepo;
	private UserRepository userRepo;
	
	@Autowired
	public ExtractionController(CommandRepository commandRepo, SourceRepository sourceRepo, 
			ExtractionRepository extractionRepo, OperatorRepository operatorRepo, UserRepository userRepo) {
		this.commandRepo = commandRepo;
		this.sourceRepo = sourceRepo;
		this.extractionRepo = extractionRepo;
		this.operatorRepo = operatorRepo;
		this.userRepo = userRepo;
	}
	
    @GetMapping
    public String showExtractionForm(Model model, Principal principal){
    	// get current user and set as the operator
    	String username = principal.getName();
    	User user = userRepo.findByUsername(username);
    	List<Operator> operators = new ArrayList<>();
    	operators.add(user);
    	// load available commands to run
    	List<Command> commands = new ArrayList<>();
    	commandRepo.findAll().forEach(i -> commands.add(i));
    	// load operators that could run
    	operatorRepo.findAll().forEach(i -> operators.add(i));
    	// load potential sources for artifacts
    	List<Source> sources = new ArrayList<>();
   	   	sourceRepo.findAll().forEach(i -> sources.add(i));
   	   	// load model values
   	   	model.addAttribute("commands", commands);
   	   	model.addAttribute("operators", operators);
   	   	model.addAttribute("sources", sources);
   	   	// add extraction to build 
   	   	model.addAttribute("extraction", new Extraction());
   	   	return "extraction";
    }

    @PostMapping
    public String runExtraction(@Valid Extraction extraction, Errors errors, SessionStatus sessionStatus) {
    	if (errors.hasErrors()) {
    		log.error("Invalid Extraction Data" + extraction);
    		return "redirect:/extraction";
    	}
        // save components and extraction
        commandRepo.save(extraction.getCommand());
        sourceRepo.save(extraction.getSource());
        operatorRepo.save(extraction.getOperator());
        extractionRepo.save(extraction);
        log.info("Recording - " + extraction);
        sessionStatus.setComplete(); 
        // send user to history page
        return "redirect:/history";
    }
}

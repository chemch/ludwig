package com.lockettvesp.ludwig.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lockettvesp.ludwig.data.CommandRepository;
import com.lockettvesp.ludwig.model.Command;
import com.lockettvesp.ludwig.model.CommandType;
import com.lockettvesp.ludwig.model.Extraction;
import com.lockettvesp.ludwig.model.Operator;
import com.lockettvesp.ludwig.model.Source;
import com.lockettvesp.ludwig.model.SourceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/extraction")
public class ExtractionController {
	private final CommandRepository commandRepo;
	
	@Autowired
	public ExtractionController(CommandRepository commandRepo) {
		this.commandRepo = commandRepo;
	}
	
    @GetMapping
    public String showExtractionForm(Model model){
    	// load available commands to run
    	List<Command> commands = new ArrayList<>();
    	commandRepo.findAll().forEach(i -> commands.add(i));
    	
       List<Operator> operators = Arrays.asList(
               new Operator("ghost"),
               new Operator("cartographer")
       );
       List<Source> sources = Arrays.asList(
               new Source(SourceType.WORKSTATION, "192.168.1.1"),
               new Source(SourceType.SERVER, "192.168.1.2")
       );
       // load model values
       model.addAttribute("commands", commands);
       model.addAttribute("operators", operators);
       model.addAttribute("sources", sources);
       // add extraction to build 
       model.addAttribute("extraction", new Extraction());
       return "extraction";
    }

    @PostMapping
    public String runExtraction(@Valid Extraction extraction, Errors errors) {
    	if (errors.hasErrors()) {
    		log.error("Invalid Extraction Data" + extraction);
    		return "redirect:/extraction";
    	}
        log.info("Running: " + extraction);
        return "redirect:/";
    }
}

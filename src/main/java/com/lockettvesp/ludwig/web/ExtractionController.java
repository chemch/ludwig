package com.lockettvesp.ludwig.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lockettvesp.ludwig.model.Command;
import com.lockettvesp.ludwig.model.CommandType;
import com.lockettvesp.ludwig.model.Extraction;
import com.lockettvesp.ludwig.model.Operator;
import com.lockettvesp.ludwig.model.Source;
import com.lockettvesp.ludwig.model.SourceType;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/extraction")
public class ExtractionController {
    @GetMapping
    public String showExtractionForm(Model model){
       List<Command> commands = Arrays.asList(
               new Command("Directories", CommandType.DIR),
               new Command("Anti-Malware Scan Interfaces", CommandType.AMSI_PROVIDERS)
       );
       
       List<Operator> operators = Arrays.asList(
               new Operator("ghost"),
               new Operator("cartographer")
       );
       
       List<Source> sources = Arrays.asList(
               new Source(SourceType.SERVER, "192.168.1.2"),
               new Source(SourceType.SERVER, "192.168.1.2")
       );
     
       model.addAttribute("commands", commands);
       model.addAttribute("operators", operators);
       model.addAttribute("sources", sources);
       model.addAttribute("extraction", new Extraction());
       return "extraction";
    }

    @PostMapping
    public String runExtraction(Extraction extraction) {
        log.info("Running: " + extraction);
        return "redirect:/";
    }
}

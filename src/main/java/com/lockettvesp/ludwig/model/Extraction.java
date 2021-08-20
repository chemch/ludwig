package com.lockettvesp.ludwig.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

@Slf4j
@Data
@RequiredArgsConstructor
public class Extraction {
    private final UUID id = UUID.randomUUID();
    private String title;
    private CommandType commandType;
    private Operator operator;
    private Source source;
   

    public Extraction(String title, CommandType commandType, Operator operator, Source source){
        this.title = title;
        this.commandType = commandType;
        this.operator = operator;
        this.source = source;
    }
}

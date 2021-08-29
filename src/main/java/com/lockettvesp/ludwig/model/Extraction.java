package com.lockettvesp.ludwig.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Extraction {
    private final UUID id = UUID.randomUUID();
    private LocalDateTime runDateTime = LocalDateTime.now();
    private String title;
    private Command command;
    private Operator operator;
    private Source source;
   

    public Extraction(String title, Command command, Operator operator, Source source){
        this.title = title;
        this.command = command;
        this.operator = operator;
        this.source = source;
    }
}

package com.lockettvesp.ludwig.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Data
@RequiredArgsConstructor
public class Operator {
    private final UUID id = UUID.randomUUID();
    private String callSign;
    
    public Operator(String callSign) {
    	this.callSign = callSign;
    }
}

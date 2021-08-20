package com.lockettvesp.ludwig.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RequiredArgsConstructor
public class Source {
	private final UUID id = UUID.randomUUID();
	private SourceType sourceType;
	private String ipAddress;
    
    public Source(SourceType sourceType, String ipAddress) {
    	this.sourceType = sourceType;
    	this.ipAddress = ipAddress;
    }
}

package com.lockettvesp.ludwig.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RequiredArgsConstructor
public class Command {
	private final String description;
    private final CommandType commandType;
}

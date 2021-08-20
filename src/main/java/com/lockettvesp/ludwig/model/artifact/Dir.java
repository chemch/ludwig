package com.lockettvesp.ludwig.model.artifact;

import com.lockettvesp.ludwig.model.CommandType;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@RequiredArgsConstructor
public class Dir extends BaseArtifact {
    private final CommandType commandType = CommandType.DIR;
}

package com.lockettvesp.ludwig.model.artifact;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.lockettvesp.ludwig.model.CommandType;

import java.util.UUID;

@Slf4j
@Data
public abstract class BaseArtifact implements Artifact {
    UUID id;
    CommandType commandType;
}

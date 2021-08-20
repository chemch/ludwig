package com.lockettvesp.ludwig.model.artifact;

import com.lockettvesp.ludwig.model.CommandType;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RequiredArgsConstructor
public class AmsiProviders extends BaseArtifact {
    @SuppressWarnings("unused")
	private final CommandType commandType = CommandType.AMSI_PROVIDERS;
}

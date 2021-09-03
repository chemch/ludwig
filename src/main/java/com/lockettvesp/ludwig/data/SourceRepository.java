package com.lockettvesp.ludwig.data;

import org.springframework.data.repository.CrudRepository;

import com.lockettvesp.ludwig.model.Command;
import com.lockettvesp.ludwig.model.Source;

public interface SourceRepository extends CrudRepository<Source, Long> {
}

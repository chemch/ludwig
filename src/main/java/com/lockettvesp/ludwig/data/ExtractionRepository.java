package com.lockettvesp.ludwig.data;

import org.springframework.data.repository.CrudRepository;

import com.lockettvesp.ludwig.model.Command;
import com.lockettvesp.ludwig.model.Extraction;
import com.lockettvesp.ludwig.model.Operator;
import com.lockettvesp.ludwig.model.Source;

public interface ExtractionRepository extends CrudRepository<Extraction, Long> {
}

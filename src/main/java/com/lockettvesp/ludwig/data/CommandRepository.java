package com.lockettvesp.ludwig.data;

import org.springframework.data.repository.CrudRepository;

import com.lockettvesp.ludwig.model.Command;

public interface CommandRepository extends CrudRepository<Command, Long> {
}

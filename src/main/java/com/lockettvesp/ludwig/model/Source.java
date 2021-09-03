package com.lockettvesp.ludwig.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Entity
public class Source {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private SourceType sourceType;
	@NotNull
	private String ipAddress;
    
    public Source(SourceType sourceType, String ipAddress) {
    	this.sourceType = sourceType;
    	this.ipAddress = ipAddress;
    }
}

package com.lockettvesp.ludwig.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name="t_source")
public class Source {
	@NotNull
	private SourceType sourceType;
	@Id
	@NotNull
	private String ipAddress;
    
    public Source(SourceType sourceType, String ipAddress) {
    	this.sourceType = sourceType;
    	this.ipAddress = ipAddress;
    }
}

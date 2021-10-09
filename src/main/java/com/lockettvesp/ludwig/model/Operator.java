package com.lockettvesp.ludwig.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name="t_operator")
public class Operator {
	@Id
	@NotNull
    private String callSign;
    
    public Operator(String callSign) {
    	this.callSign = callSign;
    }
}

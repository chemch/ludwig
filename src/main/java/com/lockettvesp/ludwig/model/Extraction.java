package com.lockettvesp.ludwig.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name="t_extraction")
public class Extraction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; 
    @NotNull
    @Size(min=3, message="Title must be at least 3 characters")
    private String title;
    @NotNull
    @ManyToOne(targetEntity=Command.class)
    private Command command;
    @NotNull
    @ManyToOne(targetEntity=Operator.class)
    private Operator operator;
    @NotNull
    @ManyToOne(targetEntity=Source.class)
    private Source source;
    private Date createdDate;
    
    @PrePersist
    void createdDate() {
    	this.createdDate = new Date();
    }
   
    public Extraction(String title, Command command, Operator operator, Source source) {
        this.title = title;
        this.command = command;
        this.operator = operator;
        this.source = source;
    }
}

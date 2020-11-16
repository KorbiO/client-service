package com.example.demo.entity;

import java.time.LocalDate;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avis {
	
	private String id;        
	private String mat;
	private String avis ; 
	private LocalDateTime dateAvis ; 
	
	private Client client;
	
	public String getId( ) {
        return this.mat;
    }
	
}

package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livraison {
	private String id;        
	private String mat;
	private String modeLiv ; 


	public String getId( ) {
        return this.mat;
    }
}

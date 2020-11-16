package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneLivraison {
	private String id;        
	private String mat;
	private Date dateLiv;
	
	private Livraison livraison;
	
	public String getId( ) {
        return this.mat;
    }

}

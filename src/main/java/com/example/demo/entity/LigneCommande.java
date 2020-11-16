package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommande {
	
	private String id;        
	private String mat;
	private int qteArtLC ;
	
	private Article article ;
	
	public String getId( ) {
        return this.mat;
    }
	


}

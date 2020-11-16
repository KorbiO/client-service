
package com.example.demo.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
	private String id;        
	private String mat;
	private LocalDateTime dateCmd; 
	private double totalCmd; 
	private String modePaiement;
	private List<LigneCommande> ligneCmd ; 
	private Client clientCmd;
	private LigneLivraison ligneLivraisonCmd;

	
	public String getId( ) {
        return this.mat;
    }
	
	
}

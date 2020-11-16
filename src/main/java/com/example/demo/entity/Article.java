package com.example.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	
	private String id;        
	private String mat;
	private String designtationArt;
	private String descriptionArt;
	private  double prixArt;
	private int qteStockArt;
	private double tauxRemiseArt;

	private Marque marqueArt;
	private SousCategorie sousCategorieArt;

	private Fournisseur fournisseurArt;

	private  double prixArtVF;
    private int qteStockArtVF;
    private Boolean isArtVF;
	
	
private String imageName ;
	//private ImageModel imageModel ;
	private Avis avisArt ; 
	
	public String getId( ) {
        return this.mat;
    }
	
	
	private Avis avis ;
}

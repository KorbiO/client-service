package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Client;
import com.example.demo.entity.Article;
import com.example.demo.entity.Avis;
import com.example.demo.entity.Categorie;
import com.example.demo.entity.Commande;
import com.example.demo.entity.Facture;
import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.LigneCommande;
import com.example.demo.entity.Marque;
import com.example.demo.entity.Order;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.SousCategorie;
import com.example.demo.entity.VenteFlash;
import com.example.demo.service.CrudRestClient;
import com.example.demo.service.PaymentRestClient;
import com.paypal.api.payments.Payment;

@RestController
public class ClientController {

	@Autowired
	private CrudRestClient crudRest;
	
	
	
	@PutMapping("/article/{id}")
	public Article updateArtAvis(@RequestBody Article artice ,@PathVariable("id") String id)
	{
		
		Article a = crudRest.findArticleById(id);
		Avis avis = crudRest.postAvis(artice.getAvisArt());
		avis.setDateAvis(java.time.LocalDateTime.now());
		a.setAvisArt(avis);
		crudRest.updatArticle(a, id);
		return a; 
	}
	
	@GetMapping("/avis")
	public Resources<Avis> getAllAvis(){
		return crudRest.findAllAvis();
	}

	@PutMapping("/avis/{id}")
	public Avis modifyAvis(@RequestBody Avis avis ,@PathVariable("id") String id) {
		Avis a = crudRest.findAvisById(id);
		Avis as = new Avis();
		as.setDateAvis(avis.getDateAvis());
		as.setAvis(avis.getAvis());
		as.setDateAvis(avis.getDateAvis());
		as.setClient(avis.getClient());
		crudRest.modifyAvis(as, id);
		
	return as ;	
	}
	
	@DeleteMapping("/avis/{id}")
	public void deleteById(@PathVariable("id") String id){
		crudRest.deleteById(id);
	}
	
	// Gestion Reclamation
	
	
	@PostMapping("/reclamation")
	public Reclamation reclamation(@RequestBody Reclamation reclamation) {
		Reclamation rec = new Reclamation();
		rec.setDateRec(java.time.LocalDate.now());
		rec.setReclamation(reclamation.getReclamation());
		rec.setCommande(reclamation.getCommande());
		
		crudRest.postReclamation(rec);
		return rec ;
	}
	@GetMapping("/reclamation")
	public Resources<Reclamation> getAllReclamation(){
		return crudRest.findAllReclamation();
	}
	@PutMapping("/reclamation/{id}")
	public Reclamation modifyReclamation(@RequestBody Reclamation reclamation ,@PathVariable("id") String id) {
		Reclamation rec = new Reclamation();
		rec.setDateRec(java.time.LocalDate.now());
		rec.setReclamation(reclamation.getReclamation());
		rec.setCommande(reclamation.getCommande());
		crudRest.modifyReclamation(reclamation, id);
		return rec ;
	}
	@DeleteMapping("/reclamation/{id}")
	public void deleteReclamationById(@PathVariable("id") String id){
		crudRest.deleteReclamationById(id);
	}
	
	
	

	
	/*Manager
	 *client
	 */
	

	
	//update Client
	@PutMapping("/client/{id}")
	public Client modifyFour(@RequestBody Client client , @PathVariable("id") String id) {
		
				Client clt = new Client();
				clt.setPhoneNumber(client.getPhoneNumber());
				clt.setCin(client.getCin());
				clt.setUsername(client.getUsername());
				clt.setPassword(client.getPassword());
				clt.setNom(client.getNom());
				clt.setPrenom(client.getPrenom());
				
					
		crudRest.updatClient(clt,id);
		return clt;	
	}
	
	@GetMapping("/client/{id}")
	public Client getClientById(@PathVariable("id") String id ){
		return crudRest.findClientById(id);
	}
	
	// liste : Marque + Catégorie + sous catégorie + Article 
	
	@GetMapping("/article")
	public Resources<Article> getAllArticle(){
		return crudRest.findAllArticle();
	}
	@GetMapping("/article/{id}")
	public Article getAllArticleById(@PathVariable("id") String id ){
		return crudRest.findArticleById(id);
	}
	
	@GetMapping("/marque")
	public Resources <Marque> getAllMarque(){
		return crudRest.findAllMarque();
	}
	@GetMapping("/marque/{id}")
	public Marque getAllMarqueById(@PathVariable("id") String id ){
		return crudRest.findMarqueById(id);
	}
	
	@GetMapping("/categorie")
	public Resources <Categorie> getAllCategorie(){
		return crudRest.findAllCategorie();
	}
	@GetMapping("/categorie/{id}")
	public Categorie getAllCategorieById(@PathVariable("id") String id ){
		return crudRest.findCategorieById(id);
	}
	
	@GetMapping("/souscategorie")
	public Resources <SousCategorie> getAllSousCategorie(){
		return crudRest.findAllSousCategorie();
		}
	@GetMapping("/souscategorie/{id}")
	public SousCategorie getAllSousCategorieById(@PathVariable("id") String id ){
		return crudRest.findSousCategorieById(id);
	}

	
	@GetMapping("/venteflash/{id}")
	public VenteFlash findVenteflashById(@PathVariable("id") String id)  {
		return crudRest.findVenteFlashById(id);
	
	}
	
	@GetMapping("/venteflash")
	public Resources<VenteFlash> findAllVente(){
		return crudRest.findAllVente();
	}
	@PostMapping("/commande")
    public Commande addCommande (@RequestBody Commande commande) {
        Commande cmd = new Commande();
        Facture fact = new Facture();
        Order ord = new Order();
        LigneCommande ln= new LigneCommande();
        cmd.setId(commande.getId());
        cmd.setMat(commande.getMat());

 

        cmd.setTotalCmd(commande.getTotalCmd());
        cmd.setModePaiement(commande.getModePaiement());
        cmd.setClientCmd(commande.getClientCmd());
        cmd.setLigneLivraisonCmd(commande.getLigneLivraisonCmd());
        
        List<LigneCommande> a = new ArrayList<LigneCommande>();
        List<LigneCommande> l = new ArrayList<LigneCommande>();

 

        a = commande.getLigneCmd();
      for(int e=0;  e< a.size(); e++) {
       l.add(a.get(e));
         
       
        Article article = crudRest.findArticleById(a.get(e).getArticle().getId());
        int ns =article.getQteStockArt()-a.get(e).getQteArtLC();
        Article art = new Article();
        art.setMat(article.getMat());
        art.setId(article.getId());
        art.setDesigntationArt(article.getDesigntationArt());
        art.setDescriptionArt(article.getDescriptionArt());
       
        art.setPrixArt(article.getPrixArt());
        art.setQteStockArt(ns);
        art.setTauxRemiseArt(article.getTauxRemiseArt());
        art.setMarqueArt(commande.getLigneCmd().get(e).getArticle().getMarqueArt());
        art.setSousCategorieArt(commande.getLigneCmd().get(e).getArticle().getSousCategorieArt());
        art.setFournisseurArt(commande.getLigneCmd().get(e).getArticle().getFournisseurArt());
        crudRest.updatArticle(art,commande.getLigneCmd().get(e).getArticle().getId());
        }
        cmd.setLigneCmd(l);
       
        crudRest.postCommande(cmd);
        fact.setId(commande.getId());
        fact.setMat(commande.getMat());
        fact.setCommandeLiv(cmd);
        fact.setRemiseFact(0.0);
        fact.setTva(10);
        fact.setTotalTtc(cmd.getTotalCmd());
        fact.setTotalTva(cmd.getTotalCmd());

 

        crudRest.postFacture(fact);
        
        return cmd ;
    }
	
}

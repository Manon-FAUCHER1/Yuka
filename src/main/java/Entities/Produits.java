package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author manon
 *
 */
@Entity
@Table(name = "Produits")
public class Produits {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nom", nullable = false, length = 255)
	private String nom;
	
	@Column(name = "Energie_100g", nullable = true)
	private double energie100g;
	
	@Column(name = "Graisse_100g", nullable = true)
	private double graisse100g;
	
	@Column(name = "Sucres_100g", nullable = true)
	private double sucres100g;
	
	@Column(name = "Fibre_100g", nullable = true)
	private double fibres100g; 
	
	@Column(name = "Proteines_100g", nullable = true)
	private double proteines100g;
	
	@Column(name = "Sel_100g", nullable = true)
	private double sel100g;
	
	@Embedded
	private ProduitInfoComplementaire ProduitInfoComplementaire;
	
	@Enumerated(EnumType.STRING)
	private NutritionGradeFr nutritionGradeFr;

	
	///////// RELATION /////////////
	
	@ManyToOne
	@JoinColumn(name = "Id_Categorie")
	private Categories categorie;
	
	@ManyToOne
	@JoinColumn(name = "Id_Marque")
	private Marques marque;
	
	@ManyToMany
	@JoinTable(name="REL_PRODUITS_INGREDIENTS",
		joinColumns= @JoinColumn(name="ID_PRODUITS", referencedColumnName="Id"),
		inverseJoinColumns= @JoinColumn(name="ID_INGREDIENTS", referencedColumnName="Id")
	)
	private List<Ingredients> ingredients = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="REL_PRODUITS_ALLERGENES",
		joinColumns= @JoinColumn(name="ID_PRODUITS", referencedColumnName="Id"),
		inverseJoinColumns= @JoinColumn(name="ID_ALLERGENES", referencedColumnName="Id")
	)
	private List<Allergenes> allergenes = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="REL_PRODUITS_ADDITIFS",
		joinColumns= @JoinColumn(name="ID_PRODUITS", referencedColumnName="Id"),
		inverseJoinColumns= @JoinColumn(name="ID_ADDITIFS", referencedColumnName="Id")
	)
	private List<Additifs> additifs = new ArrayList<>();

	/**
	 * Construtor
	 */
	public Produits() {}

	///////// GETTERS & SETTERS /////////////

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getEnergie100g() {
		return energie100g;
	}


	public void setEnergie100g(double energie100g) {
		this.energie100g = energie100g;
	}


	public double getGraisse100g() {
		return graisse100g;
	}


	public void setGraisse100g(double graisse100g) {
		this.graisse100g = graisse100g;
	}


	public double getSucres100g() {
		return sucres100g;
	}


	public void setSucres100g(double sucres100g) {
		this.sucres100g = sucres100g;
	}


	public double getFibres100g() {
		return fibres100g;
	}


	public void setFibres100g(double fibres100g) {
		this.fibres100g = fibres100g;
	}


	public double getProteines100g() {
		return proteines100g;
	}


	public void setProteines100g(double proteines100g) {
		this.proteines100g = proteines100g;
	}


	public double getSel100g() {
		return sel100g;
	}


	public void setSel100g(double sel100g) {
		this.sel100g = sel100g;
	}


	public Categories getCategorie() {
		return categorie;
	}


	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}


	public Marques getMarque() {
		return marque;
	}


	public void setMarque(Marques marque) {
		this.marque = marque;
	}


	public List<Ingredients> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public NutritionGradeFr getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	public void setNutritionGradeFr(NutritionGradeFr nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}

	public ProduitInfoComplementaire getProduitInfoComplementaire() {
		return ProduitInfoComplementaire;
	}

	public void setProduitInfoComplementaire(ProduitInfoComplementaire produitInfoComplementaire) {
		ProduitInfoComplementaire = produitInfoComplementaire;
	}

	public List<Allergenes> getAllergenes() {
		return allergenes;
	}

	public void setAllergenes(List<Allergenes> allergenes) {
		this.allergenes = allergenes;
	}

	public List<Additifs> getAdditifs() {
		return additifs;
	}

	public void setAdditifs(List<Additifs> additifs) {
		this.additifs = additifs;
	}

	@Override
	public String toString() {
		return "Produits [id=" + id + ", nom=" + nom + ", energie100g=" + energie100g + ", graisse100g=" + graisse100g
				+ ", sucres100g=" + sucres100g + ", fibres100g=" + fibres100g + ", proteines100g=" + proteines100g
				+ ", sel100g=" + sel100g + ", ProduitInfoComplementaire=" + ProduitInfoComplementaire
				+ ", nutritionGradeFr=" + nutritionGradeFr + ", categorie=" + categorie + ", marque=" + marque
				+ ", ingredients=" + ingredients + "]";
	}


}

package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author manon
 *
 */
@Entity
@Table(name = "MARQUES")
public class Marques {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nom", nullable = false, length = 255)
	private String nom;
	
	///////// RELATION /////////////
	
	@OneToMany(mappedBy = "marque")
	private List<Produits> produits;

	
	/**
	 * Constructor
	 */
	public Marques() {}


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

	public List<Produits> getProduits() {
		return produits;
	}


	public void setProduits(List<Produits> produits) {
		this.produits = produits;
	}


	@Override
	public String toString() {
		return "Marques [id=" + id + ", nom=" + nom + ", produits=" + produits + "]";
	}


	
	

}

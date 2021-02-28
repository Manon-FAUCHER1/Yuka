package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author manon
 *
 */
@Entity
@Table(name = "Additifs")
public class Additifs {

	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nom", nullable = false, length = 255)
	private String nom;

	///////// RELATION /////////////

	@ManyToMany
	@JoinTable(name = "REL_PRODUITS_ADDITIFS", 
	joinColumns = @JoinColumn(name = "ID_ADDITIFS", referencedColumnName = "Id"), 
	inverseJoinColumns = @JoinColumn(name = "ID_PRODUITS", referencedColumnName = "Id"))
	private List<Produits> produits;

	/**
	 * Constructor
	 */
	public Additifs() {}

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
		return "Additifs [id=" + id + ", nom=" + nom + ", produits=" + produits + "]";
	}
	
	

	
	
}

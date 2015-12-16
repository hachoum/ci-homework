package fr.esiag.isidis.ci.homework.dao.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ETABLISSEMENT")
public class Etablissement implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_etablissement")
    private Long id;
	
	@Column(name = "siret_etablissement")
	private Integer siret;
	
	@Column(name = "adr_etablissement")
	private String adresse;
	
	@Column(name = "siege_etablissement")
	private Boolean siege;
	
	@ManyToOne
	private Entreprise entreprise;

	public Integer getSiret() {
		return siret;
	}

	public void setSiret(Integer siret) {
		this.siret = siret;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Boolean getSiege() {
		return siege;
	}

	public void setSiege(Boolean siege) {
		this.siege = siege;
	}

	public Long getId() {
		return id;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

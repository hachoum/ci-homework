package fr.esiag.isidis.ci.homework.dao.dao.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ENTREPRISE")
@NamedQueries({
    @NamedQuery(name="entreprise.findEntrepriseBySiren", query="select e from Entreprise e where e.siren = :siren")
}) 
public class Entreprise implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_entreprise")
    private Long id;
	
	@Column(name = "denom_entreprise")
	private String denomination;
	
	@Column(name = "siren_entreprise")
	private Integer siren;
	
	@Column(name = "cnaf_entreprise")
	private String codeNaf;
	
	@Column(name = "fju_entreprise")
	private String formeJuridique;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dcre_entreprise")
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dmi_entreprise")
	private Date dateMiseAjour;
	
	@OneToMany
	@JoinColumn(name="ORDER_ID")
	private Collection<Etablissement> etablissements;

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public Integer getSiren() {
		return siren;
	}

	public void setSiren(Integer siren) {
		this.siren = siren;
	}

	public String getCodeNaf() {
		return codeNaf;
	}

	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateMiseAjour() {
		return dateMiseAjour;
	}

	public void setDateMiseAjour(Date dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}

	public Long getId() {
		return id;
	}

	public Collection<Etablissement> getEtablissements() {
		return etablissements;
	}

	public void setEtablissements(Collection<Etablissement> etablissements) {
		this.etablissements = etablissements;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
	
}

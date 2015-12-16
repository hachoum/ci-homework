package fr.esiag.isidis.ci.homework.ws.model;

import java.util.Date;

public class EntrepriseRest {

	private String denomination;
	
	private Integer numeroSiren;
	
	private String codeActivite;
	
	private String formeJuridique;
	
	private Date dateCreation;
	
	private Date dateMiseAjour;

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public Integer getNumeroSiren() {
		return numeroSiren;
	}

	public void setNumeroSiren(Integer numeroSiren) {
		this.numeroSiren = numeroSiren;
	}

	public String getCodeActivite() {
		return codeActivite;
	}

	public void setCodeActivite(String codeActivite) {
		this.codeActivite = codeActivite;
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
	
	
}

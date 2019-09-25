package com.geldopc.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstimativaSelic {
	
	private int id;
	private Date data_referencia;
	private Double estimativa_taxa_selic;
	
	@JsonIgnore
	public Date getData_referencia() {
		return data_referencia;
	}
	
	public Double getEstimativa_taxa_selic() {
		return estimativa_taxa_selic;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Data: " + sdf.format(getData_referencia()) + " - Valor: " + getEstimativa_taxa_selic();
	}

	public int getAno() {
		LocalDate localDate = getData_referencia().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getYear();
	}

	public int getMes() {
		LocalDate localDate = getData_referencia().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getMonthValue();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

package com.geldopc.model;

public class MediaEstimativaSelic {

	private int ano;
	private double media;

	public MediaEstimativaSelic(int ano, double media) {
		this.ano = ano;
		this.media = media;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

}
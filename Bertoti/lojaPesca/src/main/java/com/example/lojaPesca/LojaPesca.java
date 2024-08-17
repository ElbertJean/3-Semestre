package com.example.lojaPesca;

public class LojaPesca {
	private final String id;
	private String marcaLinha;
	private String mmLinha;
	
	public LojaPesca(String id, String marcaLinha, String mmLinha) {
		this.id = id;
		this.marcaLinha = marcaLinha;
		this.mmLinha = mmLinha;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getMarcaLinha() {
		return this.marcaLinha;
	}
	
	public String getMmLinha() {
		return this.mmLinha;
	}
	
	public void setMarcaLinha(String marcaLinha) {
		this.marcaLinha = marcaLinha;
	}
	
	public void setMmLinha(String mmLinha) {
		this.mmLinha = mmLinha;
	}
}

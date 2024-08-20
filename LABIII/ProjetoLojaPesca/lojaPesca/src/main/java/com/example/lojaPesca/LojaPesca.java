package com.example.lojaPesca;

public class LojaPesca {
	private final String id;
	private String lineMark;
	private String mmLine;
	
	public LojaPesca(String id, String lineMark, String mmLine) {
		this.id = id;
		this.lineMark = lineMark;
		this.mmLine = mmLine;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getLineMark() {
		return this.lineMark;
	}
	
	public String getMmLine() {
		return this.mmLine;
	}
	
	public void setLineMark(String lineMark) {
		this.lineMark = lineMark;
	}
	
	public void setMmLine(String mmLine) {
		this.mmLine = mmLine;
	}
}

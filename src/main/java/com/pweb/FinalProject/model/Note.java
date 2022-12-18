package com.pweb.FinalProject.model;

public class Note {
	private int id;
	private String text;
	
	public Note(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}

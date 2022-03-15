package com.levig.dea;

public abstract class Vraag {

	protected String vraag;

	public Vraag(String vraag) {
		this.vraag = vraag;
	}

	public abstract void toonVraag();

}

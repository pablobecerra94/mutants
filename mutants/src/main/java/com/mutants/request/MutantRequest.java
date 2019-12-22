package com.mutants.request;

/**
 * Represents the request of the mutant service 
 * Its a String array that contains the human dna
 * @author Pablo
 *
 */
public class MutantRequest {

	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

}

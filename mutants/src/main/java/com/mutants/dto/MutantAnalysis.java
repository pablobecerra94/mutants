package com.mutants.dto;

/**
 * Mutant Analysis DTO Entity that is written to the database
 * 
 * @author Pablo
 *
 */
public class MutantAnalysis {

	private String[] dna;

	private boolean isMutant;


	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

}

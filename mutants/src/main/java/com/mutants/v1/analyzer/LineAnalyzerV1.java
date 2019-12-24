package com.mutants.v1.analyzer;

/**
 * Its a interface to implement the analysis in each direction
 * 
 * @author Pablo
 *
 */
public interface LineAnalyzerV1  {
	
	/**
	 * Analyze the array in one direction
	 * 
	 * @param dna
	 * @return the number of equal character strings detected in the diagonals
	 */
	int analyze(char[][] dna);

}

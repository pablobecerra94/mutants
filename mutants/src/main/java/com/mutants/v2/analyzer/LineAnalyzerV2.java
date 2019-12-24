package com.mutants.v2.analyzer;

/**
 * Its a interface to implement the analysis in each direction
 * 
 * @author Pablo
 *
 */
public interface LineAnalyzerV2 {

	/**
	 * Analyze the array in one direction
	 * 
	 * @param dna
	 * @return the number of equal character strings detected in the diagonals
	 */
	int analyze(String dna, int arrayLength);

	/**
	 * @param arrayLength
	 * @return the regular expression to detect the character secuence
	 */
	String getExpression(int arrayLength);

}

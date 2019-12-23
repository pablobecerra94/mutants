package com.mutants.v1.analyzer;

import com.mutants.constants.Constants;

/**
 * Analyze each column to detect strings of 4 equal characters
 * 
 * @author Pablo
 *
 */
public class VerticalAnalyzerV1 implements LineAnalyzerV1 {

	/**
	 * @param dna
	 * @return the number of equal character strings detected in the diagonals
	 */
	@Override
	public int analyze(char[][] dna) {
		int repeatedAmount = 0;
		for (int j = 0; j < dna.length; j++) {
			int charCount = 0;
			for (int i = 0; i < dna.length - 1; i++) {
				if (dna[i][j] == dna[i + 1][j]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == Constants.SECUENCE_AMOUNT) {
					repeatedAmount++;
					charCount = 0;
				}
			}
		}
		return repeatedAmount;
	}

}

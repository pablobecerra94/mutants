package com.mutants.v1.analyzer;

import com.mutants.constants.Constants;

/**
 * Analyze the diagonals below the secondary diagonal in ascending order to
 * detect strings of 4 equal characters
 * 
 * @author Pablo
 *
 */
public class InvertedDiagonalLowerAnalyzerV1 implements LineAnalyzerV1 {


	@Override
	public int analyze(char[][] dna) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = 0; i < dna.length - Constants.SECUENCE_AMOUNT; i++) {
			charCount = 0;
			for (int j = 0; j < dna.length - i - 2; j++) {
				if (dna[dna.length - j - 1][j + i + 1] == dna[dna.length - j - 1][j + i + 2]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == Constants.SECUENCE_AMOUNT) {
					repeatedAmount++;
					repeatedAmount = 0;
				}
			}
		}
		return repeatedAmount;
	}

}

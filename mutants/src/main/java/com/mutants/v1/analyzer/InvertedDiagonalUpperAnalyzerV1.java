package com.mutants.v1.analyzer;

import com.mutants.constants.Constants;

/**
 * Analyze the diagonals above the secondary diagonal in ascending order to
 * detect strings of 4 equal characters
 * 
 * @author Pablo
 *
 */
public class InvertedDiagonalUpperAnalyzerV1 implements LineAnalyzerV1 {

	@Override
	public int analyze(char[][] dna) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = Constants.SECUENCE_AMOUNT; i < dna.length; i++) {
			charCount = 0;
			for (int j = 0; j < i; j++) {
				if (dna[i - j][j] == dna[i - j][j + 1]) {
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

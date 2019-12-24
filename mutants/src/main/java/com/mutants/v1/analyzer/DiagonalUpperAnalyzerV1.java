package com.mutants.v1.analyzer;

import com.mutants.constants.Constants;


/**
 * Analyze the diagonals above the main diagonal in descending order to detect
 * strings of 4 equal characters
 * 
 * @author Pablo
 *
 */
public class DiagonalUpperAnalyzerV1 implements LineAnalyzerV1 {

	@Override
	public int analyze(char[][] dna) {
		int repeatedAmount = 0;
		int charCount;
		for (int j = 1; j < dna.length - Constants.SECUENCE_AMOUNT; j++) {
			charCount = 0;
			for (int i = 0; i < dna.length - j - 1; i++) {
				if (dna[i][i + j] == dna[i + 1][i + j + 1]) {
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

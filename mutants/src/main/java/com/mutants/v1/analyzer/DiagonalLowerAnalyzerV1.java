package com.mutants.v1.analyzer;

import com.mutants.constants.Constants;

/**
 * Analyze the diagonals below the main diagonal in descending order to detect
 * strings of 4 equal characters
 * 
 * @author Pablo
 *
 */
public class DiagonalLowerAnalyzerV1 implements LineAnalyzerV1 {


	@Override
	public int analyze(char[][] dna) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = 0; i < dna.length - Constants.SECUENCE_AMOUNT; i++) {
			charCount = 0;
			for (int j = 0; j < dna.length - i - 1; j++) {
				if (dna[i + j][j] == dna[i + j + 1][j + 1]) {
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

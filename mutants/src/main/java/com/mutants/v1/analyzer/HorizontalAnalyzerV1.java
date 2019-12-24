package com.mutants.v1.analyzer;

import com.mutants.constants.Constants;

/**
 * 
 * Analyze each row to detect strings of 4 equal characters
 * 
 * 
 * @author Pablo
 *
 */
public class HorizontalAnalyzerV1 implements LineAnalyzerV1 {


	@Override
	public int analyze(char[][] dna) {
		int repeatedAmount = 0;

		for (int i = 0; i < dna.length; i++) {
			int charCount = 0;
			for (int j = 0; j < dna.length - 1; j++) {
				if (dna[i][j] == dna[i][j + 1]) {
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

package com.mutants.v2.analyzer;

import com.mutants.constants.Constants;
import com.mutants.enumerator.ValidCharacter;

/**
 * Analyze the inverted diagonals in ascending order to detect strings of 4
 * equal characters
 * 
 * @author Pablo
 *
 */
public class InvertedDiagonalAnalyzerV2 implements LineAnalyzerV2 {

	@Override
	public int analyze(String dna, int arrayLength) {
		int repeatedAmount = 0;
		String expression = getExpression(arrayLength);
		while (dna.length() > arrayLength * Constants.SECUENCE_AMOUNT) {
			dna = dna.substring(Constants.SECUENCE_AMOUNT);
			for (int i = 0; i < arrayLength - Constants.SECUENCE_AMOUNT; i++) {
				if (dna.matches(expression)) {
					repeatedAmount++;
				}
				dna = dna.substring(1);
			}

		}
		return repeatedAmount;
	}

	@Override
	public String getExpression(int arrayLength) {
		StringBuilder regularExpressionBuilder = new StringBuilder();
		for (ValidCharacter validCharacter : ValidCharacter.values()) {
			regularExpressionBuilder.append("(" + validCharacter);
			for (int i = 0; i < Constants.SECUENCE_AMOUNT; i++) {
				for (int j = 0; j < arrayLength - 2; j++) {
					regularExpressionBuilder.append(".");
				}
				regularExpressionBuilder.append(validCharacter);
			}
			regularExpressionBuilder.append(".*)|");
		}
		return regularExpressionBuilder.toString();
	}

}

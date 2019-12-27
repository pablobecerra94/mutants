package com.mutants.v2.analyzer;

import com.mutants.constants.Constants;
import com.mutants.enumerator.ValidCharacter;

/**
 * Analyze each column to detect strings of 4 equal characters
 * 
 * @author Pablo
 *
 */
public class VerticalAnalyzerV2 implements LineAnalyzerV2 {

	@Override
	public int analyze(String dna, int arrayLength) {
		int repeatedAmount = 0;
		String expression = getExpression(arrayLength);
		while (dna.length() > arrayLength * Constants.SECUENCE_AMOUNT) {
			if (dna.matches(expression)) {
				repeatedAmount++;
			}

			dna = dna.substring(1);
		}
		return repeatedAmount;
	}

	@Override
	public String getExpression(int arrayLength) {
		StringBuilder regularExpressionBuilder = new StringBuilder();
		for (ValidCharacter validCharacter : ValidCharacter.values()) {
			regularExpressionBuilder.append(Constants.INITIAL_REGULAR_EXPRESSION_CHARACTERS + validCharacter);
			for (int i = 0; i < Constants.SECUENCE_AMOUNT; i++) {
				for (int j = 0; j < arrayLength - 1; j++) {
					regularExpressionBuilder.append(Constants.REGULAR_EXPRESION_ANY_CHARACTER);
				}
				regularExpressionBuilder.append(validCharacter);
			}
			regularExpressionBuilder.append(Constants.FINAL_REGULAR_EXPRESSION_CHARACTERS);
		}
		return regularExpressionBuilder.toString();
	}

}

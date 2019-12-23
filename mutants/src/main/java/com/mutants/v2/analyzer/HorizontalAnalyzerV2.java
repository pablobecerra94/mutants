package com.mutants.v2.analyzer;

import com.mutants.constants.Constants;
import com.mutants.enumerator.ValidCharacter;

public class HorizontalAnalyzerV2 implements LineAnalyzerV2 {

	@Override
	public int analyze(String dna, int arrayLength) {
		int repeatedAmount = 0;
		String expression = getExpression(arrayLength);
		while (dna.length() > Constants.SECUENCE_AMOUNT) {

			for (int i = 0; i < arrayLength - Constants.SECUENCE_AMOUNT; i++) {
				if (dna.matches(expression)) {
					repeatedAmount++;
				}
				dna = dna.substring(1);
			}
			dna = dna.substring(Constants.SECUENCE_AMOUNT);
		}
		return repeatedAmount;
	}

	@Override
	public String getExpression(int arrayLength) {
		StringBuilder regularExpressionBuilder = new StringBuilder();

		for (ValidCharacter validCharacter : ValidCharacter.values()) {
			regularExpressionBuilder.append("(");
			for (int i = 0; i <= Constants.SECUENCE_AMOUNT; i++) {
				regularExpressionBuilder.append(validCharacter);
			}
			regularExpressionBuilder.append(".*)|");
		}

		return regularExpressionBuilder.toString();
	}


}

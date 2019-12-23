package com.mutants.strategy;

import java.util.ArrayList;
import java.util.List;

import com.mutants.constants.Constants;
import com.mutants.enumerator.LineAnalyzerV2Type;
import com.mutants.exception.InvalidDnaException;
import com.mutants.v2.analyzer.LineAnalyzerV2;

public class MutantSolverV2 implements MutantSolver {

	private List<LineAnalyzerV2> linesAnalyzer;

	public MutantSolverV2() {
		linesAnalyzer = new ArrayList<>();
		for (LineAnalyzerV2Type type : LineAnalyzerV2Type.values()) {
			linesAnalyzer.add(type.getLineAnalyzer());
		}
	}

	@Override
	public boolean isMutant(String[] dna) throws InvalidDnaException {
		String finalDna = buildString(dna);
		int arrayLength = dna.length;

		int repeatedAmount = 0;
		for (LineAnalyzerV2 analyzer : linesAnalyzer) {
			repeatedAmount += analyzer.analyze(finalDna, arrayLength);
			if (repeatedAmount >= Constants.MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
				return true;
			}
		}

		return false;
	}


	private String buildString(String[] dna) {

		StringBuilder stringBuilder = new StringBuilder();

		for (String dnaString : dna) {
			stringBuilder.append(dnaString);
		}

		return stringBuilder.toString();
	}

}

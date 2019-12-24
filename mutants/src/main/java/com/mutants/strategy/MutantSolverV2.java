package com.mutants.strategy;

import java.util.ArrayList;
import java.util.List;

import com.mutants.constants.Constants;
import com.mutants.enumerator.LineAnalyzerV2Type;
import com.mutants.exception.InvalidDnaException;
import com.mutants.v2.analyzer.LineAnalyzerV2;

/**
 * First version. If there is a string of 5 equal characters, it is taken as a
 * two sequences of 4 characters (characters from 1 to 4 and characters from 2 to 5)
 * 
 * @author Pablo
 *
 */
public class MutantSolverV2 implements MutantSolver {

	private List<LineAnalyzerV2> linesAnalyzer;

	public MutantSolverV2() {
		linesAnalyzer = new ArrayList<>();
		for (LineAnalyzerV2Type type : LineAnalyzerV2Type.values()) {
			linesAnalyzer.add(type.getLineAnalyzer());
		}
	}

	/**
	 * Method responsible for detecting whether humans are mutants
	 * 
	 * @param dna
	 * @return true if the human is mutant, false if he is not mutant
	 * @throws InvalidDnaException
	 */
	@Override
	public boolean isMutant(String[] dna) throws InvalidDnaException {
		if (dna == null || dna.length == 0) {
			throw new InvalidDnaException(Constants.THE_DNA_MUST_NOT_BE_EMPTY);
		}
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


	/**
	 * Transform String array to a single String
	 * 
	 * @param dna
	 * @param length
	 * @return
	 * @throws InvalidDnaException
	 */
	private String buildString(String[] dna) {

		StringBuilder stringBuilder = new StringBuilder();

		for (String dnaString : dna) {
			stringBuilder.append(dnaString);
		}

		return stringBuilder.toString();
	}

}

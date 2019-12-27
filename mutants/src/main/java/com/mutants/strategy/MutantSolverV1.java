package com.mutants.strategy;

import java.util.ArrayList;
import java.util.List;

import com.mutants.constants.Constants;
import com.mutants.enumerator.LineAnalyzerV1Type;
import com.mutants.exception.InvalidDnaException;
import com.mutants.utils.StringArrayUtils;
import com.mutants.v1.analyzer.LineAnalyzerV1;

/**
 * First version. If there is a string of 5 equal characters, it is taken as a
 * single sequence of 4 characters (characters 1 to 4)
 * 
 * @author Pablo
 *
 */
public class MutantSolverV1 implements MutantSolver {

	private List<LineAnalyzerV1> linesAnalyzer;

	public MutantSolverV1() {
		linesAnalyzer = new ArrayList<>();
		for (LineAnalyzerV1Type type : LineAnalyzerV1Type.values()) {
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

		char[][] finalDna = StringArrayUtils.transform1DStringArrayTo2DCharArray(dna);
		
		
		int repeatedAmount = 0;
		for(LineAnalyzerV1 analyzer : linesAnalyzer) {
			repeatedAmount += analyzer.analyze(finalDna);
			if (repeatedAmount >= Constants.MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
				return true;
			}
		}

		return false;
	}

}

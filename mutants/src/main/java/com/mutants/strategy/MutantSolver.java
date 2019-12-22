package com.mutants.strategy;

import com.mutants.exception.InvalidDnaException;

public interface MutantSolver {

	boolean isMutant(String[] dna) throws InvalidDnaException;

}

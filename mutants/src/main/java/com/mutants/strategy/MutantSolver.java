package com.mutants.strategy;

import com.mutants.exception.InvalidDnaException;

/**
 * Interface to implement the different versions of the algorithm
 * 
 * @author Pablo
 *
 */
public interface MutantSolver {

	boolean isMutant(String[] dna) throws InvalidDnaException;

}

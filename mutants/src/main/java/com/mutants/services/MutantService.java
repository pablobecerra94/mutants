package com.mutants.services;

import org.springframework.stereotype.Service;

import com.mutants.enumerator.MutantVersion;
import com.mutants.exception.InvalidDnaException;
import com.mutants.strategy.MutantSolver;

/**
 * Service that contains the logic to detect mutants
 * @author Pablo
 *
 */
@Service
public class MutantService {

	/**
	 * Solve the mutant algorithm, a human is mutant if there is more than one
	 * sequence of 4 equal characters horizontally, vertically or obliquely
	 * 
	 * @param dna
	 * @param version
	 * @return
	 * @throws InvalidDnaException
	 */
	public boolean isMutant(String[] dna, MutantVersion version) throws InvalidDnaException {
		MutantSolver mutantSolver = version.getMutantSolver();
		return mutantSolver.isMutant(dna);
	}

}

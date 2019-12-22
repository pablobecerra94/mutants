package com.mutants.enumerator;

import com.mutants.strategy.MutantSolver;
import com.mutants.strategy.MutantSolverV1;

/**
 * Represents the different versions to solve the mutant algorithm
 * 
 * @author Pablo
 *
 */
public enum MutantVersion {

	V1(new MutantSolverV1()), V2(new MutantSolverV1()), V3(new MutantSolverV1());

	private MutantSolver mutantSolver;

	private MutantVersion(MutantSolver mutantSolver) {
		this.mutantSolver = mutantSolver;
	}

	public MutantSolver getMutantSolver() {
		return mutantSolver;
	}

	public void setMutantSolver(MutantSolver mutantSolver) {
		this.mutantSolver = mutantSolver;
	}

}

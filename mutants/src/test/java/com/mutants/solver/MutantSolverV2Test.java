package com.mutants.solver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mutants.exception.InvalidDnaException;
import com.mutants.strategy.MutantSolver;
import com.mutants.strategy.MutantSolverV2;

public class MutantSolverV2Test {

	private static MutantSolver mutantSolver;

	@BeforeClass
	public static void instanciateMutantSolver() {
		mutantSolver = new MutantSolverV2();
	}

	@Test
	public void isMutantExample() throws InvalidDnaException {
		String dna[] = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		assertTrue(mutantSolver.isMutant(dna));
	}

	@Test
	public void isNotMutantExample() throws InvalidDnaException {
		String dna[] = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
		assertFalse(mutantSolver.isMutant(dna));
	}

	@Test
	public void isNotMutantOneSequenceHorizontal() throws InvalidDnaException {
		String dna[] = { "AAAA", "TATA", "CGAG", "CAGG" };
		assertFalse(mutantSolver.isMutant(dna));
	}

	@Test
	public void isMutantOnlyHorizontal() throws InvalidDnaException {
		String dna[] = { "AAAA", "AAAA", "CGAG", "CAGG" };
		assertTrue(mutantSolver.isMutant(dna));
	}

	@Test
	public void isMutantOnlyVertical() throws InvalidDnaException {
		String dna[] = { "AATC", "AACG", "AAGT", "AATC" };
		assertTrue(mutantSolver.isMutant(dna));
	}

	@Test
	public void isMutantOnlyDiagonal() throws InvalidDnaException {
		String dna[] = { "AACTG", "GAACT", "CGAAG", "TCTAA", "TCAGT" };
		assertTrue(mutantSolver.isMutant(dna));
	}

	@Test
	public void isMutantOnlyUpperInvertedDiagonal() throws InvalidDnaException {
		String dna[] = { "ACTATT", "CGATGC", "AATTTA", "ATCGGG", "GTCACT", "GCTATC" };
		assertTrue(mutantSolver.isMutant(dna));
	}

	@Test
	public void isMutantOnlyLowerInvertedDiagonal() throws InvalidDnaException {
		String dna[] = { "GATAC", "AAACC", "TGCCA", "GCCCT", "GCGTG" };
		assertTrue(mutantSolver.isMutant(dna));
	}

	@Test
	public void isMutantWithOnlyOneSequenceOfFiveSameCharacters() throws InvalidDnaException {
		String dna[] = { "AAAAA", "TATCT", "TGGCG", "GTTGT", "ACTGT" };
		assertTrue(mutantSolver.isMutant(dna));
	}

	@Test
	public void isNotMutantWithTwoSequenceOfThreeSameCharacters() throws InvalidDnaException {
		String dna[] = { "AAAC", "TTTA", "TGGC", "GTTG" };
		assertFalse(mutantSolver.isMutant(dna));
	}

	@Test(expected = InvalidDnaException.class)
	public void isInvalidDna() throws InvalidDnaException {
		String dna[] = {};
		mutantSolver.isMutant(dna);
	}

}

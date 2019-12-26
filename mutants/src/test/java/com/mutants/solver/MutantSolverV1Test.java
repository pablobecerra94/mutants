package com.mutants.solver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutants.MutantsApplication;
import com.mutants.TestConstants;
import com.mutants.exception.InvalidDnaException;
import com.mutants.strategy.MutantSolverV1;

/**
 * Test V1 algorithm
 * 
 * @author Pablo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MutantsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MutantSolverV1Test {
	
	private static MutantSolverV1 mutantSolver;

	@BeforeClass
	public static void instanciateMutantSolver() {
		mutantSolver = new MutantSolverV1();
	}
	
	/**
	 * Test the algorithm with the Meli mutant example
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isMutantExample() throws InvalidDnaException {
		String dna[] = TestConstants.MUTANT_MELI_EXAMPLE;
		assertTrue(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with the Meli not mutant example
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isNotMutantExample() throws InvalidDnaException {
		String dna[] = TestConstants.NOT_MUTANT_MELI_EXAMPLE;
		assertFalse(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with only one horizontal sequence of equal character This
	 * is not a mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isNotMutantOneSequenceHorizontal() throws InvalidDnaException {
		String dna[] = TestConstants.NOT_MUTANT_ONE_SEQUENCE_HORIZONTAL;
		assertFalse(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with only one vertical sequence of equal character This is
	 * not a mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isNotMutantOneSequenceVertical() throws InvalidDnaException {
		String dna[] = TestConstants.NOT_MUTANT_ONE_SEQUENCE_VERTICAL;
		assertFalse(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with only one diagonal sequence of equal character This is
	 * not a mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isNotMutantOneSequenceDiagonal() throws InvalidDnaException {
		String dna[] = TestConstants.NOT_MUTANT_ONE_SEQUENCE_DIAGONAL;
		assertFalse(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with only one inverted diagonal sequence of equal
	 * character This is not a mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isNotMutantOneSequenceInvertedDiagonal() throws InvalidDnaException {
		String dna[] = TestConstants.NOT_MUTANT_ONE_SEQUENCE_INVERTED_DIAGONAL;
		assertFalse(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with two horizontal sequence of equal character This is a
	 * mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isMutantOnlyHorizontal() throws InvalidDnaException {
		String dna[] = TestConstants.MUTANT_ONLY_HORIZONTAL;
		assertTrue(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with two vertical sequence of equal character This is a
	 * mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isMutantOnlyVertical() throws InvalidDnaException {
		String dna[] = TestConstants.MUTANT_ONLY_VERTICAL;
		assertTrue(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with two diagonal sequence of equal character This is a
	 * mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isMutantOnlyDiagonal() throws InvalidDnaException {
		String dna[] = TestConstants.MUTANT_ONLY_DIAGONAL;
		assertTrue(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with two inverted diagonal sequence of equal character
	 * upper than the secondary diagonal This is a mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isMutantOnlyUpperInvertedDiagonal() throws InvalidDnaException {
		String dna[] = TestConstants.MUTANT_ONLY_UPPER_INVERTED_DIAGONAL;
		assertTrue(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with two lower sequence of equal character lower than the
	 * secondary diagonal This is a mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isMutantOnlyLowerInvertedDiagonal() throws InvalidDnaException {
		String dna[] = TestConstants.MUTANT_ONLY_LOWER_INVERTED_DIAGONAL;
		assertTrue(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with one sequence with five equal character
	 * This is not a mutant in this version
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isNotMutantWithOnlyOneSequenceOfFiveSameCharacters() throws InvalidDnaException {
		String dna[] = TestConstants.ONLY_ONE_SEQUENCE_OF_FIVE_EQUAL_CHARACTERS;
		assertFalse(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with two sequence with three equal character
	 * This is not a mutant
	 * 
	 * @throws InvalidDnaException
	 */
	@Test
	public void isNotMutantWithTwoSequenceOfThreeSameCharacters() throws InvalidDnaException {
		String dna[] = TestConstants.NOT_MUTANT_WITH_TWO_SEQUENCE_OF_THREE_EQUAL_CARACTER;
		assertFalse(mutantSolver.isMutant(dna));
	}

	/**
	 * Test the algorithm with an invalid sequence
	 * This throws an Exception
	 * 
	 * @throws InvalidDnaException
	 */
	@Test(expected = InvalidDnaException.class)
	public void isInvalidDna() throws InvalidDnaException {
		String dna[] = TestConstants.EMPTY_DNA;
		mutantSolver.isMutant(dna);
	}


}

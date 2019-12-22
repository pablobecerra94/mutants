package com.mutants.strategy;

import com.mutants.exception.InvalidDnaException;

/**
 * First version. If there is a string of 5 equal characters, it is taken as a
 * single sequence of 4 characters (characters 1 to 4)
 * 
 * @author Pablo
 *
 */
public class MutantSolverV1 implements MutantSolver {

	private static final String THE_DNA_MUST_NOT_BE_EMPTY = "The DNA must not be empty";
	private static final String ALL_DNA_ARRAYS_MUST_HAVE_THE_SAME_LENGTH = "All dna arrays must have the same length";
	private static final int MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT = 2;
	private static final int SECUENCE_AMOUNT = 3;

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
			throw new InvalidDnaException(THE_DNA_MUST_NOT_BE_EMPTY);
		}

		char[][] finalDna = buildArray(dna);

		int repeatedAmount = analyzeHorizontally(finalDna);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeVertically(finalDna);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeUpperPrimaryDiagonal(finalDna);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeLowerPrimaryDiagonal(finalDna);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeUpperSecondaryDiagonal(finalDna);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeLowerSecondaryDiagonal(finalDna);

		return repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT;
	}

	/**
	 * Analyze the diagonals below the main diagonal in descending order to detect
	 * strings of 4 equal characters
	 * 
	 * @param finalDna
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeLowerPrimaryDiagonal(char[][] finalDna) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = 0; i < finalDna.length - SECUENCE_AMOUNT; i++) {
			charCount = 0;
			for (int j = 0; j < finalDna.length - i - 1; j++) {
				if (finalDna[i + j][j] == finalDna[i + j + 1][j + 1]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == SECUENCE_AMOUNT) {
					repeatedAmount++;
					charCount = 0;
				}
			}

		}
		return repeatedAmount;
	}

	/**
	 * Analyze the diagonals above the main diagonal in descending order to detect
	 * strings of 4 equal characters
	 * 
	 * @param finalDna
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeUpperPrimaryDiagonal(char[][] finalDna) {
		int repeatedAmount = 0;
		int charCount;
		for (int j = 1; j < finalDna.length - SECUENCE_AMOUNT; j++) {
			charCount = 0;
			for (int i = 0; i < finalDna.length - j - 1; i++) {
				if (finalDna[i][i + j] == finalDna[i + 1][i + j + 1]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == SECUENCE_AMOUNT) {
					repeatedAmount++;
					charCount = 0;
				}
			}

		}
		return repeatedAmount;
	}

	/**
	 * Analyze the diagonals above the secondary diagonal in ascending order to
	 * detect strings of 4 equal characters
	 * 
	 * @param finalDna
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeUpperSecondaryDiagonal(char[][] finalDna) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = SECUENCE_AMOUNT; i < finalDna.length; i++) {
			charCount = 0;
			for (int j = 0; j < i; j++) {
				if (finalDna[i - j][j] == finalDna[i - j][j + 1]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == SECUENCE_AMOUNT) {
					repeatedAmount++;
					repeatedAmount = 0;
				}
			}

		}
		return repeatedAmount;
	}

	/**
	 * Analyze the diagonals below the secondary diagonal in ascending order to
	 * detect strings of 4 equal characters
	 * 
	 * @param finalDna
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeLowerSecondaryDiagonal(char[][] finalDna) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = 0; i < finalDna.length - SECUENCE_AMOUNT; i++) {
			charCount = 0;
			for (int j = 0; j < finalDna.length - i - 2; j++) {
				if (finalDna[finalDna.length - j - 1][j + i + 1] == finalDna[finalDna.length - j - 1][j + i + 2]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == SECUENCE_AMOUNT) {
					repeatedAmount++;
					repeatedAmount = 0;
				}
			}
		}
		return repeatedAmount;
	}

	/**
	 * Analyze each column to detect strings of 4 equal characters
	 * 
	 * @param finalDna
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeVertically(char[][] finalDna) {
		int repeatedAmount = 0;
		for (int j = 0; j < finalDna.length; j++) {
			int charCount = 0;
			for (int i = 0; i < finalDna.length - 1; i++) {
				if (finalDna[i][j] == finalDna[i + 1][j]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == SECUENCE_AMOUNT) {
					repeatedAmount++;
					charCount = 0;
				}
			}
		}
		return repeatedAmount;
	}

	/**
	 * Analyze each row to detect strings of 4 equal characters
	 * 
	 * @param finalDna
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeHorizontally(char[][] finalDna) {
		int repeatedAmount = 0;

		for (int i = 0; i < finalDna.length; i++) {
			int charCount = 0;
			for (int j = 0; j < finalDna.length - 1; j++) {
				if (finalDna[i][j] == finalDna[i][j + 1]) {
					charCount++;
				} else {
					charCount = 0;
				}

				if (charCount == SECUENCE_AMOUNT) {
					repeatedAmount++;
					charCount = 0;
				}
			}
		}
		return repeatedAmount;
	}

	/**
	 * @param dna
	 * @param length
	 * @return
	 * @throws InvalidDnaException
	 */
	private static char[][] buildArray(String[] dna) throws InvalidDnaException {
		char[][] finalDna = new char[dna.length][dna.length];

		for (int i = 0; i < dna.length; i++) {
			if (dna[i].length() != dna.length) {
				throw new InvalidDnaException(ALL_DNA_ARRAYS_MUST_HAVE_THE_SAME_LENGTH);
			}

			finalDna[i] = dna[i].toCharArray();

		}
		return finalDna;
	}

}

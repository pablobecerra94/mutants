package com.mutants.services;

import org.springframework.stereotype.Service;

import com.mutants.exception.InvalidDnaException;

/**
 * Service that contains the logic to detect mutants
 * @author Pablo
 *
 */
@Service
public class MutantService {

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
	public Boolean isMutant(String[] dna) throws InvalidDnaException {
		if (dna == null || dna.length == 0) {
			throw new InvalidDnaException(THE_DNA_MUST_NOT_BE_EMPTY);
		}

		char[][] finalDNA = buildArray(dna);

		int repeatedAmount = analyzeHorizontally(finalDNA);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeVertically(finalDNA);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeUpperPrimaryDiagonal(finalDNA);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeLowerPrimaryDiagonal(finalDNA);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeUpperSecondaryDiagonal(finalDNA);

		if (repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT) {
			return true;
		}

		repeatedAmount += analyzeLowerSecondaryDiagonal(finalDNA);

		return repeatedAmount >= MINIMUN_CHAR_SEQUENCE_TO_BE_MUTANT;
	}

	/**
	 * Analyze the diagonals below the main diagonal in descending order to detect
	 * strings of 4 equal characters
	 * 
	 * @param finalDNA
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeLowerPrimaryDiagonal(char[][] finalDNA) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = 0; i < finalDNA.length - SECUENCE_AMOUNT; i++) {
			charCount = 0;
			for (int j = 0; j < finalDNA.length - i - 1; j++) {
				if (finalDNA[i + j][j] == finalDNA[i + j + 1][j + 1]) {
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
	 * @param finalDNA
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeUpperPrimaryDiagonal(char[][] finalDNA) {
		int repeatedAmount = 0;
		int charCount;
		for (int j = 1; j < finalDNA.length - SECUENCE_AMOUNT; j++) {
			charCount = 0;
			for (int i = 0; i < finalDNA.length - j - 1; i++) {
				if (finalDNA[i][i + j] == finalDNA[i + 1][i + j + 1]) {
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
	 * @param finalDNA
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeUpperSecondaryDiagonal(char[][] finalDNA) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = SECUENCE_AMOUNT; i < finalDNA.length; i++) {
			charCount = 0;
			for (int j = 0; j < i; j++) {
				if (finalDNA[i - j][j] == finalDNA[i - j][j + 1]) {
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
	 * @param finalDNA
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeLowerSecondaryDiagonal(char[][] finalDNA) {
		int repeatedAmount = 0;
		int charCount;
		for (int i = 0; i < finalDNA.length - SECUENCE_AMOUNT; i++) {
			charCount = 0;
			for (int j = 0; j < finalDNA.length - i - 2; j++) {
				if (finalDNA[finalDNA.length - j - 1][j + i + 1] == finalDNA[finalDNA.length - j - 1][j + i + 2]) {
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
	 * @param finalDNA
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeVertically(char[][] finalDNA) {
		int repeatedAmount = 0;
		for (int j = 0; j < finalDNA.length; j++) {
			int charCount = 0;
			for (int i = 0; i < finalDNA.length - 1; i++) {
				if (finalDNA[i][j] == finalDNA[i + 1][j]) {
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
	 * @param finalDNA
	 * @return the number of equal character strings detected in the diagonals
	 */
	private static int analyzeHorizontally(char[][] finalDNA) {
		int repeatedAmount = 0;

		for (int i = 0; i < finalDNA.length; i++) {
			int charCount = 0;
			for (int j = 0; j < finalDNA.length - 1; j++) {
				if (finalDNA[i][j] == finalDNA[i][j + 1]) {
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
		char[][] finalDNA = new char[dna.length][dna.length];

		for (int i = 0; i < dna.length; i++) {
			if (dna[i].length() != dna.length) {
				throw new InvalidDnaException(ALL_DNA_ARRAYS_MUST_HAVE_THE_SAME_LENGTH);
			}

			finalDNA[i] = dna[i].toCharArray();

		}
		return finalDNA;
	}

}

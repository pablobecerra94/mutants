package com.mutants.utils;

import com.mutants.constants.Constants;
import com.mutants.exception.InvalidDnaException;

/**
 * Class with String array methods
 * 
 * @author Pablo
 *
 */
public class StringArrayUtils {

	/**
	 * Transform String array to a char array The string array must be nxn
	 * 
	 * @param dna
	 * @param length
	 * @return
	 * @throws InvalidDnaException
	 */
	public static char[][] transform1DStringArrayTo2DCharArray(String[] dna) throws InvalidDnaException {
		char[][] finalDna = new char[dna.length][dna.length];

		for (int i = 0; i < dna.length; i++) {
			if (dna[i].length() != dna.length) {
				throw new InvalidDnaException(Constants.ALL_DNA_ARRAYS_MUST_HAVE_THE_SAME_LENGTH);
			}

			finalDna[i] = dna[i].toCharArray();

		}
		return finalDna;
	}

	/**
	 * Transform String array to a single String
	 * 
	 * @param dna
	 * @param length
	 * @return
	 * @throws InvalidDnaException
	 */
	public static String transformStringArrayToSingleString(String[] dna) {

		StringBuilder stringBuilder = new StringBuilder();

		for (String dnaString : dna) {
			stringBuilder.append(dnaString);
		}

		return stringBuilder.toString();
	}

}

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
	 * @param array
	 * @param length
	 * @return
	 * @throws InvalidDnaException
	 */
	public static char[][] transform1DStringArrayTo2DCharArray(String[] array) throws InvalidDnaException {
		char[][] finalDna = new char[array.length][array.length];

		for (int i = 0; i < array.length; i++) {
			if (array[i].length() != array.length) {
				throw new InvalidDnaException(Constants.ALL_DNA_ARRAYS_MUST_HAVE_THE_SAME_LENGTH);
			}

			finalDna[i] = array[i].toCharArray();

		}
		return finalDna;
	}

	/**
	 * Transform String array to a single String
	 * 
	 * @param array
	 * @param length
	 * @return
	 * @throws InvalidDnaException
	 */
	public static String transformStringArrayToSingleString(String[] array) {

		StringBuilder stringBuilder = new StringBuilder();

		for (String arrayString : array) {
			stringBuilder.append(arrayString);
		}

		return stringBuilder.toString();
	}

}

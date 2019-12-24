package com.mutants;

public class TestConstants {

	public static final String[] MUTANT_MELI_EXAMPLE = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
	public static final String[] NOT_MUTANT_MELI_EXAMPLE = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
	public static final String[] NOT_MUTANT_ONE_SEQUENCE_HORIZONTAL = { "AAAA", "TATA", "CGAG", "CAGG" };
	public static final String[] MUTANT_ONLY_HORIZONTAL = { "AAAA", "AAAA", "CGAG", "CAGG" };
	public static final String[] MUTANT_ONLY_VERTICAL = { "AATC", "AACG", "AAGT", "AATC" };
	public static final String[] MUTANT_ONLY_DIAGONAL = { "AACTG", "GAACT", "CGAAG", "TCTAA", "TCAGT" };
	public static final String[] MUTANT_ONLY_UPPER_INVERTED_DIAGONAL = { "ACTATT", "CGATGC", "AATTTA", "ATCGGG", "GTCACT", "GCTATC" };
	public static final String[] MUTANT_ONLY_LOWER_INVERTED_DIAGONAL = { "GATAC", "AAACC", "TGCCA", "GCCCT", "GCGTG" };
	public static final String[] ONLY_ONE_SEQUENCE_OF_FIVE_EQUAL_CHARACTERS = { "AAAAA", "TATCT", "TGGCG", "GTTGT", "ACTGT" };
	public static final String[] NOT_MUTANT_WITH_TWO_SEQUENCE_OF_THREE_EQUAL_CARACTER = { "AAAC", "TTTA", "TGGC", "GTTG" };
	public static final String[] EMPTY_DNA = {};
}

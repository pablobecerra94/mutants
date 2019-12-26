package com.mutants;

public class TestConstants {

	public static final String[] MUTANT_MELI_EXAMPLE = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
	public static final String[] NOT_MUTANT_MELI_EXAMPLE = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
	public static final String[] NOT_MUTANT_ONE_SEQUENCE_HORIZONTAL = { "AAAA", "TATA", "CGAG", "CAGG" };
	public static final String[] NOT_MUTANT_ONE_SEQUENCE_VERTICAL = { "AGAC", "AATA", "AGAG", "AAGG" };
	public static final String[] NOT_MUTANT_ONE_SEQUENCE_DIAGONAL = { "AGAC", "TATA", "AGAG", "AAGA" };
	public static final String[] NOT_MUTANT_ONE_SEQUENCE_INVERTED_DIAGONAL = { "CGTA", "TGAT", "GAAG", "TAGA" };;
	public static final String[] MUTANT_ONLY_HORIZONTAL = { "AAAA", "AAAA", "CGAG", "CAGG" };
	public static final String[] MUTANT_ONLY_VERTICAL = { "AATC", "AACG", "AAGT", "AATC" };
	public static final String[] MUTANT_ONLY_DIAGONAL = { "AACTG", "GAACT", "CGAAG", "TCTAA", "TCAGT" };
	public static final String[] MUTANT_ONLY_UPPER_INVERTED_DIAGONAL = { "ACTATT", "CGATGC", "AATTTA", "ATCGGG", "GTCACT", "GCTATC" };
	public static final String[] MUTANT_ONLY_LOWER_INVERTED_DIAGONAL = { "GATAC", "AAACC", "TGCCA", "GCCCT", "GCGTG" };
	public static final String[] ONLY_ONE_SEQUENCE_OF_FIVE_EQUAL_CHARACTERS = { "AAAAA", "TATCT", "TGGCG", "GTTGT", "ACTGT" };
	public static final String[] NOT_MUTANT_WITH_TWO_SEQUENCE_OF_THREE_EQUAL_CARACTER = { "AAAC", "TTTA", "TGGC", "GTTG" };
	public static final String[] EMPTY_DNA = {};
	public static final String DNA_PARAM_NAME = "dna";
	public static final String IS_MUTANT_URL_V1 = "/api/v1/mutants";
	public static final String IS_MUTANT_URL_V2 = "/api/v2/mutants";
	public static final String ROOT_URL = "http://localhost:";
	public static final String APPLICATION_JSON = "application/json";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String DELETE_BD_URL = "/api/delete";
	public static final String STATS_URL = "/api/stats";
}

package com.mutants.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mutants.serializer.DoubleSerializer;

/**
 * Stats Wrapper This class represents the stats of mutant analysis.
 * 
 * @author Pablo
 *
 */
public class Stats {

	private long countMutantsDna;


	private long countHumanDna;


	private double ratio;

	public Stats(long countMutantsDna, long countHumanDna) {
		this.countMutantsDna = countMutantsDna;
		this.countHumanDna = countHumanDna;
		this.ratio = countHumanDna != 0 ? ((double) countMutantsDna) / countHumanDna : 0;
	}

	@JsonProperty("count_mutant_dna")
	public long getCountMutantsDna() {
		return countMutantsDna;
	}

	public void setCountMutantsDna(long countMutantsDna) {
		this.countMutantsDna = countMutantsDna;
	}

	@JsonProperty("count_human_dna")
	public long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	@JsonProperty("ratio")
	@JsonSerialize(using = DoubleSerializer.class)
	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}

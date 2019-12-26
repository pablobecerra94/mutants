package com.mutants.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mutants.serializer.DoubleSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Stats Wrapper This class represents the stats of mutant analysis.
 * 
 * @author Pablo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stats {

	@JsonProperty("count_human_dna")
	private long countMutantsDna;


	@JsonProperty("count_mutant_dna")
	private long countHumanDna;

	@JsonProperty("ratio")
	@JsonSerialize(using = DoubleSerializer.class)
	private double ratio;

	public Stats(long countMutantsDna, long countHumanDna) {
		this.countMutantsDna = countMutantsDna;
		this.countHumanDna = countHumanDna;
		this.ratio = countHumanDna != 0 ? ((double) countMutantsDna) / countHumanDna : 0;
	}



}

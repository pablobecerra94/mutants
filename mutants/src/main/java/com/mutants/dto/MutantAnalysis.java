package com.mutants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mutant Analysis DTO Entity that is written to the database
 * 
 * @author Pablo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutantAnalysis {

	private String[] dna;

	private boolean isMutant;



}

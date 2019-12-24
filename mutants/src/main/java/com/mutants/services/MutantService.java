package com.mutants.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.dto.MutantAnalysis;
import com.mutants.dto.Stats;
import com.mutants.enumerator.MutantVersion;
import com.mutants.exception.InvalidDnaException;
import com.mutants.repository.MutantRepository;
import com.mutants.strategy.MutantSolver;

/**
 * Service that contains the logic to detect mutants
 * @author Pablo
 *
 */
@Service
public class MutantService {

	@Autowired
	MutantRepository mutantRepository;

	/**
	 * Solve the mutant algorithm, a human is mutant if there is more than one
	 * sequence of 4 equal characters horizontally, vertically or obliquely
	 * 
	 * @param dna
	 * @param version
	 * @return
	 * @throws InvalidDnaException
	 */
	public boolean isMutant(String[] dna, MutantVersion version) throws InvalidDnaException {
		MutantSolver mutantSolver = version.getMutantSolver();

		boolean result = mutantSolver.isMutant(dna);

		MutantAnalysis analysis = new MutantAnalysis();
		analysis.setDna(dna);
		analysis.setMutant(result);

		mutantRepository.save(analysis);

		return result;
	}

	public MutantAnalysis get(long id) {
		MutantAnalysis result = mutantRepository.findById(id);
		System.out.println(result);
		return result;
	}

	public Stats getStats() {
		long mutants = mutantRepository.countIsMutant();
		long total = mutantRepository.count();
		Stats stats = new Stats(mutants, total);
		return stats;
	}

	public void deleteAll() {
		mutantRepository.deleteAll();
	}
}

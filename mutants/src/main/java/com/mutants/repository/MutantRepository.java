package com.mutants.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mutants.dto.MutantAnalysis;

/**
 * It is responsible for accessing the database of mutant analyzes
 * 
 * @author Pablo
 *
 */
public interface MutantRepository extends MongoRepository<MutantAnalysis, Long> {
	public MutantAnalysis findById(long id);

	@Query(value = "{'isMutant': true}", count = true)
	public Long countIsMutant();

}

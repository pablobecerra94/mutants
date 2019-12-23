package com.mutants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.dto.Dna;
import com.mutants.enumerator.MutantVersion;
import com.mutants.exception.InvalidDnaException;
import com.mutants.services.MutantService;


/**
 * Controller responsible for all mutant requests
 * @author Pablo
 *
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class MutantController {

	@Autowired
	private MutantService mutantService;

	/**
	 * 
	 * @param data
	 * @return 
	 * 200 when the human is mutant
	 * 403 when the human is not mutant
	 * 404 when the dna is invalid
	 * 
	 */
	@PostMapping("/v1/mutants")
	public ResponseEntity<Object> isMutantV1(@RequestBody Dna data) {
		try {
			return new ResponseEntity<>(mutantService.isMutant(data.getDna(), MutantVersion.V1) ? HttpStatus.OK : HttpStatus.FORBIDDEN);
		} catch (InvalidDnaException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/v2/mutants")
	public ResponseEntity<Object> isMutantV2(@RequestBody Dna data) {
		try {
			return new ResponseEntity<>(mutantService.isMutant(data.getDna(), MutantVersion.V2) ? HttpStatus.OK : HttpStatus.FORBIDDEN);
		} catch (InvalidDnaException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}

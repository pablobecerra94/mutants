package com.mutants.api;

import static org.junit.Assert.assertEquals;

import org.assertj.core.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutants.MutantsApplication;
import com.mutants.TestConstants;

/**
 * Test the endpoints
 * 
 * @author Pablo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MutantsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MutantApiTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port = 8080;

	/**
	 * Test the v1 endpoint with the Meli not mutant example
	 * 
	 * @throws JSONException
	 */
	@Test
	public void isNotMutantApiV1Test() throws JSONException {
		JSONObject request = new JSONObject();
		HttpHeaders headers = new HttpHeaders();
		headers.add(TestConstants.CONTENT_TYPE, TestConstants.APPLICATION_JSON);
		request.put(TestConstants.DNA_PARAM_NAME, new JSONArray(Arrays.asList(TestConstants.NOT_MUTANT_MELI_EXAMPLE)));
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(TestConstants.ROOT_URL + port + TestConstants.IS_MUTANT_URL_V1, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
	}

	/**
	 * Test the v1 endpoint with the Meli mutant example
	 * 
	 * @throws JSONException
	 */
	@Test
	public void isMutantApiV1Test() throws JSONException {
		JSONObject request = new JSONObject();
		HttpHeaders headers = new HttpHeaders();
		headers.add(TestConstants.CONTENT_TYPE, TestConstants.APPLICATION_JSON);
		request.put(TestConstants.DNA_PARAM_NAME, new JSONArray(Arrays.asList(TestConstants.MUTANT_MELI_EXAMPLE)));
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(TestConstants.ROOT_URL + port + TestConstants.IS_MUTANT_URL_V1, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	/**
	 * Test the v2 endpoint with the Meli not mutant example
	 * 
	 * @throws JSONException
	 */
	@Test
	public void isNotMutantApiV2Test() throws JSONException {
		JSONObject request = new JSONObject();
		HttpHeaders headers = new HttpHeaders();
		headers.add(TestConstants.CONTENT_TYPE, TestConstants.APPLICATION_JSON);
		request.put(TestConstants.DNA_PARAM_NAME, new JSONArray(Arrays.asList(TestConstants.NOT_MUTANT_MELI_EXAMPLE)));
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(TestConstants.ROOT_URL + port + TestConstants.IS_MUTANT_URL_V2, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
	}

	/**
	 * Test the v2 endpoint with the Meli mutant example
	 * 
	 * @throws JSONException
	 */
	@Test
	public void isMutantApiV2Test() throws JSONException {
		JSONObject request = new JSONObject();
		HttpHeaders headers = new HttpHeaders();
		headers.add(TestConstants.CONTENT_TYPE, TestConstants.APPLICATION_JSON);
		request.put(TestConstants.DNA_PARAM_NAME, new JSONArray(Arrays.asList(TestConstants.MUTANT_MELI_EXAMPLE)));
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(TestConstants.ROOT_URL + port + TestConstants.IS_MUTANT_URL_V2, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	/**
	 * Test the v1 endpoint with an invalid dna
	 * 
	 * @throws JSONException
	 */
	@Test
	public void isDnaInvalidV1Test() throws JSONException {
		JSONObject request = new JSONObject();
		HttpHeaders headers = new HttpHeaders();
		headers.add(TestConstants.CONTENT_TYPE, TestConstants.APPLICATION_JSON);
		request.put(TestConstants.DNA_PARAM_NAME, new JSONArray(Arrays.asList(TestConstants.EMPTY_DNA)));
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(TestConstants.ROOT_URL + port + TestConstants.IS_MUTANT_URL_V1, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	/**
	 * Test the v2 endpoint with an invalid dna
	 * 
	 * @throws JSONException
	 */
	@Test
	public void isDnaInvalidV2Test() throws JSONException {
		JSONObject request = new JSONObject();
		HttpHeaders headers = new HttpHeaders();
		headers.add(TestConstants.CONTENT_TYPE, TestConstants.APPLICATION_JSON);
		request.put(TestConstants.DNA_PARAM_NAME, new JSONArray(Arrays.asList(TestConstants.EMPTY_DNA)));
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(TestConstants.ROOT_URL + port + TestConstants.IS_MUTANT_URL_V2, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}


}

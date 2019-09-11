package com.rockpaperscissor.game;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RockPaperScissorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RockPaperScissorApplicationIT {
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testPostPlayGame() {

		HttpEntity<String> entity = new HttpEntity<String>("ROCK", headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:" + port +"/api/v1/game",
				HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testGetGameOptions() {
		
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:" + port +"/api/v1/game",
				HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		String expected;
		if(response.getBody().contains("SCISSOR")) {			
			expected = "{\"pc\":\"SCISSOR\",\"player\":\"ROCK\",\"winner\":\"you\"}";
		} else if (response.getBody().contains("PAPER")) {
			expected = "{\"pc\":\"PAPER\",\"player\":\"ROCK\",\"winner\":\"the computer\"}";			
		} else {
			expected = "{\"pc\":\"ROCK\",\"player\":\"ROCK\",\"winner\":\"noone\"}";
		}
		assertEquals(expected, response.getBody());
	}
	
	@Test
	public void testInternalServerErrorException() {
		HttpEntity<String> entity = new HttpEntity<String>("ROCKX", headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:" + port +"/api/v1/game",
				HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
	@Test
	public void testNotFoundException() {
		HttpEntity<String> entity = new HttpEntity<String>("ROCK", headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:" + port +"/api/v1/game/x",
				HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}

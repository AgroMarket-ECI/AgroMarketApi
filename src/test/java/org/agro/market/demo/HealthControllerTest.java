package org.agro.market.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class HealthControllerTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage()
            throws Exception
    {
        assertThat(
                this.restTemplate.getForObject( "http://localhost:" + port + "/v1/health", String.class ) ).contains(
                "API Working OK!" );
    }

    @Test
    public void shouldOnPublicServiceWithAuthenticationReturn200HttpStatus() throws Exception {
        ResponseEntity<String> result = this.restTemplate.withBasicAuth("marcos.chia@mail.escuelaing.edu.co", "La_prueb4")
                .getForEntity("/v1/health", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}

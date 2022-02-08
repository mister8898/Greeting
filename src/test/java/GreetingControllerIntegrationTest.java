package com.realdolmen.devops.greeting;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void whenCallingGreetingRestEndpoint_returnHello() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("hello");
    }
}
package com.example.Sesiones456.controllers;

import com.example.Sesiones456.entities.LapTop;
import com.example.Sesiones456.repositories.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LapTopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port );
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    void findAll() {

        ResponseEntity<LapTop[]> response =
                testRestTemplate.getForEntity("/api/laptops", LapTop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<LapTop> laptops = Arrays.asList(response.getBody());
        System.out.println("Tenemos estos ordenadores: "+laptops.size());


    }

    @Test
    void findOneById() {
        ResponseEntity<LapTop> response =
                testRestTemplate.getForEntity("/api/laptops/1", LapTop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "id": null,
                    "fabricante": "Lenovo test",
                    "modelo": "Legion",
                    "price": 395.5,
                    "screenSize": 18.3
                }   
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<LapTop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, LapTop.class);

        LapTop result = response.getBody();

       // assertEquals(1L, result.getId());
        assertEquals("Lenovo test", result.getFabricante());
    }

    @Test
    void update() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "id": null,
                    "fabricante": "Lenovo test actualizado",
                    "modelo": "Legion",
                    "price": 395.5,
                    "screenSize": 18.3
                }   
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<LapTop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, LapTop.class);

        //LapTop result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void delete() {

    }

    @Test
    void deletebyId() {
    }
}
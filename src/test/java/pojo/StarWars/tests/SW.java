package pojo.StarWars.tests;

import HttpClient.HttpClientUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.junit.Test;
import pojo.StarWars.*;

import java.io.IOException;

public class SW {
    @Test
    public void getPlanetNames() throws IOException {

        HttpResponse response = HttpClientUtils.getGetResponse("https://swapi.dev/api/planets?page=1");

        ObjectMapper objectMapper = new ObjectMapper();
        PlanetsPojo allPlanets = objectMapper.readValue(response.getEntity().getContent(), PlanetsPojo.class);

        for (DecsPlanet planets : allPlanets.getResults()) {
            System.out.println(planets.getName());
        }
    }

    @Test
    public void getStarshipNames() throws IOException {

        HttpResponse response = HttpClientUtils.getGetResponse("https://swapi.dev/api/starships/?page=1");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // "MGLT" field is all uppercase keys and is unrecognized by POJO
        StarshipsPojo allStarships = objectMapper.readValue(response.getEntity().getContent(), StarshipsPojo.class); // deserialization (like in getGetResponseBody method)

        for (DescStarship starships : allStarships.getResults()) {
            System.out.println(starships.getName());
        }
    }

    @Test
    public void getPeopleNames() throws IOException {

        HttpResponse response = HttpClientUtils.getGetResponse("https://swapi.dev/api/people/?page=1");

        ObjectMapper objectMapper = new ObjectMapper();
        PeoplePojo allPeople = objectMapper.readValue(response.getEntity().getContent(), PeoplePojo.class); // deserialization (like in getGetResponseBody method)

        for (DescPeople people : allPeople.getResults()) {
            System.out.println(people.getName());
        }
    }
}


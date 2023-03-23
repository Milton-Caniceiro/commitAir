package academy.mindswap.commitAir.service;


import academy.mindswap.commitAir.dto.AirLabsResponseCitiesDto;
import academy.mindswap.commitAir.model.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{

    @Override
    public List<Flight> getAllFlights() {
        return null;
    }

    @Override
    public Flight getFlightById(String flightCode) {

        String uri = "https://airlabs.co/api/v9/flight?flight_iata=" + flightCode + "&api_key=51458100-5a17-4b86-a9f4-1388f74b5454";

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        /*
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode response = root.path("response");
       List<CityDto> cities =  objectMapper.readValue(root.toString(), new TypeReference<List<CityDto>>() {});

         */
        ResponseEntity<Flight> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, Flight.class);
        if(responseEntity.getStatusCode().isError()){
            throw new Error();
        }


        return responseEntity.getBody();
    }
}

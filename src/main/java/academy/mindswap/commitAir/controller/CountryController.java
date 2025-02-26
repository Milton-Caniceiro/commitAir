package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.CountryDto;
import academy.mindswap.commitAir.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("")
    public ResponseEntity<List<CountryDto>> getAllCountries() throws JsonProcessingException {
        List<CountryDto> countryDtos = this.countryService.getCountries();
        return new ResponseEntity<>(countryDtos, HttpStatus.OK);
    }
}

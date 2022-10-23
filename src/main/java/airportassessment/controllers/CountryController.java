package airportassessment.controllers;

import airportassessment.dto.TopAirportsResults;
import airportassessment.models.Country;
import airportassessment.services.CountryService;
import airportassessment.services.impl.CountryServiceImpl;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Api(value = "CountryController")
@SwaggerDefinition(tags = {@Tag(name = "CountryController", description = "Operation related to Airport details")})
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryServiceImpl service) {
        this.countryService = service;
    }

    @ApiOperation(value = "Fetch Country with Airports details based on the country code or name", response = Country.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "not Found"), @ApiResponse(code = 400, message = "bad Request"), @ApiResponse(code = 200, message = "Success", response = Country.class)})
    @GetMapping("/fetchAirports/{countryCode}")
    public Country country(@PathVariable String countryCode) {
        Country searchResult = countryService.fetchAirportsDetails(countryCode);
        return searchResult;
    }

    @ApiOperation(value = "Fetch List of Top Airports details based on the start offset and end limit", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "not Found") ,@ApiResponse(code = 400, message = "bad Request"), @ApiResponse(code = 200, message = "Success", response = List.class)})
    @GetMapping("/topAirportsList/{offset}/{limit}")
    public List<TopAirportsResults> fetchTopAirportsList(@PathVariable int offset, @PathVariable int limit) {
        log.info("Inside fetchTopAirportsList with LIMIT :{}, offset :{}", limit, offset);
        return countryService.fetchTopAirportsList(offset, limit);
    }

    @ApiOperation(value = "Fetch List of Country details based on the fuzzyValue", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "not Found"), @ApiResponse(code = 400, message = "bad Request"), @ApiResponse(code = 200, message = "Success", response = List.class)})
    @GetMapping("/fetchResults/{fuzzyValue}")
    public List<Country> fetchResultsWithPartialData(@PathVariable String fuzzyValue) {
        log.info("Inside fetchResultsWithPartialData with fuzzyValue :{}", fuzzyValue);
        return countryService.fetchResultsWithPartialData(fuzzyValue);
    }
}
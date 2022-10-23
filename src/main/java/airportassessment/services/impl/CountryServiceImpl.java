package airportassessment.services.impl;

import airportassessment.dto.TopAirportsResults;
import airportassessment.exception.NoDataFoundException;
import airportassessment.models.Country;
import airportassessment.repositories.CountryRepository;
import airportassessment.services.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country fetchAirportsDetails(String countryCode) {
        log.info("Inside fetchAirportsDetails method with country code:{}", countryCode);
        Optional<Country> optCountry = Optional.empty();
        if (countryCode.length() == 2) {
            optCountry = countryRepository.findByCode(countryCode.toUpperCase());
        } else optCountry = countryRepository.findByName(countryCode);
        Country country = optCountry.orElseThrow(() -> new NoDataFoundException("No Data found for the given country code", HttpStatus.NOT_FOUND));
        log.info("database call success:{}", country.getAirports().size());
        return country;
    }

    @Override
    public List<TopAirportsResults> fetchTopAirportsList(int offset, int limit) {
        log.info("Inside fetchTopAirportsList");
        Page<TopAirportsResults> airportsResults = countryRepository.queryTopAirports(PageRequest.of(offset, limit));
        if (airportsResults.getContent().isEmpty())
            throw new NoDataFoundException("No Data found while retrieving the countries with top Airport list", HttpStatus.NOT_FOUND);
        log.info("Database call to fetch Top countries with highest number of Airports success");
        return airportsResults.getContent();
    }

    @Override
    public List<Country> fetchResultsWithPartialData(String fuzzyValue) {
        List<Country> findByCode = countryRepository.findByCodeStartsWithIgnoreCase(fuzzyValue);
        List<Country> findByName = null;
        if (CollectionUtils.isEmpty(findByCode)) {
            findByName = countryRepository.findByNameStartsWithIgnoreCase(fuzzyValue);
        }
        if (CollectionUtils.isEmpty(findByCode) && CollectionUtils.isEmpty(findByName))
            throw new NoDataFoundException("No Data found while retrieving the details with fuzzy value", HttpStatus.NOT_FOUND);

        return (!CollectionUtils.isEmpty(findByCode) ? findByCode : findByName);
    }
}
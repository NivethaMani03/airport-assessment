package airportassessment.services;

import airportassessment.dto.TopAirportsResults;
import airportassessment.models.Country;

import java.util.List;

public interface CountryService {
    /**
     * THis method will interact with Repository to fetch the airport details based on the country name
     *
     * @param countryCode @{@link String}
     * @return
     */
    Country fetchAirportsDetails(String countryCode);

    /**
     * This method will interact with repository to fetch the country with top Airports list based on the given limit
     *
     * @param limit @{@link Integer}
     * @return @{@link List}
     */
    List<TopAirportsResults> fetchTopAirportsList(int offset,int limit);

    /**
     * This method will query the results based on the Fuzzy value as country code or name
     * @param fuzzyValue {@link String}
     * @return
     */
    List<Country> fetchResultsWithPartialData(String fuzzyValue);
}

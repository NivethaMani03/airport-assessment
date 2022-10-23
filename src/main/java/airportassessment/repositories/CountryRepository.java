package airportassessment.repositories;

import airportassessment.dto.TopAirportsResults;
import airportassessment.models.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByCode(String code);

    Optional<Country> findByName(String name);

    List<Country> findByCodeStartsWithIgnoreCase(String code);

    List<Country> findByNameStartsWithIgnoreCase(String name);

    @Query(value = "SELECT new airportassessment.dto.TopAirportsResults(c.name as name, count(*) as result)" +
            " FROM Country c INNER JOIN Airport a ON c.code = a.iso_country " +
            "GROUP BY c.name ORDER BY result DESC")
    Page<TopAirportsResults> queryTopAirports(PageRequest limit);

}
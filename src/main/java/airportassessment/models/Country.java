package airportassessment.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRIES")
@Data
@NoArgsConstructor
@ToString
public class Country implements java.io.Serializable {

    @Id
    private Long id;

    @NaturalId
    private String code;
    private String name;
    private String continent;
    private String wikipedia_link;
    private String keywords;

    @OneToMany(targetEntity = Airport.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "iso_country", referencedColumnName = "code")
    private List<Airport> airports;

    public Country(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Country(Long id, String code, String name, String continent, String wikipedia_link, String keywords) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.wikipedia_link = wikipedia_link;
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
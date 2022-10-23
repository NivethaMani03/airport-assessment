package airportassessment.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AIRPORTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    private Integer id;
    private String ident;
    private String type;
    private String name;
    private Double latitude_deg;
    private Double longitude_deg;
    private Integer elevation_ft;
    private String continent;
    private String iso_country;
    private String iso_region;
    private String municipality;
    private String scheduled_service;
    private String gps_code;
    private String iata_code;
    private String local_code;
    private String home_link;
    private String wikipedia_link;
    private String keywords;
  }
package airportassessment.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RUNWAYS")
@Data
@NoArgsConstructor
public class Runways {

    @Id
    @Column(name = "ID",nullable = false,unique = true)
    private Integer id;
    @Column(name = "AIRPORT_REF")
    private Integer airport_ref;
    @Column(name = "AIRPORT_IDENT")
    private String airport_ident;
    @Column(name = "LENGTH_FT")
    private Integer length_ft;
    @Column(name = "WIDTH_FT")
    private Integer width_ft;
    @Column(name = "SURFACE")
    private String surface;
    @Column(name = "LIGHTED")
    private Boolean lighted;
    @Column(name = "CLOSED")
    private Boolean closed;
    @Column(name = "LE_IDENT")
    private String le_ident;
    @Column(name = "LE_LATITUDE_DEG")
    private Double le_latitude_deg;
    @Column(name = "LE_LONGITUDE_DEG")
    private Double le_longitude_deg;
    @Column(name = "LE_ELEVATION_FT")
    private Integer le_elevation_ft;
    @Column(name = "LE_HEADING_DEGT")
    private Double le_heading_degT;
    @Column(name = "LE_DISPLACED_THRESHOLD_FT")
    private Integer le_displaced_threshold_ft;
    @Column(name = "HE_IDENT")
    private String he_ident;
    @Column(name = "HE_LATITUDE_DEG")
    private Double he_latitude_deg;
    @Column(name = "HE_LONGITUDE_DEG")
    private Double he_longitude_deg;
    @Column(name = "HE_ELEVATION_FT")
    private Integer he_elevation_ft;
    @Column(name = "HE_HEADING_DEGT")
    private Double he_heading_degT;
    @Column(name = "HE_DISPLACED_THRESHOLD_FT")
    private Integer he_displaced_threshold_ft;
}
package com.estadiovirtual.core.catalog.domain;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String city;
    // Capacidad nominal total (puede ser un estimado o la suma de sectores)
    @Column(nullable = false)
    private Integer capacity;
    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Sector> sectors = new ArrayList<>();

    public Stadium() {
    }

    public Stadium(String name, String city, Integer capacity) {
        this.name = name;
        this.city = city;
        this.capacity = capacity;
    }

    public void addSector(Sector sector) {
        sectors.add(sector);
        sector.setStadium(this);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public List<Sector> getSectors() { return sectors; }
    public void setSectors(List<Sector> sectors) { this.sectors = sectors; }
}
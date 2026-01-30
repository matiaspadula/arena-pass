package com.estadiovirtual.core.catalog.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer rowNumber;
    @Column(nullable = false)
    private Integer seatNumber;
    @Version
    private Long version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    public Seat() {
    }

    public Seat(Integer rowNumber, Integer seatNumber, Sector sector) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.sector = sector;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getRowNumber() { return rowNumber; }
    public void setRowNumber(Integer rowNumber) { this.rowNumber = rowNumber; }
    public Integer getSeatNumber() { return seatNumber; }
    public void setSeatNumber(Integer seatNumber) { this.seatNumber = seatNumber; }
    public Long getVersion() { return version; } // Solo getter, la versión la maneja Hibernate
    public Sector getSector() { return sector; }
    public void setSector(Sector sector) { this.sector = sector; }
}
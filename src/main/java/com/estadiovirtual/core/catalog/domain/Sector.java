package com.estadiovirtual.core.catalog.domain;
import com.estadiovirtual.core.catalog.domain.Seat;
import com.estadiovirtual.core.catalog.domain.Stadium;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sectors")
public class Sector {
    public enum SectorType {
        NUMBERED, // Platea (usa la lista de asientos)
        GENERAL   // Popular/Campo (usa capacidad numérica)
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING) // Guarda el texto "NUMBERED" o "GENERAL" en la BD
    @Column(nullable = false)
    private SectorType type;
    private Integer capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id", nullable = false)
    private Stadium stadium;
    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();

    public Sector() {
    }

    public Sector(String name, SectorType type, Integer capacity, Stadium stadium) {
        this.name = name;
        this.type = type;
        this.stadium = stadium;
        this.capacity = (type == SectorType.GENERAL) ? capacity : 0;
    }

    public Integer getRealCapacity() {
        if (this.type == SectorType.NUMBERED) {
            return seats.size();
        }
        return capacity;
    }

    public void addSeat(Seat seat) {
        if (this.type == SectorType.GENERAL) {
            throw new IllegalStateException("Error: No se pueden agregar butacas individuales a un sector GENERAL (Campo).");
        }
        seats.add(seat);
        seat.setSector(this);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public SectorType getType() { return type; }
    public void setType(SectorType type) { this.type = type; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Stadium getStadium() { return stadium; }
    public void setStadium(Stadium stadium) { this.stadium = stadium; }
    public List<Seat> getSeats() { return seats; }
    public void setSeats(List<Seat> seats) { this.seats = seats; }
}
package com.estadiovirtual.core.catalog.infraestructure;
import com.estadiovirtual.core.catalog.domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {}

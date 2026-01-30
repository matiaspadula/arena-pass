package com.estadiovirtual.core.catalog.infraestructure;
import com.estadiovirtual.core.catalog.domain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {}
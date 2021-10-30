package com.ironhack.animals.repositories;

import com.ironhack.animals.dao.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findByAvailability(Boolean availability);
    List<Animal> findByAvailabilityAndType(Boolean availability, String type);
    List<Animal> findByAvailabilityAndAgeBetween(Boolean availability, Long start, Long end);
    List<Animal> findByAvailabilityAndTypeAndAgeBetween(Boolean availability, String type, Long start, Long end);
}

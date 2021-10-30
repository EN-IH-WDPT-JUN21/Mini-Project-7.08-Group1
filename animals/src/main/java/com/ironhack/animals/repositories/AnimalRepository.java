package com.ironhack.animals.repositories;

import com.ironhack.animals.dao.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findByAvailable(Boolean availability);
    List<Animal> findByAvailableAndType(Boolean availability, String type);
    List<Animal> findByAvailableAndAgeBetween(Boolean availability, Long start, Long end);
    List<Animal> findByAvailableAndTypeAndAgeBetween(Boolean availability, String type, Long start, Long end);
}

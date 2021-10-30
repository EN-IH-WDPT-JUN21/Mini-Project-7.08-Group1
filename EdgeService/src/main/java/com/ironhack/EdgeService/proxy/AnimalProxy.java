package com.ironhack.EdgeService.proxy;

import com.ironhack.EdgeService.DTO.AnimalDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("animal-service")
@Qualifier("animal")
public interface AnimalProxy {


    @GetMapping("/animals")
    public List<AnimalDTO> getAvailableAnimals(
            @RequestParam Optional<String> type,
            @RequestParam Optional<Long> ageFrom,
            @RequestParam Optional<Long> AgeTo);


    @PatchMapping("/animal/adopt/{id}")
    AnimalDTO adoptAnimal(@PathVariable(name = "id") Long id);

}

package com.ironhack.EdgeService.proxy;

import com.ironhack.EdgeService.DTO.AnimalDTO;
import com.ironhack.EdgeService.DTO.AnimalStatusDTO;
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
            @RequestParam String type,
            @RequestParam Long ageFrom,
            @RequestParam Long ageTo);


    @PutMapping("/animals/update")
    public AnimalDTO adoptAnimal(@RequestBody AnimalStatusDTO animalStatusDTO);

}

package com.ironhack.animals.controllers;

import com.ironhack.animals.dto.AnimalDTO;
import com.ironhack.animals.dao.Animal;
import com.ironhack.animals.dto.AnimalStatusDTO;
import com.ironhack.animals.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public List<Animal> getAvailableAnimals(
            @RequestParam Optional<String> type,
            @RequestParam Optional<Long> ageFrom,
            @RequestParam Optional<Long> ageTo)
    {
        return animalService.getAnimals(type,ageFrom,ageTo);
    }

    @PatchMapping("/animals/update")
    public Animal updateAnimalStatus(@RequestBody AnimalStatusDTO animalStatusDTO){
        return animalService.updateAnimalStatus(animalStatusDTO);
    }
    @PostMapping("/animal")
    public Animal postAnimal(@RequestBody AnimalDTO animalDTO){
        return animalService.postAnimal(animalDTO);
    }

}

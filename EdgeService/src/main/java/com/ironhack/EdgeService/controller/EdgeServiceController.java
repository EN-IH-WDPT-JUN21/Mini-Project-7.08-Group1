package com.ironhack.EdgeService.controller;

import com.ironhack.EdgeService.DTO.AdopterDTO;
import com.ironhack.EdgeService.DTO.AnimalDTO;
import com.ironhack.EdgeService.service.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EdgeServiceController {

    @Autowired
    @Qualifier("service-edge")
    EdgeService edgeService;

    @GetMapping("/animals")
    private List<AnimalDTO> getAvailableAnimals(
            @RequestParam Optional<String> type,
            @RequestParam Optional<Long> ageFrom,
            @RequestParam Optional<Long> ageTo){
        return edgeService.getAvailableAnimals(type, ageFrom, ageTo);
    }

    @PostMapping("/animals")
    private AdopterDTO adopt(@RequestBody AdopterDTO adopter){
        return edgeService.adopt(adopter);
    }

}

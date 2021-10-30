package com.ironhack.adopterservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

    @Autowired
    AdopterRepository adopterRepository;

    @Autowired
    IAdopterService adopterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Adopter> findAll() {
        return adopterRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Adopter findById(@PathVariable String id) {
        return adopterRepository.findById(Long.valueOf(id)).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Adopter create(@RequestBody @Valid AdopterDTO adopterDTO) {
        return adopterService.store(adopterDTO);
    }

}

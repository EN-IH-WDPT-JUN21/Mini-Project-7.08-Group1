package com.ironhack.adopterservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AdopterService implements IAdopterService {

    @Autowired
    public AdopterRepository adopterRepository;

    public Adopter store(AdopterDTO adopterDTO) {
        Optional<Adopter> adopter = adopterRepository.findByName(adopterDTO.getName());
        if(adopter.isEmpty()) {
            Adopter newAdopter = new Adopter(adopterDTO.getName(), adopterDTO.getPetId());
            return adopterRepository.save(newAdopter);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The adopter already exists in the system.");
        }
    }

}

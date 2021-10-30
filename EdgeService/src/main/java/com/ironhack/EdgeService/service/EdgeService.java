package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.DTO.AdopterDTO;
import com.ironhack.EdgeService.DTO.AnimalDTO;
import com.ironhack.EdgeService.DTO.AnimalStatusDTO;
import com.ironhack.EdgeService.proxy.AdopterProxy;
import com.ironhack.EdgeService.proxy.AnimalProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("service-edge")
public class EdgeService {

    @Autowired
    @Qualifier("adopter")
    private AdopterProxy adopterProxy;

    @Autowired
    @Qualifier("animal")
    private AnimalProxy animalProxy;

    public AdopterDTO adopt(AdopterDTO adopter){
        AnimalStatusDTO animalStatusDTO=new AnimalStatusDTO(adopter.getPetId(), false);
        animalProxy.adoptAnimal(animalStatusDTO);
        return adopterProxy.adoptAnimal(adopter);
    }

    public List<AnimalDTO> getAvailableAnimals(Optional<String> type, Optional<Long> ageFrom, Optional<Long> ageTo){
            return getAvailableAnimals(type, ageFrom, ageTo);
    }


}

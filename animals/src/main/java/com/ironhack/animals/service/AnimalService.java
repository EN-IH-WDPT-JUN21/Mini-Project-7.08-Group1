package com.ironhack.animals.service;

import com.ironhack.animals.dao.Animal;
import com.ironhack.animals.dto.AnimalStatusDTO;
import com.ironhack.animals.enums.AnimalType;
import com.ironhack.animals.repositories.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals(Optional<String> type, Optional<Long> ageFrom, Optional<Long> ageTo){

        //Validation
        try {
            type.ifPresent(AnimalType::valueOf);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Bad animal type format");
        }
        if (
                (ageFrom.isPresent() && ageTo.isEmpty())
                    ||
                (ageFrom.isEmpty() && ageTo.isPresent())
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Missing one age parameter");
        }



        if (type.isPresent() && ageFrom.isPresent() && ageTo.isPresent()){
            return animalRepository.findByAvailableAndTypeAndAgeBetween(true,type.get(), ageFrom.get(), ageTo.get());
        } else if(type.isPresent()){
            return animalRepository.findByAvailableAndType(true,type.get());
        } else if (ageFrom.isPresent()){
            //age is present, type is not
            return animalRepository.findByAvailableAndAgeBetween(true,ageFrom.get(), ageTo.get());
        } else {
            //get all without filters
            return animalRepository.findByAvailable(true);
        }


    }

    public Animal updateAnimalStatus(AnimalStatusDTO animalStatusDTO){
        Long animalId = animalStatusDTO.getId();
        Optional<Animal> animal = animalRepository.findById(animalId);
        if (animal.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Animals with this ID not found");
        }else {
            animal.get().setAvailable(animalStatusDTO.getAvailable());
            return animalRepository.save(animal.get());
        }
    }
    public Animal postAnimal(AnimalStatusDTO.AnimalDTO animalDTO){
        return animalRepository.save(new Animal(
               animalDTO.getName(),
               AnimalType.valueOf(animalDTO.getType()),
               animalDTO.getAge(),
               true
        ));
    }

}

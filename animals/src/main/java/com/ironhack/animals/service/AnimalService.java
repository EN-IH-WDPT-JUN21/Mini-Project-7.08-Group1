package com.ironhack.animals.service;

import com.ironhack.animals.dao.Animal;
import com.ironhack.animals.dto.AnimalDTO;
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

    public List<Animal> getAnimals(String type, Long ageFrom, Long ageTo){

        if (
                (ageFrom !=null && ageTo==null)
                    ||
                (ageFrom==null && ageTo!=null)
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Missing one age parameter");
        }



        if (type!=null && ageFrom != null && ageTo != null){
            return animalRepository.findByAvailableAndTypeAndAgeBetween(true,type, ageFrom, ageTo);
        } else if(type!=null){
            return animalRepository.findByAvailableAndType(true,type);
        } else if (ageFrom!=null){
            //age is present, type is not
            return animalRepository.findByAvailableAndAgeBetween(true,ageFrom, ageTo);
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
    public Animal postAnimal(AnimalDTO animalDTO){
        return animalRepository.save(new Animal(
               animalDTO.getName(),
               animalDTO.getType(),
               animalDTO.getAge(),
               true
        ));
    }

}

package com.ironhack.EdgeService.proxy;

import com.ironhack.EdgeService.DTO.AdopterDTO;
import com.ironhack.EdgeService.DTO.AnimalDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("adopter-service")
@Qualifier("adopter")
public interface AdopterProxy {

    @GetMapping("/adopter/{id}")
    AdopterDTO getAdopterDTO(@PathVariable Long id);

    @PostMapping("/adopter")
    AdopterDTO adoptAnimal(@RequestBody AdopterDTO adopter);


}

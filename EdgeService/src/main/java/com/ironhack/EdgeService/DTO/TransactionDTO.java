package com.ironhack.EdgeService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Long id;
    private String name;
    private String type;
    private int age;
    private boolean available;
    private List<AnimalDTO> animalList;




}
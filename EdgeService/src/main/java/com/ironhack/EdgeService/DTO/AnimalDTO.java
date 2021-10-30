package com.ironhack.EdgeService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {
    private Long id;
    private String name;
    private String type;
    private int age;
    private boolean available;

}

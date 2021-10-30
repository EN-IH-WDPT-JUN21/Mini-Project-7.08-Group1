package com.ironhack.adopterservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdopterDTO {
    @NotEmpty(message = "Name cannot be empty or null.")
    private String name;

    @NotEmpty(message = "The pet ID cannot be empty or null.")
    private Long petId;

}

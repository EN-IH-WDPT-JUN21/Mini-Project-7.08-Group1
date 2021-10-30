package com.ironhack.adopterservice;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdopterDTO {
    @NotBlank(message = "Name cannot be empty or null.")
    private String name;

    @NotNull
    private Long petId;

}

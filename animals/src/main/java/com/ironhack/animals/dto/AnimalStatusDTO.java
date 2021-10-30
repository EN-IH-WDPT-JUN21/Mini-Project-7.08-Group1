package com.ironhack.animals.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalStatusDTO {
    private Long id;
    private Boolean available;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AnimalDTO {
        private String name;
        private String type;
        private Long age;
    }
}

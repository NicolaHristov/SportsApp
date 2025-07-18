package com.nikola.sportsapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AthleticsDto {

    private String discipline;
    private String worldChampion;
    private String worldRecord;

}

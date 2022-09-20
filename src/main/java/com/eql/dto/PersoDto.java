package com.eql.dto;

import com.eql.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersoDto {

    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;

    private User user;

}
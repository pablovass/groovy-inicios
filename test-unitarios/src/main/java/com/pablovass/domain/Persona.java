package com.pablovass.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private Long id;
    private String nombre;
    private int edad;

public  int sumar(int n){
    return n;
}


}

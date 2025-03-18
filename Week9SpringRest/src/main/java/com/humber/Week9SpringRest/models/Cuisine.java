package com.humber.Week9SpringRest.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//cuisine is a part of dish that is why we use @Embeddable
@Embeddable
public class Cuisine {

    private String CuisineName;
    private String country;

}

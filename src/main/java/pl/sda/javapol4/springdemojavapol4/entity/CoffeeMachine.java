package pl.sda.javapol4.springdemojavapol4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeMachine {

    private Long id;
    private int capacityInMl;
    private String typeOfCoffee;
    private String vendor;
    private boolean milky;

// kotlin
//     val name: String; -> final String name /get;
//    var name: String: -> String name get/set;


}

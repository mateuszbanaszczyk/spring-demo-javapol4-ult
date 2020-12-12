package pl.sda.javapol4.springdemojavapol4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COFFEE_MACHINES")
public class CoffeeMachine {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("capacity_in_ml")
//    capacity_in_ml C++
    @Column(name="CAPACITY")
    private int capacityInMl;
    @JsonProperty("type_of_coffee")
    private String typeOfCoffee;

    private String vendor;
    private boolean milky;

    @JsonIgnore
    private String numerSeryjny;


// kotlin
//     val name: String; -> final String name /get;
//    var name: String: -> String name get/set;


}

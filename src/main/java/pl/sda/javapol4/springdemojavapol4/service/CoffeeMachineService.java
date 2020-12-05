package pl.sda.javapol4.springdemojavapol4.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.javapol4.springdemojavapol4.entity.CoffeeMachine;
import pl.sda.javapol4.springdemojavapol4.repository.CoffeeMachineRepository;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;

    public CoffeeMachineService(CoffeeMachineRepository coffeeMachineRepository) {
        this.coffeeMachineRepository = coffeeMachineRepository;
    }

    public CoffeeMachine findCoffeeMachneById(Long id){

       var result = giveMeMyCoffeeMachines().stream()
                .filter(coffeeMachine -> coffeeMachine.getId() == id)
                .findFirst()
                .orElse(null);
                log.info("found coffee machine with id: [{}] = [{}]", id, result);
       return result;
    }
    public List<CoffeeMachine> giveMeMyCoffeeMachines(){
        var coffeeMachines = coffeeMachineRepository.myFavouriteCoffeeMachines();

        log.info("coffee machines: {}", coffeeMachines);

        return  coffeeMachines;
    }
    public CoffeeMachine saveCoffeeMachine(CoffeeMachine objectToSave) {
        log.info("saving coffee machine");
        Random random = new Random();
//        TODO: save in real db
        objectToSave.setId(random.nextLong());
        return objectToSave;

    }
}

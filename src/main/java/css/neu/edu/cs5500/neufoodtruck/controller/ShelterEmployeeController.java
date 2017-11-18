package css.neu.edu.cs5500.neufoodtruck.controller;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import css.neu.edu.cs5500.neufoodtruck.service.ShelterEmployeeService;
import java.util.List;

@RestController
@RequestMapping("/shelterEmployee")
public class ShelterEmployeeController {

    @Autowired
    private ShelterEmployeeService shelterEmployeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Yes, hello from shelter";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createShelter")
    public ResponseEntity<String> buildShelter(@RequestBody Shelter shelter) {
        try {
            int result = shelterEmployeeService.createShelter(shelter);
            String msg = String.format("Create shelter with id: %d", result);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findById/{shelterId}")
    public Shelter findShelterById(@PathVariable int shelterId) {
        return shelterEmployeeService.findShelterById(shelterId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allShelters")
    public List<Shelter> findAllShelters() {
        return shelterEmployeeService.findAllShelters();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/checkShelterCapacity/{shelterId}")
    public int checkShelterCapacityById(@PathVariable int shelterId) {
        return shelterEmployeeService.checkShelterCapacityById(shelterId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/checkShelterAvailability/{shelterId}")
    public int checkShelterAvailabilityById(@PathVariable int shelterId) {
        return shelterEmployeeService.checkShelterAvailabilityById(shelterId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findShelterById/{shelterId}")
    public List<AnimalRecord> findAnimalByShelterId(@PathVariable int shelterId) {
        return shelterEmployeeService.findAnimalByShelterId(shelterId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/put/{animalId}")
    public ResponseEntity<String> putAnimalIntoShelter(@PathVariable int animalId, @RequestBody int shelterId) {
        try {
            int result = shelterEmployeeService.putAnimalIntoShelter(animalId, shelterId);
            String msg = String.format("put animal " + animalId + " into shelter " + shelterId, result);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
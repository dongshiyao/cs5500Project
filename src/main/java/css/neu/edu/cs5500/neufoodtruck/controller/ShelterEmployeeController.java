package css.neu.edu.cs5500.neufoodtruck.controller;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.LocationHistory;
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

    @RequestMapping(method = RequestMethod.GET, value = "/findAllAnimal")
    public List<AnimalRecord> findAllAnimals() {
        return shelterEmployeeService.findAllAnimals();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateCategory/{category}/{animalId}")
    public int updateAnimalCategory(@PathVariable String category, @PathVariable int animalId) {
        return shelterEmployeeService.updateAnimalCategory(category, animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateBreed/{breed}/{animalId}")
    public int updateAnimalBreed(@PathVariable String breed, @PathVariable int animalId) {
        return shelterEmployeeService.updateAnimalBreed(breed, animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateWeight/{weight}/{animalId}")
    public int updateAnimalWeight(@PathVariable int weight, @PathVariable int animalId) {
        return shelterEmployeeService.updateAnimalWeight(weight, animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateGender/{gender}/{animalId}")
    public int updateAnimalGender(@PathVariable String gender, @PathVariable int animalId) {
        return shelterEmployeeService.updateAnimalGender(gender, animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateColor/{color}/{animalId}")
    public int updateAnimalColor(@PathVariable String color, @PathVariable int animalId) {
        return shelterEmployeeService.updateAnimalColor(color, animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateShelterCapacity/{capacity}/{shelterId}")
    public int updateShelterCapacity(@PathVariable int capacity, @PathVariable int shelterId) {
        return shelterEmployeeService.updateShelterCapacity(capacity, shelterId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeAllAnimalInShelter/{shelterId}")
    public List<AnimalRecord> removeAnimalsInShelter (@PathVariable int shelterId) {
        return shelterEmployeeService.removeAllAnimalInShelter(shelterId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateShelterLocation/{longitude}/{latitude}/{shelterId}")
    public int updateShelterLocation(@PathVariable double longitude, @PathVariable double latitude, @PathVariable int shelterId) {
        return shelterEmployeeService.updateShelterLocation(longitude, latitude, shelterId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/moveAnimal/{animalId}/{shelterId}")
    public int transferAnimalToOtherShelter(@PathVariable int animalId, @PathVariable int shelterId) {
        return shelterEmployeeService.moveAnimalToShelter(animalId, shelterId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trackAnimal/{animalId}")
    public List<LocationHistory> trackAnimal(@PathVariable int animalId) {
        return shelterEmployeeService.trackAnimal(animalId);
    }
}
package css.neu.edu.cs5500.neufoodtruck.controller;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.LocationHistory;
import css.neu.edu.cs5500.neufoodtruck.model.Shelter;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import css.neu.edu.cs5500.neufoodtruck.service.ShelterEmployeeService;
import java.util.List;

@RestController
@Api(value = "ShelterEmployeeController", description = "REST APIs related to Shelter Employee.")
@RequestMapping("/shelterEmployee")
public class ShelterEmployeeController {

    @Autowired
    private ShelterEmployeeService shelterEmployeeService;

    @ApiOperation(value = "Test for ShelterEmployeeController.", response = Iterable.class, tags = "HelloWorld")
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Yes, hello from shelter";
    }

    @ApiOperation(value = "Create a new shelter.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
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



    @ApiOperation(value = "Show all shelters.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/allShelters")
    public List<Shelter> findAllShelters() {
        return shelterEmployeeService.findAllShelters();
    }

    @ApiOperation(value = "Check the specific shelter's capacity.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/checkShelterCapacity/{shelterId}")
    public int checkShelterCapacityById(@PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.checkShelterCapacityById(shelterId);
    }

    @ApiOperation(value = "Check the specific shelter's availability.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/checkShelterAvailability/{shelterId}")
    public int checkShelterAvailabilityById(@PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.checkShelterAvailabilityById(shelterId);
    }

    @ApiOperation(value = "Show all animals in specific shelter(search with shelterId).")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findAnimalByShelterId/{shelterId}")
    public List<AnimalRecord> findAnimalByShelterId(@PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.findAnimalByShelterId(shelterId);
    }

    @ApiOperation(value = "Find the shelter with shelter Id.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findShelterById/{shelterId}")
    public Shelter findShelterById(@PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.findShelterById(shelterId);
    }

    @ApiOperation(value = "Add an animal into the shelter.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/put/{animalId}/{shelterId}")
    public ResponseEntity<String> putAnimalIntoShelter(@PathVariable @ApiParam(value = "eg: 28", required = true)int animalId,
                                                       @PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        try {
            int result = shelterEmployeeService.putAnimalIntoShelter(animalId, shelterId);
            String msg = String.format("put animal " + animalId + " into shelter " + shelterId, result);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ApiOperation(value = "Show all animals.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findAllAnimal")
    public List<AnimalRecord> findAllAnimals() {
        return shelterEmployeeService.findAllAnimals();
    }

    @ApiOperation(value = "Update the category for specific animal.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateCategory/{category}/{animalId}")
    public int updateAnimalCategory(@PathVariable @ApiParam(value = "eg: Cat", required = true)String category,
                                    @PathVariable @ApiParam(value = "eg: 28", required = true)int animalId) {
        return shelterEmployeeService.updateAnimalCategory(category, animalId);
    }

    @ApiOperation(value = "Update the breed for specific animal.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateBreed/{breed}/{animalId}")
    public int updateAnimalBreed(@PathVariable @ApiParam(value = "eg: breed2", required = true)String breed,
                                 @PathVariable @ApiParam(value = "eg: 28", required = true)int animalId) {
        return shelterEmployeeService.updateAnimalBreed(breed, animalId);
    }

    @ApiOperation(value = "Update the weight for specific animal.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateWeight/{weight}/{animalId}")
    public int updateAnimalWeight(@PathVariable @ApiParam(value = "eg: 20", required = true)int weight,
                                  @PathVariable @ApiParam(value = "eg: 28", required = true)int animalId) {
        return shelterEmployeeService.updateAnimalWeight(weight, animalId);
    }

    @ApiOperation(value = "Update the gender for specific animal.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateGender/{gender}/{animalId}")
    public int updateAnimalGender(@PathVariable @ApiParam(value = "eg: Male", required = true)String gender,
                                  @PathVariable @ApiParam(value = "eg: 28", required = true)int animalId) {
        return shelterEmployeeService.updateAnimalGender(gender, animalId);
    }

    @ApiOperation(value = "Update the color for specific animal.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateColor/{color}/{animalId}")
    public int updateAnimalColor(@PathVariable @ApiParam(value = "eg: white", required = true)String color,
                                 @PathVariable @ApiParam(value = "eg: 28", required = true)int animalId) {
        return shelterEmployeeService.updateAnimalColor(color, animalId);
    }

    @ApiOperation(value = "Update the capacity for specific shelter.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateShelterCapacity/{capacity}/{shelterId}")
    public int updateShelterCapacity(@PathVariable @ApiParam(value = "eg: 50", required = true)int capacity,
                                     @PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.updateShelterCapacity(capacity, shelterId);
    }

    @ApiOperation(value = "Remove all animals in specific shelter.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.DELETE, value = "/removeAllAnimalInShelter/{shelterId}")
    public List<AnimalRecord> removeAnimalsInShelter (@PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.removeAllAnimalInShelter(shelterId);
    }

    @ApiOperation(value = "Update the location for specific shelter.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateShelterLocation/{longitude}/{latitude}/{shelterId}")
    public int updateShelterLocation(@PathVariable @ApiParam(value = "eg: 40.3", required = true)double longitude,
                                     @PathVariable @ApiParam(value = "eg: 50.3", required = true)double latitude,
                                     @PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.updateShelterLocation(longitude, latitude, shelterId);
    }

    @ApiOperation(value = "Update the shelter for specific animal.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/moveAnimal/{animalId}/{shelterId}")
    public int transferAnimalToOtherShelter(@PathVariable @ApiParam(value = "eg: 28", required = true)int animalId,
                                            @PathVariable @ApiParam(value = "eg: 31", required = true)int shelterId) {
        return shelterEmployeeService.moveAnimalToShelter(animalId, shelterId);
    }

    @ApiOperation(value = "Track the specific animal(show location history).")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/trackAnimal/{animalId}")
    public List<LocationHistory> trackAnimal(@PathVariable @ApiParam(value = "eg: 28", required = true)int animalId) {
        return shelterEmployeeService.trackAnimal(animalId);
    }
}
package css.neu.edu.cs5500.neufoodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.CoordinateRecord;
import css.neu.edu.cs5500.neufoodtruck.service.VolunteerService;


@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Yes, hello from volunteer";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createRecord")
    public ResponseEntity<String> reportLostAnimal(@RequestBody AnimalRecord animalRecord) {
        try {
            int result = volunteerService.createAnimalRecord(animalRecord);
            String msg = String.format("Create animal record with id: %d", result);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findById/{animalId}")
    public AnimalRecord findAnimalById(@PathVariable int animalId) {
        return volunteerService.findAnimalById(animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateLocation/{animalId}")
    public ResponseEntity<String> updateLocation(@PathVariable int animalId,
                                  @RequestBody CoordinateRecord coordinateRecord) {
        try {
            int result = volunteerService.updateAnimalLocation(animalId, coordinateRecord);
            String msg = String.format("Update animal record with id: %d", result);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{animalId}")
    public ResponseEntity<String> deleteAnimalById(@PathVariable int animalId) {
        try {
            int result = volunteerService.deleteAnimalById(animalId);
            String msg = String.format("Deleted animal record with id: %d", result);
            return ResponseEntity.ok(msg);
        } catch (EmptyResultDataAccessException e) {
            String msg = String.format("ID %d does not exist", animalId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateStatus/{animalId}")
    public ResponseEntity<String> updateStatus(@PathVariable int animalId, @RequestBody String status) {
        return ResponseEntity.ok(volunteerService.updateAnimalStatus(animalId, status));
    }
}

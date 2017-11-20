package css.neu.edu.cs5500.neufoodtruck.controller;

import io.swagger.annotations.*;
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
@Api(value = "VolunteerController", description = "REST APIs related to volunteer.")
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @ApiOperation(value = "Test for VolunteerContorller.", response = Iterable.class, tags = "HelloWorld")
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Yes, hello from volunteer";
    }

    @ApiOperation(value = "Create the animal record to database when the volunteer fina a poor animal.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/createRecord")
    public ResponseEntity<String> reportLostAnimal(@RequestBody @ApiParam(value = "The timeStamp has the format like: \"updateTime\": \"2017-11-14T09:50:18.772+0000\"", required = true)AnimalRecord animalRecord) {
        try {
            int result = volunteerService.createAnimalRecord(animalRecord);
            String msg = String.format("Create animal record with id: %d", result);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ApiOperation(value = "Find the animal record from database with specific animal ID.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findById/{animalId}")
    public AnimalRecord findAnimalById(@PathVariable @ApiParam(value = "eg: 28", required = true)int animalId) {
        return volunteerService.findAnimalById(animalId);
    }

    @ApiOperation(value = "Update the animal location with specific animal ID.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateLocation/{animalId}")
    public ResponseEntity<String> updateLocation(@PathVariable @ApiParam(value = "eg: 28", required = true) int animalId,
                                                 @RequestBody @ApiParam(value = "The timeStamp has the format like: \"updateTime\": \"2017-11-14T09:50:18.772+0000\"", required = true)CoordinateRecord coordinateRecord) {
        try {
            int result = volunteerService.updateAnimalLocation(animalId, coordinateRecord);
            String msg = String.format("Update animal record with id: %d", result);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ApiOperation(value = "Delete the animal record from database with specific animal ID.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{animalId}")
    public ResponseEntity<String> deleteAnimalById(@PathVariable @ApiParam(value = "eg: 28", required = true) int animalId) {
        try {
            int result = volunteerService.deleteAnimalById(animalId);
            String msg = String.format("Deleted animal record with id: %d", result);
            return ResponseEntity.ok(msg);
        } catch (EmptyResultDataAccessException e) {
            String msg = String.format("ID %d does not exist", animalId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @ApiOperation(value = "Update the animal statue with specific animal ID.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/updateStatus/{animalId}")
    public ResponseEntity<String> updateStatus(@PathVariable @ApiParam(value = "eg: 28", required = true) int animalId, @RequestBody @ApiParam(value = "eg: In shelter1") String status) {
        return ResponseEntity.ok(volunteerService.updateAnimalStatus(animalId, status));
    }
}

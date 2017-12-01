package css.neu.edu.cs5500.neufoodtruck.controller;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import css.neu.edu.cs5500.neufoodtruck.service.PetOwnerService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@Api(value = "PetOwnerController", description = "REST APIs related to Pet Owner.")
@RequestMapping("/petOwner")
public class PetOwnerController {

    @Autowired
    private PetOwnerService petOwnerService;

    @ApiOperation(value = "Test for PetOwnerContorller.", response = Iterable.class, tags = "HelloWorld")
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Yes, hello from owner";
    }

    @ApiOperation(value = "Find the animal records with the specific category information.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findByCategory/{category}")
    public List<AnimalRecord> findAnimalById(@PathVariable @ApiParam(value = "eg: Cat", required = true) String category) {
        return petOwnerService.findAnimalByCategory(category);
    }

    @ApiOperation(value = "Find the animal records with the specific category and breed information.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findByCategoryAndBreed/{category}/{breed}")
    public List<AnimalRecord> findAnimalByCategoryAndBreed(@PathVariable @ApiParam(value = "eg: Cat", required = true) String category, @PathVariable @ApiParam(value = "eg: breed1", required = true) String breed) {
        return petOwnerService.findAnimalByCategoryAndBreed(category, breed);
    }

    @ApiOperation(value = "Find the animal records with the specific category and color information.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findByCategoryAndColor/{category}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndColor(@PathVariable @ApiParam(value = "eg: Cat", required = true) String category,
                                                           @PathVariable@ApiParam(value = "eg: black", required = true)  String color) {
        return petOwnerService.findAnimalByCategoryAndColor(category, color);
    }

    @ApiOperation(value = "Find the animal records with the specific category, breed and color information.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findByCategoryAndBreedAndColor/{category}/{breed}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColor(@PathVariable @ApiParam(value = "eg: Cat", required = true) String category,
                                                                   @PathVariable @ApiParam(value = "eg: breed1", required = true) String breed,
                                                                   @PathVariable @ApiParam(value = "eg: black", required = true) String color) {
        return petOwnerService.findAnimalByCategoryAndBreedAndColor(category, breed, color);
    }

    @ApiOperation(value = "Find the specific category animal records which found after than lost time.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAfterLostTime/{category}")
    public List<AnimalRecord> findAnimalByCategoryAfterLostTime(@PathVariable @ApiParam(value = "eg: Cat", required = true) String category,
                                                                @RequestBody @ApiParam(value = "eg: 1512118972040", required = true) long lostTime ) {
        return petOwnerService.findAnimalByCategoryAfterLostTime(category, new Timestamp(lostTime));
    }

    @ApiOperation(value = "Find the specific category & breed animal records which found after than lost time.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAndBreedAfterLostTime/{category}/{breed}")
    public List<AnimalRecord> findAnimalByCategoryAndBreedAfterLostTime(@PathVariable @ApiParam(value = "eg: Cat", required = true)String category,
                                                                        @PathVariable @ApiParam(value = "eg: breed1", required = true)String breed,
                                                                        @RequestBody @ApiParam(value = "eg: 1512118972040", required = true) long lostTime) {
        return petOwnerService.findAnimalByCategoryAndBreedAfterLostTime(category, breed, new Timestamp(lostTime));
    }

    @ApiOperation(value = "Find the specific category & color animal records which found after than lost time.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAndColorAfterLostTime/{category}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndColorAfterLostTime(@PathVariable @ApiParam(value = "eg: Cat", required = true) String category,
                                                                        @PathVariable @ApiParam(value = "eg: black", required = true)String color,
                                                                        @RequestBody @ApiParam(value = "eg: 1512118972040", required = true) long lostTime) {
        return petOwnerService.findAnimalByCategoryAndColorAfterLostTime(category, color, new Timestamp(lostTime));
    }

    @ApiOperation(value = "Find the specific category & breed & color animal records which found after than lost time.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAndBreedAndColorAndFoundTimeAfter/{category}/{breed}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColorAfterLostTime(@PathVariable @ApiParam(value = "eg: Cat", required = true) String category,
                                                                                @PathVariable @ApiParam(value = "eg: breed1", required = true) String breed,
                                                                                @PathVariable @ApiParam(value = "eg: black", required = true) String color,
                                                                                @RequestBody @ApiParam(value = "eg: 1512118972040", required = true) long lostTime) {
        return petOwnerService.findAnimalByCategoryAndBreedAndColorAfterLostTime(category, breed, color, new Timestamp(lostTime));
    }

    @ApiOperation(value = "Find the animal records which are near by the certain location.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(method = RequestMethod.GET, value = "/findByCertainLocation/{distance}/{latitude}/{longitude}/{unit}")
    public List<AnimalRecord> findByCertainLocation(@PathVariable @ApiParam(value = "eg: 200000", required = true) double distance,
                                                    @PathVariable @ApiParam(value = "eg: 22", required = true) double latitude,
                                                    @PathVariable @ApiParam(value = "eg: 233", required = true) double longitude,
                                                    @PathVariable  @ApiParam(value = "eg: M. M for mile, K for kilometer, N for nautical mile", required = true)String unit) {
        return petOwnerService.findAnimalWithinCertainLocation(distance, latitude, longitude, unit);
    }
}

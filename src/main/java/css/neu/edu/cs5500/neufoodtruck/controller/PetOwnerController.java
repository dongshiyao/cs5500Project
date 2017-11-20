package css.neu.edu.cs5500.neufoodtruck.controller;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import css.neu.edu.cs5500.neufoodtruck.service.PetOwnerService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/petOwner")
public class PetOwnerController {

    @Autowired
    private PetOwnerService petOwnerService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Yes, hello from owner";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByCategory/{category}")
    public List<AnimalRecord> findAnimalById(@PathVariable String category) {
        return petOwnerService.findAnimalByCategory(category);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByCategoryAndBreed/{category}/{breed}")
    public List<AnimalRecord> findAnimalByCategoryAndBreed(@PathVariable String category, @PathVariable String breed) {
        return petOwnerService.findAnimalByCategoryAndBreed(category, breed);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/findByCategoryAndColor/{category}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndColor(@PathVariable String category, @PathVariable String color) {
        return petOwnerService.findAnimalByCategoryAndColor(category, color);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByCategoryAndBreedAndColor/{category}/{breed}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColor(@PathVariable String category, @PathVariable String breed, @PathVariable String color) {
        return petOwnerService.findAnimalByCategoryAndBreedAndColor(category, breed, color);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAfterLostTime/{category}")
    public List<AnimalRecord> findAnimalByCategoryAfterLostTime(@PathVariable String category, @RequestBody Timestamp lostTime) {
        return petOwnerService.findAnimalByCategoryAfterLostTime(category, lostTime);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAndBreedAfterLostTime/{category}/{breed}")
    public List<AnimalRecord> findAnimalByCategoryAndBreedAfterLostTime(@PathVariable String category, @PathVariable String breed,@RequestBody Timestamp lostTime) {
        return petOwnerService.findAnimalByCategoryAndBreedAfterLostTime(category, breed, lostTime);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAndColorAfterLostTime/{category}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndColorAfterLostTime(@PathVariable String category, @PathVariable String color,@RequestBody Timestamp lostTime) {
        return petOwnerService.findAnimalByCategoryAndColorAfterLostTime(category, color, lostTime);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findByCategoryAndBreedAndColorAndFoundTimeAfter/{category}/{breed}/{color}")
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColorAfterLostTime(@PathVariable String category, @PathVariable String breed, @PathVariable String color,@RequestBody Timestamp lostTime) {
        return petOwnerService.findAnimalByCategoryAndBreedAndColorAfterLostTime(category, breed, color, lostTime);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByCertainLocation/{distance}/{latitude}/{longitude}/{unit}")
    public List<AnimalRecord> findByCertainLocation(@PathVariable double distance, @PathVariable double latitude, @PathVariable double longitude, @PathVariable String unit) {
        return petOwnerService.findAnimalWithinCertainLocation(distance, latitude, longitude, unit);
    }
}

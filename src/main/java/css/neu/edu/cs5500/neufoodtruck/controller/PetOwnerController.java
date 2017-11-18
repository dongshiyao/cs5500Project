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

    //Didn't tested
    @RequestMapping(method = RequestMethod.GET, value = "/findByCategoryAfterLostTime/{category}/{lostTime}")
    public List<AnimalRecord> findAnimalByCategoryAfterLostTime(@PathVariable String category, @PathVariable Timestamp lostTime) {
        return petOwnerService.findAnimalByCategoryAfterLostTime(category, lostTime);
    }
}

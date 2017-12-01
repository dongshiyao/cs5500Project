package css.neu.edu.cs5500.neufoodtruck.service;

import css.neu.edu.cs5500.neufoodtruck.dao.AnimalRecordRepository;
import css.neu.edu.cs5500.neufoodtruck.util.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;

@Component("petOwnerService")
@Transactional
public class PetOwnerServiceImpl implements PetOwnerService {

    private final AnimalRecordRepository animalRecordRepository;

    @Autowired
    public PetOwnerServiceImpl(AnimalRecordRepository animalRecordRepository) {
        this.animalRecordRepository = animalRecordRepository;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategory(String category) {
      return animalRecordRepository.findByCategory(category);
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreed(String category, String breed) {
      return animalRecordRepository.findByCategoryAndBreed(category, breed);
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndColor(String category, String color) {
      return animalRecordRepository.findByCategoryAndColor(category, color);
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColor(String category,
                                                                   String breed,
                                                                   String color) {
      return animalRecordRepository.findByCategoryAndBreedAndColor(category, breed, color);
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAfterLostTime(String category, Timestamp lostTime) {
      return animalRecordRepository.findByCategoryAndFoundTimeAfter(category, lostTime);
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreedAfterLostTime(String category,
                                                                        String breed,
                                                                        Timestamp lostTime) {
        return animalRecordRepository.findByCategoryAndBreedAndFoundTimeAfter(category, breed, lostTime);
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndColorAfterLostTime(String category,
                                                                        String color,
                                                                        Timestamp lostTime) {
      return animalRecordRepository.findByCategoryAndColorAndFoundTimeAfter(category, color, lostTime);
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColorAfterLostTime(String category,
                                                                                String breed,
                                                                                String color,
                                                                                Timestamp lostTime) {
        return animalRecordRepository.findByCategoryAndBreedAndColorAndFoundTimeAfter(category, breed, color, lostTime);
    }

    @Override
    public List<AnimalRecord> findAnimalWithinCertainLocation(double distance,
                                                              double latitude,
                                                              double longitude,
                                                              String unit) {
        List<AnimalRecord> animalList = new ArrayList<>();
        for (AnimalRecord animal : animalRecordRepository.findAll()) {
            if (DistanceCalculator.distance(animal.getFoundLocationLat(), animal.getFoundLocationLong(),
                latitude, longitude, unit) <= distance) {
                animalList.add(animal);
            }
        }
        return animalList;
    }
}

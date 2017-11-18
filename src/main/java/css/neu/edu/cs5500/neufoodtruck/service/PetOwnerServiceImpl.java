package css.neu.edu.cs5500.neufoodtruck.service;

import css.neu.edu.cs5500.neufoodtruck.dao.AnimalRecordRepository;
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

    public PetOwnerServiceImpl(AnimalRecordRepository animalRecordRepository) {
        this.animalRecordRepository = animalRecordRepository;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategory(String category) {
      List<AnimalRecord> sameCategoryList = new ArrayList<>();
      for (AnimalRecord animal : animalRecordRepository.findAll()) {
        if (animal.getCategory().equals(category)) {
          sameCategoryList.add(animal);
        }
      }
      return sameCategoryList;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreed(String category, String breed) {
      List<AnimalRecord> sameCategoryList = new ArrayList<>();
      for (AnimalRecord animal : animalRecordRepository.findAll()) {
        if (animal.getCategory() != null && animal.getCategory().equals(category)
            && animal.getBreed() != null && animal.getBreed().equals(breed)) {
          sameCategoryList.add(animal);
        }
      }
      return sameCategoryList;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndColor(String category, String color) {
      List<AnimalRecord> sameCategoryList = new ArrayList<>();
      for (AnimalRecord animal : animalRecordRepository.findAll()) {
        if (animal.getCategory() != null && animal.getCategory().equals(category)
            && animal.getColor() != null && animal.getColor().equals(color)) {
          sameCategoryList.add(animal);
        }
      }
      return sameCategoryList;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColor(String category, String breed, String color) {
      List<AnimalRecord> sameCategoryList = new ArrayList<>();
      for (AnimalRecord animal : animalRecordRepository.findAll()) {
        if (animal.getCategory() != null && animal.getCategory().equals(category)
            && animal.getBreed() != null && animal.getBreed().equals(breed)
            && animal.getColor() != null && animal.getColor().equals(color)) {
          sameCategoryList.add(animal);
        }
      }
      return sameCategoryList;
    }

    //Didn't tested
    @Override
    public List<AnimalRecord> findAnimalByCategoryAfterLostTime(String category, Timestamp lostTime) {
      List<AnimalRecord> sameCategoryList = new ArrayList<>();
      for (AnimalRecord animal : animalRecordRepository.findAll()) {
        if (animal.getCategory() != null && animal.getCategory().equals(category)
            && animal.getFoundTime().before(lostTime)) {
          sameCategoryList.add(animal);
        }
      }
      return sameCategoryList;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreedAfterLostTime(String category, String breed, Timestamp lostTime) {
        return null;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndColorAfterLostTime(String category, String color, Timestamp lostTime) {
        return null;
    }

    @Override
    public List<AnimalRecord> findAnimalByCategoryAndBreedAndColorAfterLostTime(String category, String breed, String color, Timestamp lostTime) {
        return null;
    }

    @Override
    public List<AnimalRecord> findAnimalWithinCertainLocation(List<AnimalRecord> recordList, double distance, double longitude, double latitude) {
        return null;
    }
}
